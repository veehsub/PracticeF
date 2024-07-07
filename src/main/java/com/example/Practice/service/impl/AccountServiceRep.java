package com.example.Practice.service.impl;

import java.util.List;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.Practice.model.Account;
import com.example.Practice.model.Transaction;
import com.example.Practice.model.TypeOfTransaction;
import com.example.Practice.repos.AccountRepository;

import com.example.Practice.service.AccountService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Primary
public class AccountServiceRep implements AccountService {
    
private final AccountRepository repository;  
private final TransactionServiceRep transactionRepository;

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
    Account account = findAccountById(accountId);
     Transaction transaction = new Transaction();
     transaction.setTransaction_sum(Math.abs(n));
     transaction.setFromAccount(account);
    
     if(n<0){transaction.setTypeOfTransaction(TypeOfTransaction.Payment);}
     else{transaction.setTypeOfTransaction(TypeOfTransaction.Replenishment);}

transactionRepository.saveTransaction(transaction);

     repository.setBalance(accountId, n);
    }

    @Override
    public void transfer(long fromId, long toId, double n) {
        Account accountFrom = findAccountById(fromId);
        Account accountTo = findAccountById(toId);
        Transaction transaction = new Transaction();
        transaction.setTransaction_sum(Math.abs(n));
        transaction.setFromAccount(accountFrom);
        transaction.setToAccount(accountTo);
       transaction.setTypeOfTransaction(TypeOfTransaction.Transfer);
        transactionRepository.saveTransaction(transaction);

        repository.setBalance(fromId, -n);
        repository.setBalance(toId, n);

     }

    @Override
    public List<Account> findAllAcounts() {
   return repository.findAll();
    }


}
