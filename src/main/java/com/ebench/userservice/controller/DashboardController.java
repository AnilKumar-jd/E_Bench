package com.ebench.userservice.controller;


import com.ebench.userservice.service.DashboardService;
import com.ebench.userservice.utils.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/dashboard")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

     // user complete detail.........
    @RequestMapping(value = "user/detail", method = RequestMethod.GET,  produces = "application/json")
    public ResponseEntity detail(@RequestParam Long userid) throws JsonProcessingException {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, true, dashboardService.dashboardDetails(userid),"Successfully executed");
        return apiResponse.getResponse(apiResponse);
    }
}
