package com.naidiuk.webJdbcJson.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.naidiuk.webJdbcJson.entity.User;
import com.naidiuk.webJdbcJson.service.ClientImplementation;
import com.naidiuk.webJdbcJson.service.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users/get-all")
public class UsersGetAllServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClientService clientService = new ClientImplementation();

        List<User> users = clientService.getAllUsers();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        PrintWriter printWriter = response.getWriter();
        for (User user : users) {
            printWriter.write(objectMapper.writeValueAsString(user));
        }
        printWriter.flush();
        printWriter.close();
    }
}
