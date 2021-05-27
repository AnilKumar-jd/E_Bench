package com.ebench.userservice.controller;


import com.ebench.userservice.constants.APIMessage;
import com.ebench.userservice.dto.request.CandidateRegReqDTO;
import com.ebench.userservice.service.SignUpService;
import com.ebench.userservice.utils.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SignupController {

    @Autowired
    SignUpService signUpService;
    /*
     * candidate Registration first step  : POST
     */
    @RequestMapping(value = "/candidate/registration", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity candidateSignup(@RequestBody CandidateRegReqDTO reqDto) throws JsonProcessingException {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, signUpService.register(reqDto), APIMessage.REGISTRATION_SUCCESSFUL);
        return apiResponse.getResponse(apiResponse);
    }
}
