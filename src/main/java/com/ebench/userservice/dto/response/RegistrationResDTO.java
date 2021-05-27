package com.ebench.userservice.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationResDTO {
    Long id;
    Boolean success;
    String errorDescription;

    public void setSuccess(String successDescription){
        this.success = true;
        this.errorDescription = successDescription;
    }
    public void setFailure(String errorDescription){
        this.errorDescription = errorDescription;
        this.success = false;
    }



}
