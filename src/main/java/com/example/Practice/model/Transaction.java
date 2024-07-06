package com.example.Practice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

 

@Data
@Entity
public class Transaction {
@Id    
private long transaction_id;

@ManyToOne
@JoinColumn(name = "from_account_id")
private Account fromAccount;

@ManyToOne
@JoinColumn(name = "to_account_id")
private Account toAccount;

@Column
@Enumerated(EnumType.STRING)
private TypeOfTransaction typeOfTransaction;
}
