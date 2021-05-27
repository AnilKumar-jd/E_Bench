package com.ebench.userservice.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "skill")
public class Skill extends BaseEntity {
    @Column(name = "skill")
    public String skill;

    @Column(name = "experience")
    public String experience;

    @Column(name = "rating")
    public int rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    public Candidate candidate;
}
