package com.naidiuk.webJdbcJson.service;

import com.naidiuk.webJdbcJson.dto.UserDto;
import com.naidiuk.webJdbcJson.entity.User;

import java.util.List;

public interface ClientService {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User updatedUser, int id);
    User getUserById(int id);
    List<User> getAllUsers();
    User getUserWithMaxId();
    UserDto getUserByIdWithYearsUntilRetirement(int id);
}
