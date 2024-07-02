package com.example.springmail.service;

import com.example.springmail.entity.Bank;
import com.example.springmail.repository.BankRepository;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;
    public List<Bank> findAll() {
        return bankRepository.findAll();
    }
}
