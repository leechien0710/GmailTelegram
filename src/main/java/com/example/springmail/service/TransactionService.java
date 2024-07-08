package com.example.springmail.service;

import com.example.springmail.common.HttpRes;
import com.example.springmail.dto.GetTransactionDto;
import com.example.springmail.dto.respone.GetTransactionRes;
import com.example.springmail.entity.Transaction;
import com.example.springmail.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    public GetTransactionRes getByAccountNumber(GetTransactionDto getTransactionDto){
            List<Transaction> transactions = transactionRepository.findByAccountNumber(getTransactionDto.getAccountNumber());
                return new GetTransactionRes(transactions);
    }
    public void createTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }
}
