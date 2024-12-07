package com.example.Practice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practice.model.Transaction;
import com.example.Practice.service.TransactionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/transaction")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/account/{id}")
    public List<Transaction> findAllTransactionsById(@PathVariable long id) {
        return transactionService.findAllTransactionsByAccountId1(id);
    }
}
