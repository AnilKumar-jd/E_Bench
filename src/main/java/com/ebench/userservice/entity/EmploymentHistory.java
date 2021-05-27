package com.ebench.userservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "employment_history")
public class EmploymentHistory  extends BaseEntity {

    @Column(name = "company_name")
    public String companyName;

    @Column(name = "end_Date")
    public String endDate;

    @Column(name = "start_Date")
    public String startDate;

    @Column(name = "total_year")
    public String totalYear;

    @Column(name = "job_title")
    public String jobTitle;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    public Candidate candidate;
}
