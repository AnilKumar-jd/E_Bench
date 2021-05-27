package com.ebench.userservice.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "vendor")
public class Vendor extends BaseEntity{

    @Column(name = "company_Number")
    public String companyNumber;

    @Column(name = "company_status")
    public String companyStatus;

    @Column(name = "company_expiry_date")
    public String companyExpiryDate;

    @Column(name = "company_name")
    public String countryName;

    @Column(name = "phone_number")
    public String phoneNumber;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public User user;

}
