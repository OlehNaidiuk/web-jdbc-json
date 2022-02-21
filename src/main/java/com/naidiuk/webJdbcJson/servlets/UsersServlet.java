package com.naidiuk.webJdbcJson.servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
public class UsersGetOneServlet extends HttpServlet {
    private final ClientService clientService = new ClientServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("id");
        if (userId == null) {
            List<User> users = clientService.getAllUsers();
            PrintWriter printWriter = response.getWriter();
            for (User user : users) {
                printWriter.write(objectMapper.writeValueAsString(user));
            }
            printWriter.flush();
            printWriter.close();
        }
        User user = clientService.getUserById(Integer.parseInt(userId));

        PrintWriter printWriter = response.getWriter();
        printWriter.write(convertToJson(user));
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

    private ObjectMapper convertToJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper;
    }
}
