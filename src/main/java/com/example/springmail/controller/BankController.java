package com.example.springmail.controller;

import com.example.springmail.entity.Bank;
import com.example.springmail.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;
    @PostMapping("/get-all")
    public ResponseEntity<List<Bank>> getAll() {
        return ResponseEntity.ok(bankService.findAll());
    }
}
