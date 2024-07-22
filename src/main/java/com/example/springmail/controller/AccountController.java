package com.example.springmail.controller;

import com.example.springmail.dto.SaveAccountDto;
import com.example.springmail.dto.respone.SaveAccountRes;
import com.example.springmail.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/save")
    public ResponseEntity<SaveAccountRes> saveAccount(@RequestBody SaveAccountDto saveAccountDto) {
        return ResponseEntity.ok(accountService.saveAccount(saveAccountDto));
    }

}
