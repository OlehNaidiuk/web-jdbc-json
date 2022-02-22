package com.naidiuk.webJdbcJson.dao;

import com.naidiuk.webJdbcJson.entity.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User updatedUser, int id);
    User getUserById(int id);
    List<User> getAllUsers();
    User getUserWithMaxId();
}
