package com.example.Practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
public class Card {
@Id   
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private long card_id; 

@ManyToOne
@JoinColumn(name = "account_id")
private Account account;

@Transient
private double balance;

public double getBalance()
{
    return account.getBalance();
}
}
