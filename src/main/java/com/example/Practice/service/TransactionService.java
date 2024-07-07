package com.example.Practice.service;

import java.util.List;


import com.example.Practice.model.Transaction;

public interface TransactionService {
 void saveTransaction(Transaction transaction);
 List<Transaction> findAllTransactionsByAccountId(long id);
 
}
