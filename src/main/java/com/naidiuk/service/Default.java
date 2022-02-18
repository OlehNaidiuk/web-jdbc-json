package com.naidiuk.service;

import com.naidiuk.entity.User;

import java.util.List;

public class Default implements Service {

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUser(int userId) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserWithMaxId() {
        return null;
    }
}
