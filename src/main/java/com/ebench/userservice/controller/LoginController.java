package com.ebench.userservice.controller;


import com.ebench.userservice.constants.APIMessage;
import com.ebench.userservice.entity.PatientProfile;
import com.ebench.userservice.repository.JsonRepo;
import com.ebench.userservice.service.LoginService;
import com.ebench.userservice.utils.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class LoginController {
    @Autowired
    LoginService loginervice;

    @Autowired
    JsonRepo jsonRepo;

    /*
     * User Login Verification : GET
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity userLogin(@RequestParam String email, @RequestParam String password) throws JsonProcessingException {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, loginervice.login(email, password), APIMessage.LOGIN_SUCCESSFUL);
        return apiResponse.getResponse(apiResponse);
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = "application/json")
    public List<PatientProfile> json() throws JsonProcessingException {
        List<PatientProfile> dto = jsonRepo.findAll();
        return dto;
    }
}
