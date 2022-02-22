package com.naidiuk.webJdbcJson.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naidiuk.webJdbcJson.dao.UserDaoJDBC;
import com.naidiuk.webJdbcJson.entity.User;
import com.naidiuk.webJdbcJson.service.ClientServiceImpl;
import com.naidiuk.webJdbcJson.service.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private final ClientService clientService = new ClientServiceImpl(new UserDaoJDBC());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("id");
        ObjectMapper objectMapper = getObjectMapper();
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        if (userId == null) {
            List<User> users = clientService.getAllUsers();
            printWriter.write(objectMapper.writeValueAsString(users));
        } else {
            User user = clientService.getUserById(Integer.parseInt(userId));
            printWriter.write(objectMapper.writeValueAsString(user));
        }
        printWriter.flush();
        printWriter.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = createUserFromRequest(request);
        clientService.addUser(user);
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("id");
        clientService.deleteUser(Integer.parseInt(userId));
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("id");
        User updatedUser = createUserFromRequest(request);
        clientService.updateUser(updatedUser, Integer.parseInt(userId));
    }

    private User createUserFromRequest(HttpServletRequest request) {
        String userName = request.getParameter("name");
        String userSurname = request.getParameter("surname");
        String userSalary = request.getParameter("salary");
        String userWorkExperienceYears = request.getParameter("work_experience_years");

        User user = new User();
        user.setName(userName);
        user.setSurname(userSurname);
        user.setSalary(Integer.parseInt(userSalary));
        user.setWorkExperienceYears(Integer.parseInt(userWorkExperienceYears));

        return user;
    }

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
