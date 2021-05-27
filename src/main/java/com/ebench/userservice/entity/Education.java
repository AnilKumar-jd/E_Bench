package com.ebench.userservice.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "education")
public class Education  extends BaseEntity{
    @Column(name = "education_name")
    public String educationName;

    @Column(name = "passing_year")
    public String passingYear;

    @Column(name = "starting_year")
    public String startingYear;

    @Column(name = "institute_name")
    public String instituteName;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    public Candidate candidate;
}
