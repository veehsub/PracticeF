package com.example.Practice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Practice.model.Card;


import jakarta.transaction.Transactional;

public interface CardRepository extends JpaRepository<Card, Long  >{



      @Transactional
     @Query(nativeQuery =  true, value =  " SELECT * FROM card where account_id =:id ")
     List<Card> findAllByAccountI(@Param("id")Long id); 
}
