package com.training.statementscontrol.service;

import com.training.statementscontrol.enums.TransactionType;
import com.training.statementscontrol.model.Transaction;
import com.training.statementscontrol.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface TransactionService {

    Transaction createTransaction(UUID userId, TransactionType type, double amount) ;

    List<Transaction> getTransactionsByUserId(UUID userId);

    List<Transaction> getAllTransactions();
}
