package com.example.Practice.repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.Practice.model.Account;
@Repository
public class InMemoryAccountDAO {

    public List<Account>  ACCOUNTS = new ArrayList<>();

public List<Account> returnAllAccounts()
{
return ACCOUNTS;
}

public Account findAccountById(long id){
   
    return ACCOUNTS.stream().filter(element-> element.getAccountId()==id).findFirst().orElse(null);
}

public void addAccount(Account account)
{
ACCOUNTS.add(account);
}

public void deleteAccountById(long id){
var account = findAccountById(id);

if(account!= null){ACCOUNTS.remove(account);
}
}
}
