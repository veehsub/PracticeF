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

  private final InMemoryAccountDAO repos;

  @Override
  public List<Account> findAllAcounts() {
    return repos.findAllAccounts();

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
  public void transfer(long fromId, long toId, double n) {
    n = 5;
  }

  @Override
  public void payment(long accountId, double n) {
   
    throw new UnsupportedOperationException("Unimplemented method 'payment'");
  }

  @Override
  public void replenishment(long accountId, double n) {
   
    throw new UnsupportedOperationException("Unimplemented method 'replenishment'");
  }

}
