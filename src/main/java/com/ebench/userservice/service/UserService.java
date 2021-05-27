package com.ebench.userservice.service;

import com.ebench.userservice.constants.APIMessage;
import com.ebench.userservice.dto.request.UserRegReqDTO;
import com.ebench.userservice.dto.response.RegistrationResDTO;
import com.ebench.userservice.entity.Candidate;
import com.ebench.userservice.entity.User;
import com.ebench.userservice.entity.Vendor;
import com.ebench.userservice.exceptionHandler.*;
import com.ebench.userservice.repository.CandidateRepository;
import com.ebench.userservice.repository.UserRepository;
import com.ebench.userservice.repository.VendorRepository;
import com.ebench.userservice.utils.Common;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    UserRepository userRepository;

    @Value("${spring.mail.username}")
    private String email;

    @Value("${spring.mail.password}")
    private String password;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    VendorRepository vendorRepository;

    public RegistrationResDTO register(UserRegReqDTO userDto, String siteUrl) {
        RegistrationResDTO registrationResDTO = new RegistrationResDTO();
        try {
            User user = new User();
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setUserType(userDto.getUserType());
            user.setEmailVerifyCode(Common.getRandomNumberString());
            user.setEmailVerified(false);
            user.setPassword(userDto.getPassword());
            User user1 = userRepository.save(user);
            if (String.valueOf(user1.getUserType()).equals("CANDIDATE")) {
                createCandidate(user1.getId());
            } else {
                createVendor(user1.getId());
            }
            sendVerificationEmail(user1, siteUrl);
            registrationResDTO.setId(user1.getId());
            registrationResDTO.setSuccess(APIMessage.REGISTRATION_SUCCESSFUL);
        } catch (Exception e) {
            throw new BadReqException(APIMessage.EMAIL_ALREADY_USED);
        }
        return registrationResDTO;
    }

    // create candidate for user....
    public void createCandidate(Long userId) {
        Candidate candidate = new Candidate();
        try {
            candidate.setUser(getUserbyId(userId));
            candidateRepository.save(candidate);
        } catch (Exception e) {
            throw new DefaultException(APIMessage.SOMETHING_ELSE_ERROR);
        }
    }

    // create vendor for user....
    public void createVendor(Long userId) {
        Vendor vendor = new Vendor();
        try {
            vendor.setUser(getUserbyId(userId));
            vendorRepository.save(vendor);
        } catch (Exception e) {
            throw new DefaultException(APIMessage.SOMETHING_ELSE_ERROR);
        }
    }

    private void sendVerificationEmail(User user, String siteURL)
            throws MessagingException, UnsupportedEncodingException {
        try {
            String toAddress = user.getEmail();
            String fromAddress = email;
            String senderName = "Ebench App";
            String subject = "Please verify your registration";
            String content = "Dear [[name]],<br>"
                    + "Please click the link below to verify your registration:<br>"
                    + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                    + "Thank you,<br>"
                    + "The Ebench Team";
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);
            content = content.replace("[[name]]", user.getName());
            String verifyURL = siteURL + "/api/v1/user/email/verify/" + user.getId() + "/" + user.getEmailVerifyCode();
            content = content.replace("[[URL]]", verifyURL);
            helper.setText(content, true);
            mailSender.send(message);
        } catch (Exception e) {
            log.error("error" + e);
        }

    }

    public Boolean emailVerify(Long uid, String code) {
        Boolean verifyStatus = false;
        try {
            Optional<User> user = userRepository.findById(uid);
            if (user.isPresent()) {
                User user1 = user.get();
                if (user1.getEmailVerifyCode().equals(code)) {
                    user1.setEmailVerified(true);
                    userRepository.save(user1);
                    verifyStatus = true;
                }
            } else {
                throw new ResourceNotFoundException(APIMessage.USER_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException(APIMessage.USER_NOT_FOUND);
            //  throw  new DefaultException(APIMessage.SOMETHING_ELSE_ERROR);
        }
        return verifyStatus;
    }

    // get user by id.....
    public User getUserbyId(Long userId) {
        User user = new User();
        try {
            Optional<User> user1 = userRepository.findById(userId);
            if (user1.isPresent()) {
                user = user1.get();
            } else {
                throw new ResourceNotFoundException(APIMessage.USER_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException(APIMessage.USER_NOT_FOUND);
            //  throw  new DefaultException(APIMessage.SOMETHING_ELSE_ERROR);
        }
        return user;
    }
}
