package com.ebench.userservice.service;
/*
   @created by anil
   @created on on 17/5/21
   @project ebench
 */



import com.ebench.userservice.constants.APIMessage;
import com.ebench.userservice.dto.response.*;
import com.ebench.userservice.entity.*;
import com.ebench.userservice.exceptionHandler.*;
import com.ebench.userservice.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DashboardService {
    @Autowired
    UserRepository userRepository;
        public DashboardDetailResDTO dashboardDetails(Long userid) {
        DashboardDetailResDTO dto = new DashboardDetailResDTO();
        try {
            Optional<User> user = userRepository.findById(userid);
            if (user.isPresent()) {
                User user1 = user.get();
                dto.setUserId(user1.getId());
                dto.setName(user1.getName());
                dto.setEmail(user1.getEmail());
                dto.setPhoneNumber(user1.getPhoneNumber());
                dto.setImageUrl(user1.getImageUrl());
                dto.setEmailVerified(user1.emailVerified);
                dto.setCreatedAt(user1.getCreatedAt());
                dto.setUserType(user1.getUserType());
            } else {
                throw new ResourceNotFoundException(APIMessage.USER_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException(APIMessage.USER_NOT_FOUND);
            //  throw  new DefaultException(APIMessage.SOMETHING_ELSE_ERROR);
        }
        return dto;
    }
}
