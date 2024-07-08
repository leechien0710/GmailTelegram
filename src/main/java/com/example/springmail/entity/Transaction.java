package com.example.springmail.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inOut; // Tiền vào hoặc ra

    private String cumulative; // Lũy kế

    private LocalDateTime timestamp; // Thời gian giao dịch

    private String content; // Nội dung giao dịch

    private int activity; // Hoạt động (Gửi tin tele: 0 1 2)

    private String details; // Chi tiết giao dịch

    private String accountNumber; // ID của tài khoản liên quan đến giao dịch

    // Các getters và setters (có thể sử dụng lombok để tự động sinh)
    public Transaction() {}
    public Transaction(String inOut, String cumulative, LocalDateTime timestamp, String content, int activity, String details, String accountNumber) {
        this.inOut = inOut;
        this.cumulative = cumulative;
        this.timestamp = timestamp;
        this.content = content;
        this.activity = activity;
        this.details = details;
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getCumulative() {
        return cumulative;
    }

    public void setCumulative(String cumulative) {
        this.cumulative = cumulative;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getActivity() {
        return activity;
    }

    public void setActivity(Integer activity) {
        this.activity = activity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }
}

