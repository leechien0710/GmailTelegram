package com.example.springmail.service;

import com.example.springmail.common.HttpRes;
import com.example.springmail.dto.SaveAccountDto;
import com.example.springmail.dto.respone.SaveAccountRes;
import com.example.springmail.entity.Account;
import com.example.springmail.entity.Bank;
import com.example.springmail.repository.AccountRepository;
import com.example.springmail.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BankRepository bankRepository;
    public SaveAccountRes saveAccount(SaveAccountDto  saveAccountDto){
        Account account = new Account();
        Bank bank = bankRepository.findByBankName(saveAccountDto.getBankName());
        if(bank == null){
            return new SaveAccountRes(new HttpRes("400","Bank Not Found"));
        }
        account.setAccountHolder(saveAccountDto.getAccountHolder());
        account.setBankId(bank.getId());
        account.setAccountName(saveAccountDto.getAccountName());
        account.setAccountNumber(saveAccountDto.getAccoountNumber());
        account.setBalance(0L);
        account.setLastUpdated(new Date());
        try{
            accountRepository.save(account);
        }catch (Exception e){
            return new SaveAccountRes(new HttpRes("400","Save Account Failed"));
        }
        return new SaveAccountRes(new HttpRes("200","Save Account Success"));
    }
}
