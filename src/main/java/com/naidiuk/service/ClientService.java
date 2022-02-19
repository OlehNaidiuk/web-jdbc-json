package com.naidiuk.service;

import com.naidiuk.entity.User;

import java.util.List;

public interface ClientService {
    void addUser(User user);
    void deleteUser(int userId);
    void updateUser(User user);
    User getUser(int userId);
    List<User> getAllUsers();
    User getUserWithMaxId();
}
