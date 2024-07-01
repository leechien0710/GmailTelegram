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

    private float inOut; // Tiền vào hoặc ra

    private float cumulative; // Lũy kế

    private LocalDateTime timestamp; // Thời gian giao dịch

    private String content; // Nội dung giao dịch

    private int activity; // Hoạt động (Gửi tin tele: 0 1 2)

    private String details; // Chi tiết giao dịch

    private Long accountId; // ID của tài khoản liên quan đến giao dịch

    // Các getters và setters (có thể sử dụng lombok để tự động sinh)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getInOut() {
        return inOut;
    }

    public void setInOut(float inOut) {
        this.inOut = inOut;
    }

    public float getCumulative() {
        return cumulative;
    }

    public void setCumulative(float cumulative) {
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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}

