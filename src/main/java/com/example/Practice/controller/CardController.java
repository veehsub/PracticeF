package com.example.Practice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practice.model.Account;
import com.example.Practice.model.Card;
import com.example.Practice.service.AccountService;
import com.example.Practice.service.CardService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/card")
@AllArgsConstructor
public class CardController {

    private final AccountService accountService;
    private final CardService cardService;

    @GetMapping("/account/{id}")
    public List<Card> findAllCardsById(@PathVariable long id) {
        return cardService.findAllCardsByAccountId(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCardById(@PathVariable long id) {

        cardService.deleteCardById(id);
        return "Card has been successfully deleted";
    }

    @PostMapping("/save/{accId}")
    public String addCard(@PathVariable long accId) {
        Account account = accountService.findAccountById(accId);
        Card card = new Card();
        card.setAccount(account);
        cardService.save(card);
        return "Card has been successfully created";
    }

}
