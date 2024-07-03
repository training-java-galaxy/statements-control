package com.training.statementscontrol.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static com.training.statementscontrol.constants.FintechConstants.ZERO;

/**
 * Representa un usuario en el sistema fintech.
 */
@Setter
@Getter
//@AllArgsConstructor

public class User {
    private UUID id;
    private String name;
    private double balance;

    public  User (UUID id, String name, double balance){
        this.id=id;
        this.name=name;
        this.balance=balance;

    }

    public  User(UUID id, String name){
        this.id=id;
        this.name=name;
        this.balance=ZERO;


    }

    public  User(String name, double balance) {
        this.name=name;
        this.balance=balance;


    }

}
