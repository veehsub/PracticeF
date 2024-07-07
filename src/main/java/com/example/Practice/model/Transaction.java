package com.example.Practice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

 

@Data
@Entity
public class Transaction {
@Id   
@GeneratedValue(strategy = GenerationType.AUTO)
private long transaction_id;

@ManyToOne
@JoinColumn(name = "from_account_id", nullable =  false)
private Account fromAccount;


@ManyToOne
@JoinColumn(name = "to_account_id", nullable = true)
private Account toAccount;

@Column
@Enumerated(EnumType.STRING)
private TypeOfTransaction typeOfTransaction;

@Column
private double transaction_sum;


// public Transaction(Account fromAccount, Account toAccount,  double transaction_sum)
// {
// this.transaction_sum = transaction_sum;
// this.fromAccount = fromAccount;
// this.toAccount = toAccount;
// if(toAccount != null)
// {
//     this.typeOfTransaction = TypeOfTransaction.Transfer;
// }
// else
// {
//     if(transaction_sum<0){
// this.typeOfTransaction = TypeOfTransaction.Payment;
//     }
//     else
//     {
//         this.typeOfTransaction = TypeOfTransaction.Replenishment;
//     }
// }
// }

 }

