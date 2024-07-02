package com.training.statementscontrol;

import com.training.statementscontrol.enums.TransactionType;
import com.training.statementscontrol.service.UserService;
import com.training.statementscontrol.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatementsControlApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StatementsControlApplication.class, args);
    }

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionServiceImpl transactionService;

    @Override
    public void run(String... args) throws Exception {
        // Crear usuarios
        var user1 = userService.createUser("Alice", 1000.0);
        var user2 = userService.createUser("Bob", 500.0);

        // Realizar transacciones
        var transaction1 = transactionService.createTransaction(user1.getId(), TransactionType.DEPOSIT, 200.0);
        var transaction2 = transactionService.createTransaction(user1.getId(), TransactionType.WITHDRAWAL, 100.0);
        var transaction3 = transactionService.createTransaction(user2.getId(), TransactionType.DEPOSIT, 150.0);

        // Mostrar transacciones
        System.out.println("Transacciones de Alice: ");
        transactionService.getTransactionsByUserId(user1.getId()).forEach(System.out::println);

        System.out.println("Transacciones de Bob: ");
        transactionService.getTransactionsByUserId(user2.getId()).forEach(System.out::println);

        // Ejemplos avanzados con estructuras de control
        // if-else
        if (user1.getBalance() > user2.getBalance()) {
            System.out.println("Alice tiene más saldo que Bob");
        } else {
            System.out.println("Bob tiene más saldo que Alice");
        }

        // Ternary operator
        String message = user1.getBalance() > user2.getBalance() ? "Alice tiene más saldo" : "Bob tiene más saldo";
        System.out.println(message);

        // for loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteración: " + i);
        }

        // for-each loop
        for (User user : userService.getAllUsers()) {
            System.out.println("Usuario: " + user.getName());
        }

        // while loop
        int counter = 0;
        while (counter < 3) {
            System.out.println("Contador: " + counter);
            counter++;
        }

        // do-while loop
        counter = 0;
        do {
            System.out.println("Contador en do-while: " + counter);
            counter++;
        } while (counter < 3);

        // break keyword
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println("Break en iteración: " + i);
        }

        // continue keyword
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("Continue en iteración: " + i);
        }

        // labeled statements
        outerLoop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    break outerLoop;
                }
                System.out.println("i: " + i + ", j: " + j);
            }
        }
    }
}
