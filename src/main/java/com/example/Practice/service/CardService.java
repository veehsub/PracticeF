package com.example.Practice.service;

import java.util.List;

import com.example.Practice.model.Card;

public interface CardService  {
void save(Card card);
void deleteCardById(long id);
List<Card> findAllCardsByAccountId(long id);

}
