package com.ebench.userservice.dto.response;


import com.ebench.userservice.entity.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DashboardDetailResDTO {
    public Long userId;
    public String name;
    public String phoneNumber;
    public String email;
    public UserType userType;
    public String imageUrl;
    public boolean emailVerified;
    public LocalDateTime createdAt;
    // vendor details
    // company details
    // other common details
}
