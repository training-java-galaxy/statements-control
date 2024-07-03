package com.training.statementscontrol.service;

import com.training.statementscontrol.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public User createUser(String name, double balance);


    public User getUserById(UUID id);

    public List<User> getAllUsers();

    public boolean updateUserBalance(UUID id, double newBalance);
}

