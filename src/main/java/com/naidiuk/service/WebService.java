package com.naidiuk.service;

import com.naidiuk.entity.User;

import java.util.List;

public interface WebService {
    boolean addUser(User user);
    boolean deleteUser(User user);
    boolean updateUser(User user);
    User getUser(int userId);
    List<User> getAllUsers();
    User getUserWithMaxId();
    User getUserById();
}
