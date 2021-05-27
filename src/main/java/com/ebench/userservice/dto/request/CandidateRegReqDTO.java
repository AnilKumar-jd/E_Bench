package com.ebench.userservice.dto.request;

import com.ebench.userservice.entity.Education;
import com.ebench.userservice.entity.EmploymentHistory;
import com.ebench.userservice.entity.Skill;
import com.ebench.userservice.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandidateRegReqDTO {

    public Long userId;
    public String designation;  // job title
    public String topSkills;  // top five
    public String overview;
    public String resumeUrl;
    public String whatsAppNumber;
    public String skypeId;
    public String linkdId;
    public String twitterId;
    public String country;
    public String state;
    public String city;
    public String pincode;
    public String hobby;
    public String interest;
    public boolean activeStatus;


}
