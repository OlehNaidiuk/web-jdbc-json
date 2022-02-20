package com.naidiuk.dao;

import com.naidiuk.entity.User;

import java.util.List;

public interface UserDaoService {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User updatedUser, int id);
    User getUserById(int id);
    List<User> getAllUsers();
    User getUserWithMaxId();
}
