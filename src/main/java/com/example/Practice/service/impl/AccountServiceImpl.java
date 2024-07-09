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
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
  
    private final TransactionServiceImpl transactionService;

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
    public void payment(long accountId, double n) throws Exception {
        
        Account account = repository.findById(accountId).get();
        if(account.getBalance()<n)
        {
            throw new Exception();
        }
        transactionService.saveTransaction(account,null, -n);

        repository.setBalance(accountId, account.getBalance() - n);
    }

    @Override
    public void replenishment(long accountId, double n) {
        
        Account account = repository.findById(accountId).get();
        transactionService.saveTransaction(account,null, n);

        repository.setBalance(accountId, account.getBalance() + n);
    }

    @Override
    public void transfer(long fromId, long toId, double n) throws Exception {
        Account accountFrom = findAccountById(fromId);
        Account accountTo = findAccountById(toId);
        
        if(accountFrom.getBalance()<n)
        {
            throw new Exception();
        }
        transactionService.saveTransaction(accountFrom, accountTo, n);

        repository.setBalance(fromId, accountFrom.getBalance()-n);
        repository.setBalance(toId, accountTo.getBalance()+n);

    }

    @Override
    public List<Account> findAllAcounts() {
        return repository.findAll();
    }

}
