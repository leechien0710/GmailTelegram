package com.example.springmail.controller;

import com.example.springmail.dto.GetTransactionDto;
import com.example.springmail.dto.respone.GetTransactionRes;
import com.example.springmail.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("get-by-account")
    public ResponseEntity<GetTransactionRes> getTransactionByAccountId(@RequestBody GetTransactionDto getTransactionDto) {
        return ResponseEntity.ok(transactionService.getByAccountID(getTransactionDto));
    }
}
