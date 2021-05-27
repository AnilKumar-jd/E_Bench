package com.ebench.userservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "jobs")
public class Job extends BaseEntity {
    @Column(name = "search_job")
    public String searchJob;

    @Column(name = "job_type")
    public String jobType;

    @Column(name = "relevance")
    public String relevance;

    @Column(name = "date")
    public String date;

    @Column(name = "job_duration")
    public String job_Duration;

    @Column(name = "time_zone")
    public String timeZone;
}
