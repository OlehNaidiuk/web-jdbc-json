package com.naidiuk.dao;

import com.naidiuk.entity.User;
import com.naidiuk.service.Default;
import com.naidiuk.service.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBC implements UserDaoService {
    private static final String JDBC_POSTGRES_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/Users";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "Jktu310590";
    private final Service service = new Default();

    @Override
    public boolean addUser(User user) {
        try {
            Class.forName(JDBC_POSTGRES_DRIVER);
            try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                 PreparedStatement preparedStatement =
                         connection.prepareStatement("INSERT INTO "user" (id, name, surname, salary, work_experience_years) "
                                 + "VALUES (?, ?, ?, ?, ?)")) {
                preparedStatement.setInt(1, user.getId());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getSurname());
                preparedStatement.setInt(4, user.getSalary());
                preparedStatement.setInt(5, user.getWorkExperienceYears());
                return preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        try {
            Class.forName(JDBC_POSTGRES_DRIVER);
            try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM "user"")) {
                List<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setSalary(resultSet.getInt("salary"));
                    user.setWorkExperienceYears(resultSet.getInt("work_experience_years"));
                    users.add(user);
                }
                return users;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public User getUserWithMaxId() {
        return null;
    }
}
