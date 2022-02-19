package com.naidiuk.service;

import com.naidiuk.dao.UserDaoJDBC;
import com.naidiuk.dao.UserDaoService;
import com.naidiuk.entity.User;

import java.util.List;

public class Default implements Service {
    private final UserDaoService userDaoService = new UserDaoJDBC();

    @Override
    public boolean addUser(User user) {
        userDaoService.addUser(user);
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
