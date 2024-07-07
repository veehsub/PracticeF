package com.example.Practice.service.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.Practice.model.Card;
import com.example.Practice.repos.CardRepository;
import com.example.Practice.service.CardService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Primary
public class CardServiceRep implements CardService {

    private final CardRepository repository;
    @Override
    public void save(Card card) {


      repository.save(card);
    }

    @Override
    public void deleteCardById(long id) {
      repository.deleteById(id);;
    }

    @Override
    public List<Card> findAllCardsByAccountId(long id) {
       return repository.findAllByAccountI(id);

    }

}
