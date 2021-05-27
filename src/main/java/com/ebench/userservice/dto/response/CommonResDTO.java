package com.ebench.userservice.dto.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonResDTO {
    Long id;
    Boolean success;
    String description;

    public void setSuccess(String successDescription){
        this.success = true;
        this.description = successDescription;
    }
    public void setFailure(String errorDescription){
        this.description = errorDescription;
        this.success = false;
    }
}
