package com.ebench.userservice.controller;

import com.ebench.userservice.constants.APIMessage;
import com.ebench.userservice.dto.request.UserRegReqDTO;
import com.ebench.userservice.service.UserService;
import com.ebench.userservice.utils.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api/v1/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserService userService;

    /*
     * user Registration as candidate or vendor: POST
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity candidateSignup(@RequestBody UserRegReqDTO reqDto,HttpServletRequest request) throws JsonProcessingException {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, userService.register(reqDto,getSiteURL(request)), APIMessage.API_MESSAGE);
        return apiResponse.getResponse(apiResponse);
    }
    /*
     * email verification
     */
    @RequestMapping(value = "/email/verify/{uid}/{code}", method = RequestMethod.GET)
    public ResponseEntity emailVerify(@PathVariable("uid") Long uid, @PathVariable("code") String code) throws JsonProcessingException {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, userService.emailVerify(uid,code), APIMessage.API_MESSAGE);
        return apiResponse.getResponse(apiResponse);
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}
