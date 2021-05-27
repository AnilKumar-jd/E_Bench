package com.ebench.userservice.entity;


import com.ebench.userservice.entity.enums.UserType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User extends  BaseEntity {

    @Column(name = "name")
    public String name;

    @Column(name = "phone_number", nullable = false)
    public String phoneNumber;

    @Column(name = "email", nullable = false,unique = true)
    public String email;

    @Column(name = "user_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public UserType userType;

    @Column(name = "image_url")
    public String imageUrl;

    @Column(name = "password")
    public String password;

    @Column(name = "location")
    public String location;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public Candidate candidate;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public Vendor vendor;

    @Column(name = "email_verification_code")
    public String emailVerifyCode;

    @Column(name = "email_verified")
    public boolean emailVerified;
}
