package com.naidiuk.webJdbcJson.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naidiuk.webJdbcJson.entity.User;
import com.naidiuk.webJdbcJson.service.ClientService;
import com.naidiuk.webJdbcJson.service.ClientServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/max")
public class UsersMaxServlet extends HttpServlet {
    private final ClientService clientService = new ClientServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = clientService.getUserWithMaxId();
        ObjectMapper objectMapper = UsersServlet.getObjectMapper();
        PrintWriter printWriter = response.getWriter();
        printWriter.write(objectMapper.writeValueAsString(user));
        printWriter.flush();
        printWriter.close();
    }
}
