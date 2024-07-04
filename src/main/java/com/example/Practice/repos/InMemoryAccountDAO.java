package com.example.Practice.repos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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


public void changeBalane(long accountId, double n) {
   
    var accountIndex =  IntStream.range(0, ACCOUNTS.size())
                     .filter(index -> ACCOUNTS.get(index).getAccountId()==accountId)
                    .findFirst().orElse(-1) ;
                    
                    if (accountIndex>-1)
                    {
                    

                    ACCOUNTS.get(accountIndex).setBalance(ACCOUNTS.get(accountIndex).getBalance()+n);
                    
                    }           
}


public void transfer( Account sendAccount, double n, Account getAccount) {
    
    var sendAccountIndex = IntStream.range(0, ACCOUNTS.size())
    .filter(index -> ACCOUNTS.get(index).getAccountId()==sendAccount.getAccountId())
    .findFirst().orElse(-1) ;

    var getAccountIndex = IntStream.range(0, ACCOUNTS.size())
    .filter(index -> ACCOUNTS.get(index).getAccountId()==getAccount.getAccountId())
    .findFirst().orElse(-1) ;

    if ((sendAccountIndex>-1)&&(getAccountIndex>-1))
    {
        sendAccount.setBalance(sendAccount.getBalance()-n);
        getAccount.setBalance(getAccount.getBalance()+n);
        ACCOUNTS.set(sendAccountIndex, sendAccount);
        ACCOUNTS.set(getAccountIndex, getAccount);
    }  


}

}
