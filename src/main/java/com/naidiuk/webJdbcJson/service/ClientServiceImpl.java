package com.naidiuk.webJdbcJson.service;

import com.naidiuk.webJdbcJson.dao.UserDaoJDBC;
import com.naidiuk.webJdbcJson.dao.UserDaoService;
import com.naidiuk.webJdbcJson.dto.UserDto;
import com.naidiuk.webJdbcJson.entity.User;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private final UserDaoService userDaoService;

    public ClientServiceImpl() {
        userDaoService = new UserDaoJDBC();
    }

    public ClientServiceImpl(UserDaoJDBC userDaoJDBC) {
        this.userDaoService = userDaoJDBC;
    }

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
    public User getUserById(int id) {return userDaoService.getUserById(id);}

    @Override
    public List<User> getAllUsers() {
        return userDaoService.getAllUsers();
    }

    @Override
    public User getUserWithMaxId() {
        return userDaoService.getUserWithMaxId();
    }

    @Override
    public UserDto getUserByIdWithYearsUntilRetirement(int id) {
        User user = userDaoService.getUserById(id);
        int yearsUntilRetirement = 30 - user.getWorkExperienceYears();
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setSalary(user.getSalary());
        userDto.setWorkExperienceYears(user.getWorkExperienceYears());
        userDto.setYearsUntilRetirement(yearsUntilRetirement);
        return userDto;
    }
}
