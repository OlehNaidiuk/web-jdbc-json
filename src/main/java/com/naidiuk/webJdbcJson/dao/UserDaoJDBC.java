package com.naidiuk.webJdbcJson.dao;

import com.naidiuk.webJdbcJson.entity.User;
import com.naidiuk.webJdbcJson.errors.JDBCConnectionException;
import com.naidiuk.webJdbcJson.errors.JDBCDriverException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBC implements UserDaoService {
    private static final String JDBC_POSTGRES_DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/Users";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "Jktu310590";

    @Override
    public void addUser(User user) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?);"))
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setInt(3, user.getSalary());
            preparedStatement.setInt(4, user.getWorkExperienceYears());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new JDBCConnectionException("Access error or connection is closed", e);
        }
    }

    @Override
    public void deleteUser(int id) {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM users WHERE id=" + id + ";");
        } catch (SQLException e) {
            throw new JDBCConnectionException("Access error or connection is closed", e);
        }
    }

    @Override
    public void updateUser(User updatedUser, int id) {
        try (Connection connection = createConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE users SET name=?, surname=?, salary=?, "
                             + "work_experience_years=? WHERE id=?;")) {
            preparedStatement.setString(1, updatedUser.getName());
            preparedStatement.setString(2, updatedUser.getSurname());
            preparedStatement.setInt(3, updatedUser.getSalary());
            preparedStatement.setInt(4, updatedUser.getWorkExperienceYears());
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new JDBCConnectionException("Access error or connection is closed", e);
        }
    }

    @Override
    public User getUserById(int id) {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id=" + id + ";"))
        {
            User foundedUser = new User();
            while (resultSet.next()) {
                foundedUser.setName(resultSet.getString("name"));
                foundedUser.setSurname(resultSet.getString("surname"));
                foundedUser.setSalary(resultSet.getInt("salary"));
                foundedUser.setWorkExperienceYears(resultSet.getInt("work_experience_years"));
            }
            return foundedUser;
        } catch (SQLException e) {
            throw new JDBCConnectionException("Access error or connection is closed", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users;"))
        {
            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setSalary(resultSet.getInt("salary"));
                user.setWorkExperienceYears(resultSet.getInt("work_experience_years"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new JDBCConnectionException("Access error or connection is closed", e);
        }
    }

    @Override
    public User getUserWithMaxId() {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id=(SELECT MAX(id) FROM users);"))
        {
            User userWithMaxId = new User();
            while (resultSet.next()) {
                userWithMaxId.setName(resultSet.getString("name"));
                userWithMaxId.setSurname(resultSet.getString("surname"));
                userWithMaxId.setSalary(resultSet.getInt("salary"));
                userWithMaxId.setWorkExperienceYears(resultSet.getInt("work_experience_years"));
            }
            return userWithMaxId;
        } catch (SQLException e) {
            throw new JDBCConnectionException("Access error or connection is closed", e);
        }
    }

    private Connection createConnection() {
        try {
            Class.forName(JDBC_POSTGRES_DRIVER);
            return DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new JDBCConnectionException("Unable to connect to database", e);
        } catch (ClassNotFoundException e) {
            throw new JDBCDriverException("Wrong driver for this DBMS", e);
        }
    }
}