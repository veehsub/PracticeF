package com.example.Practice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Practice.model.Card;

public interface CardRepository extends JpaRepository<Card, Integer >{

}
