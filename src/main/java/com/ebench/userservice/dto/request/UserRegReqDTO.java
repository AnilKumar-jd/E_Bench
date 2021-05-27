package com.ebench.userservice.dto.request;

import com.ebench.userservice.entity.Candidate;
import com.ebench.userservice.entity.Vendor;
import com.ebench.userservice.entity.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRegReqDTO {

    public String name;
    public String phoneNumber;
    public String email;
    public UserType userType;
    public String imageUrl;
    public String password;
    public String location;


}
