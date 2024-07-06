package com.example.Practice.service.impl;

import java.util.List;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.Practice.model.Account;
import com.example.Practice.repos.AccountRepository;
import com.example.Practice.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Primary
public class AccountServiceRep implements AccountService {
    
private final AccountRepository repository;  


    @Override
    public void addAccount(Account account) {
repository.save(account);
      }

    @Override
    public void deleteAccountById(long id) {
        repository.deleteById(id);
   }

    @Override
    public Account findAccountById(long id) {
   return repository.findById(id).get();
   

    }
    @Override
    public void changeBalane(long accountId, double n) {
     repository.setBalance(accountId, n);
    }

    @Override
    public void transfer(Account account, double n, Account recipient) {
        repository.setBalance(account.getAccountId(), -n);
        repository.setBalance(recipient.getAccountId(), n);
     }

    @Override
    public List<Account> findAllAcounts() {
   return repository.findAll();
    }


}
