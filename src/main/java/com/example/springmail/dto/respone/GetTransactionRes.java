package com.example.springmail.dto.respone;

import com.example.springmail.entity.Transaction;

import java.util.List;

public class GetTransactionRes {
    private List<Transaction> transactions;
    public GetTransactionRes(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
