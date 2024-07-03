package com.training.statementscontrol.model;

import com.training.statementscontrol.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//@AllArgsConstructor
public class Transaction {

    private String userId;
    private double amount;
    private TransactionType type;

    public Transaction(String userId, double amount, TransactionType type){
        this.userId=userId;
        this.type=type;
        this.amount=amount;


    }

    public Transaction(String userId, TransactionType type, double amount){
        this.userId=userId;
        this.type=type;
        this.amount=amount;


    }




}
