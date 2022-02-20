package com.naidiuk.service;

import com.naidiuk.dao.UserDaoJDBC;
import com.naidiuk.dao.UserDaoService;
import com.naidiuk.entity.User;
import com.naidiuk.util.InsuranceExperienceCalculator;

import java.util.List;

public class ClientImplementation implements ClientService {
    private final UserDaoService userDaoService = new UserDaoJDBC();

    @Override
    public void addUser(User user) {
        userDaoService.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDaoService.deleteUser(id);
    }

    @Override
    public void updateUser(User updatedUser, int id) {
        userDaoService.updateUser(updatedUser, id);
    }

    @Override
    public User getUserById(int id) {
        return userDaoService.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDaoService.getAllUsers();
    }

    @Override
    public User getUserWithMaxId() {
        return userDaoService.getUserWithMaxId();
    }

    @Override
    public int calculateRemainingYearsUntilRetirement(int id) {
        User user = userDaoService.getUserById(id);
        InsuranceExperienceCalculator insuranceExperienceCalculator = new InsuranceExperienceCalculator();
        return insuranceExperienceCalculator.calculateRemainingYearsUntilRetirement(user.getWorkExperienceYears());
    }
}
