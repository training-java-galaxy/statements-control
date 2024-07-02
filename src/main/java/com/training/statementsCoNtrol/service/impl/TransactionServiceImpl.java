package com.training.statementsCoNtrol.service.impl;


import com.training.statementsCoNtrol.enums.TransactionType;
import com.training.statementsCoNtrol.model.Transaction;
import com.training.statementsCoNtrol.model.User;
import com.training.statementsCoNtrol.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Servicio para manejar las operaciones relacionadas con transacciones.
 */
@Service
public class TransactionServiceImpl {
    private final List<Transaction> transactions = new ArrayList<>();
    private final UserServiceImpl userService;

    public TransactionServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    public Transaction createTransaction(UUID userId, TransactionType type, double amount) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return null;
        }

        // Ejemplo de uso de estructuras de control
        switch (type) {
            case DEPOSIT:
                user.setBalance(user.getBalance() + amount);
                break;
            case WITHDRAWAL:
                if (user.getBalance() >= amount) {
                    user.setBalance(user.getBalance() - amount);
                } else {
                    return null; // Saldo insuficiente
                }
                break;
            case TRANSFER:
                // Aquí podríamos manejar una lógica de transferencia a otro usuario
                break;
            default:
                return null;
        }

        Transaction transaction = new Transaction(userId, type, amount);
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> getTransactionsByUserId(UUID userId) {
        List<Transaction> userTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getUserId().equals(userId)) {
                userTransactions.add(transaction);
            }
        }
        return userTransactions;
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
