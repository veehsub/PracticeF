package com.example.Practice.service;

import java.util.List;

import com.example.Practice.model.Account;
import com.example.Practice.model.Transaction;

public interface TransactionService {
    void saveTransaction(Account accountFrom, Account accountTo,  double sumOfTransaction);

    List<Transaction> findAllTransactionsByAccountId1(long accountId);

}
