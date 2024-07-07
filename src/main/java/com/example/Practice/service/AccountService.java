package com.example.Practice.service;
import java.util.List;

import com.example.Practice.model.Account;

public interface AccountService {
List<Account> findAllAcounts();
void addAccount(Account account);
void deleteAccountById(long id);
Account findAccountById(long id); 
void changeBalane(long accountId, double n);
void transfer(long fromId, long toId, double n );

}
