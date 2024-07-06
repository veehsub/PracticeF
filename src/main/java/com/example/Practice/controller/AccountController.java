package com.example.Practice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practice.model.Account;
import com.example.Practice.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/main")
@AllArgsConstructor
public class AccountController {

    private final AccountService service;
    
    @GetMapping
    public List<Account> findAllAccounts()
{

return service.findAllAcounts();
}

@PostMapping("save")
public String addAccount(@RequestBody Account account)
{
service.addAccount(account);
return "Account has been successfully created";
}

@DeleteMapping("delete/{id}")
public String deleteAccountById(@PathVariable long id)
{
    service.deleteAccountById(id);
    return "Account has been successfully deleted";
}

@GetMapping("/{id}")
public Account findAccountById(@PathVariable long id)
{
    return service.findAccountById(id);
}

@PutMapping("/change/{accountId}/{n}")
public String changeBalance(@PathVariable long accountId, @PathVariable double n)
{
service.changeBalane(accountId, n);
String message;
if(n<0)
{
    message = "Payment is successful";
}
else {message = "Replenishment is successful";}
return message;
}

@PutMapping("/transfer/{from}/{to}/{n}")
public String transfer(@PathVariable long from,@PathVariable long to,@PathVariable double n)
{
    String message;
    if(n<=0)
    {
        message = "Так нельзя";
    }
    else 
    {
message = "Перевод успешен";
service.changeBalane(to, n);
service.changeBalane(from, -n);
    }
    return message;
}



}
