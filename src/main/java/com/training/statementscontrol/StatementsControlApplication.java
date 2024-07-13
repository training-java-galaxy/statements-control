package com.training.statementscontrol;

import com.training.statementscontrol.dto.UserDTO;
import com.training.statementscontrol.enums.TransactionType;
import com.training.statementscontrol.model.User;
import com.training.statementscontrol.service.UserService;
import com.training.statementscontrol.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteración incremento: inicializado con 1 - " + i);
        }


        for (int i = 10; i <= 50; i += 10) {
            System.out.println("Iteración incremento: inicializado con 10 " + i);
        }

        for (int i = 10; i <= 50; i = i + 10) {
            System.out.println("Iteración incremento: inicializado con 10 " + i);
        }

        Integer count = 0;

        count = count + 2;

        count = count + 1;

        count = count + 2;

        count += 2;

        System.out.println("El valor del contador: " + count);


        for (int i = 10; i > 5; i--) {
            System.out.println("Iteración decremento: " + i);
        }

        for (int i = 10; i >= 5; i--) {
            System.out.println("Iteración decremento: " + i);

        }




        System.out.println("-------------------------5 FOR ANIDADOS-------------------------------------------");

        int maxDimensionValue = 3;

        for (int a = 1; a <= maxDimensionValue; a++) {
            for (int b = 1; b <= maxDimensionValue; b++) {
                for (int c = 1; c <= maxDimensionValue; c++) {
                    for (int d = 1; d <= maxDimensionValue; d++) {
                        for (int e = 1; e <= maxDimensionValue; e++) {
                            System.out.println("Coordenadas: (" + a + ", " + b + ", " + c + ", " + d + ", " + e + ")");
                            // Aquí puedes agregar la lógica para procesar cada combinación de coordenadas
                        }
                    }
                }
            }
        }
        System.out.println("---------------------FIN 5 FOR ANIDADOS-----------------------------------------------");


        // Creando la estructura de datos
        List<List<List<String>>> categoriasFinancieras = new ArrayList<>();

        // Categoría 1
        List<List<String>> categoria1 = new ArrayList<>();
        categoria1.add(Arrays.asList("Transacción 1.1.1", "Transacción 1.1.2"));
        categoria1.add(Arrays.asList("Transacción 1.2.1", "Transacción 1.2.2", "Transacción 1.2.3"));
        categoriasFinancieras.add(categoria1);

        // Categoría 2
        List<List<String>> categoria2 = new ArrayList<>();
        categoria2.add(Arrays.asList("Transacción 2.1.1", "Transacción 2.1.2"));
        categoria2.add(Arrays.asList("Transacción 2.2.1"));
        categoriasFinancieras.add(categoria2);

        // Categoría 3
        List<List<String>> categoria3 = new ArrayList<>();
        categoria3.add(Arrays.asList("Transacción 3.1.1", "Transacción 3.1.2", "Transacción 3.1.3"));
        categoriasFinancieras.add(categoria3);

        // Iterando a través de la estructura de datos usando foreach anidados
        for (List<List<String>> categoria : categoriasFinancieras) {
            System.out.println("Categoría:");
            for (List<String> subcategoria : categoria) {
                System.out.println("  Subcategoría:");
                for (String transaccion : subcategoria) {
                    System.out.println("    Transacción: " + transaccion);
                }
            }
        }


        // while loop
        int counter = 0;
        while (counter < 3) {
            System.out.println("Contador: " + counter);
            counter++;
        }

        // es valido
//        while(true){
//        }


        //
        String[] str= new ;


        String entrada = "";
        while (!entrada.equals("salir")) {
            System.out.print("Ingresa un texto (escribe 'salir' para terminar): ");
            entrada = scanner.nextLine();
            System.out.println("Ingresaste: " + entrada);
        }

        Integer con=0;

        while(con<=15){

            switch (con){


            }
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
////
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido la Opción 1");
                    break;
                case 2:
                    System.out.println("Has elegido la Opción 2");
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 3);

        Tarea130724();
        examplefor();


    }


    public void Tarea130724(){

        List<UserDTO> list = new ArrayList<>();

        UserDTO userDTO = null;

        list.add(userDTO);

        list.add(null);

        list.add(UserDTO.builder().name("German").balance(100).build());



    }

    public void examplefor(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteración incremento: " + i);
        }

        // for-each loop

        Integer count2 = 0;
        for (User user : userService.getAllUsers()) {

            count2 += 100;
            user.setBalance(user.getBalance() + count2);

            System.out.println("Usuario: " + user.getName());
        }

        //for anidados

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println("For anidados ejememplo :"+i + " x " + j + " = " + (i * j));
                for (int k=0; k<5; k++) {

                }
            }
            System.out.println(); // Para separar las tablas con una línea en blanco
        }

    }


}
