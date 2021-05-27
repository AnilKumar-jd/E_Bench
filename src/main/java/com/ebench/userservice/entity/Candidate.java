package com.ebench.userservice.entity;

/*
   @created by anil
   @created on on 17/5/21
   @project ebench
 */


import lombok.*;


import javax.persistence.*;
import java.util.Set;


@Entity
@Data
@Table(name = "candidate")
public class Candidate extends BaseEntity {

    @Column(name = "designation")
    public String designation;  // job title

    @Column(name = "skill")  //top five
    public String topSkills;

    @Column(name = "overview")
    public String overview;

    @Column(name = "resume_url")
    public String resumeUrl;

    @Column(name = "whatsapp_number")
    public String whatsAppNumber;

    @Column(name = "skypeId")
    public String skypeId;

    @Column(name = "linkdId")
    public String linkdId;

    @Column(name = "twitterId")
    public String twitterId;

    @Column(name = "country")
    public String country;

    @Column(name = "state")
    public String state;

    @Column(name = "city")
    public String city;

    @Column(name = "pincode")
    public String pincode;

    @Column(name = "hobby")
    public String hobby;

    @Column(name = "interest")
    public String interest;

    @Column(name = "active_status")
    public boolean activeStatus;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public Set<Skill> skill;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public Set<Education> education;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public Set<EmploymentHistory> employmentHistory ;

}
