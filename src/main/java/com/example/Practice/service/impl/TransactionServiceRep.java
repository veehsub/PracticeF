package com.example.Practice.service.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import com.example.Practice.model.Transaction;
import com.example.Practice.repos.TransactionRepository;
import com.example.Practice.service.TransactionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Primary
public class TransactionServiceRep  implements TransactionService{

private final TransactionRepository repository;

    @Override
    public void saveTransaction(Transaction transaction) {
        repository.save(transaction);
    }

    @Override
    public List<Transaction> findAllTransactionsByAccountId(long id) {
    return repository.findAllByF(id);
    }

}
