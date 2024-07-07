package com.example.springmail.service;

import com.example.springmail.entity.Bank;
import com.example.springmail.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }
}
