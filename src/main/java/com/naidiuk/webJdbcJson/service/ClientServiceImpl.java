package com.naidiuk.webJdbcJson.service;

import com.naidiuk.webJdbcJson.dao.UserDao;
import com.naidiuk.webJdbcJson.dao.UserDaoJDBC;
import com.naidiuk.webJdbcJson.dto.UserDto;
import com.naidiuk.webJdbcJson.entity.User;

import java.util.List;

public class ClientServiceImpl implements ClientService {
    private final UserDao userDao;

    public ClientServiceImpl() {
        userDao = new UserDaoJDBC();
    }

    public ClientServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUser(User updatedUser, int id) {
        userDao.updateUser(updatedUser, id);
    }

    @Override
    public User getUserById(int id) {return userDao.getUserById(id);}

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserWithMaxId() {
        return userDao.getUserWithMaxId();
    }

    @Override
    public UserDto getUserByIdWithYearsUntilRetirement(int id) {
        User user = userDao.getUserById(id);
        int yearsUntilRetirement = 30 - user.getWorkExperienceYears();
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setSalary(user.getSalary());
        userDto.setWorkExperienceYears(user.getWorkExperienceYears());
        userDto.setYearsUntilRetirement(yearsUntilRetirement);
        return userDto;
    }
}
