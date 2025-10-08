package com.cfs.paymentgateway.entity;


import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name ="payment_order")
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name ;

    private String Email;

    private String Phone;

    private String CourseName;

    private Double Amount;

    private String OrderId;

    private String PaymentId;

    private String Status;

    private  LocalDateTime CratedAt;

    public PaymentOrder() {

    }

    public PaymentOrder(Long id, String name, String email, String phone, String courseName, Double amount, String orderId, String paymentId, String status, LocalDateTime cratedAt) {
        this.id = id;
        Name = name;
        Email = email;
        Phone = phone;
        CourseName = courseName;
        Amount = amount;
        OrderId = orderId;
        PaymentId = paymentId;
        Status = status;
        CratedAt = cratedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(String paymentId) {
        PaymentId = paymentId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LocalDateTime getCratedAt() {
        return CratedAt;
    }

    public void setCratedAt(LocalDateTime cratedAt) {
        CratedAt = cratedAt;
    }
}


