package com.example.Practice.service.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.Practice.model.Account;
import com.example.Practice.model.Transaction;
import com.example.Practice.model.TransactionType;
import com.example.Practice.repos.TransactionRepository;
import com.example.Practice.service.TransactionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Primary
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Override
    public void saveTransaction(Account accountFrom,Account accountTo, double sumOftransaction) {
       
        Transaction transaction = new Transaction();
        transaction.setTransactionSum(Math.abs(sumOftransaction));
        transaction.setFromAccount(accountFrom);
        transaction.setToAccount(accountTo);
        if(accountTo==null){
        if (sumOftransaction < 0) {
            transaction.setTypeOfTransaction(TransactionType.Payment);
        } else {
            transaction.setTypeOfTransaction(TransactionType.Replenishment);
        }}
        else {transaction.setTypeOfTransaction(TransactionType.Transfer);}
        
        repository.save(transaction);
    }

    @Override
    public List<Transaction> findAllTransactionsByAccountId1(long accountId) {
        return repository.findAllByTransactionsByAccountId1(accountId);
    }

}
