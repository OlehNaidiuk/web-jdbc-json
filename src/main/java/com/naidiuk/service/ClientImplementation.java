package com.naidiuk.service;

import com.naidiuk.dao.UserDaoJDBC;
import com.naidiuk.dao.UserDaoService;
import com.naidiuk.entity.User;

import java.util.List;

public class ClientImplementation implements ClientService {
    private final UserDaoService userDaoService = new UserDaoJDBC();

    @Override
    public void addUser(User user) {
        userDaoService.addUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDaoService.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userDaoService.updateUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userDaoService.getUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoService.getAllUsers();
    }

    @Override
    public User getUserWithMaxId() {
        return userDaoService.getUserWithMaxId();
    }
}
