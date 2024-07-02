package com.example.springmail.dto;

public class SaveAccountDto {
    private Long userId;
    private String bankName;
    private String accoountNumber;
    private String accountHolder;
    private String accountName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccoountNumber() {
        return accoountNumber;
    }

    public void setAccoountNumber(String accoountNumber) {
        this.accoountNumber = accoountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
