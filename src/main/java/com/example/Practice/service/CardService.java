package com.example.Practice.service;

import java.util.List;

import com.example.Practice.model.Card;

public interface CardService  {
void save(Card card);
void delete(Card card);
List<Card> findAllCardsByAccountId(long id);
double getCardBalance();
}
