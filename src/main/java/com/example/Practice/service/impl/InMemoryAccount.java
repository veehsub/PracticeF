package com.example.Practice.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.Practice.model.Account;
import com.example.Practice.repos.InMemoryAccountDAO;
import com.example.Practice.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InMemoryAccount implements AccountService {

  private final InMemoryAccountDAO repos ;
    @Override
    public List<Account> returnAllAcounts() {
        return repos.returnAllAccounts();
        
    }

    @Override
    public void addAccount(Account account) {
    repos.addAccount(account);  
    }

    @Override
    public void deleteAccountById(long id) {
    repos.deleteAccountById(id);
    }


    @Override
    public Account findAccountById(long id) {
        return repos.findAccountById(id);
  }

    @Override
    public void changeBalane(long accountId, double n) {
  
   repos.changeBalane(accountId, n);

      }

    @Override
    public void transfer( Account account, double n, Account recipient) {
     repos.transfer(account, n, recipient);
    }


}
