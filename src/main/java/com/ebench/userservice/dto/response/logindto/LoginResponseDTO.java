package com.ebench.userservice.dto.response.logindto;

import com.ebench.userservice.entity.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponseDTO {
    Long id;
    String email;
    String name;
    String phoneNumber;
    UserType userType;

    public LoginResponseDTO(Long id, String email, String name, String phoneNumber, UserType userType) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }

    public LoginResponseDTO() {
    }
}
