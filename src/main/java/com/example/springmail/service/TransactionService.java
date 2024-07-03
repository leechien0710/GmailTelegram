package com.example.springmail.service;

import com.example.springmail.common.HttpRes;
import com.example.springmail.dto.GetTransactionDto;
import com.example.springmail.dto.respone.GetTransactionRes;
import com.example.springmail.entity.Transaction;
import com.example.springmail.repository.TransactionRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    public GetTransactionRes getByAccountID(GetTransactionDto getTransactionDto){
            List<Transaction> transactions = transactionRepository.findByAccountId(getTransactionDto.getAccountId());
                return new GetTransactionRes(transactions);
    }
}
