package com.ebench.userservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "subscription")
public class Subscription extends BaseEntity{

    @Column(name = "free")
    public String free;

    @Column(name = "silver")
    public String silver;

    @Column(name = "gold")
    public String gold;
}
