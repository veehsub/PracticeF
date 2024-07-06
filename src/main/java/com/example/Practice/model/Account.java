package com.example.Practice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long accountId;
@Column
private double balance;


//  @ManyToOne
//  @JoinColumn(name = "user_id")
private long user_id;

}
