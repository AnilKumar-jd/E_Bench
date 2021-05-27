package com.ebench.userservice.service;

import com.ebench.userservice.constants.APIMessage;
import com.ebench.userservice.dto.response.logindto.LoginResponseDTO;
import com.ebench.userservice.exceptionHandler.ResourceNotFoundException;
import com.ebench.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {

    @Autowired
    UserRepository userRepository;
    public LoginResponseDTO login(String email, String password) {
            LoginResponseDTO dto = new LoginResponseDTO();
            try {
                dto = userRepository.findByEmailandPass(email, password);
                log.info("erro"+dto.toString());
                if (dto != null){
                    return dto;}
                else{
                    throw new ResourceNotFoundException(APIMessage.WRONG_CREDENTIAL);
                }
            }
            catch(Exception e)
                {
                    throw new ResourceNotFoundException(APIMessage.WRONG_CREDENTIAL);
                }
    }
}