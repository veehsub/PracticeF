package com.example.Practice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Card {
@Id   
@GeneratedValue(strategy = GenerationType.IDENTITY) 
private int card_id; 

@ManyToOne
@JoinColumn(name = "account_id")
private Account account;


}
