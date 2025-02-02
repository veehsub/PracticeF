package com.example.Practice.model;


import jakarta.persistence.CascadeType;
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
    @Column(name =  "transaction_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transactionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_account_id", nullable = false)
    private Account fromAccount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "to_account_id", nullable = true)
    private Account toAccount;

    @Column(name =  "type_of_transaction")
    @Enumerated(EnumType.STRING)
    private TransactionType typeOfTransaction;

    @Column(name = "transaction_sum")
    private double transactionSum;

    // public Transaction(Account fromAccount, Account toAccount, double
    // transaction_sum)
    // {
    // this.transaction_sum = transaction_sum;
    // this.fromAccount = fromAccount;
    // this.toAccount = toAccount;
    // if(toAccount != null)
    // {
    // this.typeOfTransaction = TypeOfTransaction.Transfer;
    // }
    // else
    // {
    // if(transaction_sum<0){
    // this.typeOfTransaction = TypeOfTransaction.Payment;
    // }
    // else
    // {
    // this.typeOfTransaction = TypeOfTransaction.Replenishment;
    // }
    // }
    // }

}
