package com.example.Practice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Practice.model.Account;

import jakarta.transaction.Transactional;

public interface AccountRepository  extends JpaRepository <Account, Long>{

    @Modifying
    @Transactional
    @Query("UPDATE Account  SET balance = balance + :balanceChange WHERE accountId = :accountId")
    void setBalance(@Param("accountId") Long accountId, @Param("balanceChange") double balanceChange); }