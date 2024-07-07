package com.example.Practice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.Practice.model.Transaction;

import jakarta.transaction.Transactional;

public interface TransactionRepository extends JpaRepository <Transaction, Long> {
   
     @Transactional
     @Query(nativeQuery =  true, value =  " SELECT * FROM transaction where from_account_id =:id ")
     List<Transaction> findAllByF(@Param("id")Long id); 
}
