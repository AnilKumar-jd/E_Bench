package com.ebench.userservice.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "payment_management")
public class PaymentManagement extends BaseEntity{
    @Column(name = "received")
    public String received;

    @Column(name = "due")
    public String due;

    @Column(name = "cancelled")
    public String cancelled;

    @Column(name = "raise_invoice")
    public String raiseInvoice;

    @Column(name = "send_reminder")
    public String sendReminder;

    @Column(name = "payment_modes")
    public String paymentMode;

    @Column(name = "add_payment_mode")
    public String addpaymetMode;

    @Column(name = "payment_gateway")
    public String paymentGateway;
}
