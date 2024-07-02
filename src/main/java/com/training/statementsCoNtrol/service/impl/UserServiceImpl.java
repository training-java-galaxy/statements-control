package com.training.statementsCoNtrol.service.impl;

import com.training.statementsCoNtrol.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Servicio para manejar las operaciones relacionadas con usuarios.
 */
@Service
public class UserServiceImpl {
    private final List<User> users = new ArrayList<>();

    public User createUser(String name, double balance) {
        User user = new User(name, balance);
        users.add(user);
        return user;
    }

    public User getUserById(UUID id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public boolean updateUserBalance(UUID id, double newBalance) {
        User user = getUserById(id);
        if (user != null) {
            user.setBalance(newBalance);
            return true;
        }
        return false;
    }
}