package com.naidiuk.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.naidiuk.entity.User;
import com.naidiuk.service.ClientImplementation;
import com.naidiuk.service.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/get-one-with-max-id")
public class UsersGetOneWithMaxIdServlet extends HttpServlet {
    private final ClientService clientService = new ClientImplementation();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = clientService.getUserWithMaxId();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        PrintWriter printWriter = response.getWriter();
        printWriter.write(objectMapper.writeValueAsString(user));
        printWriter.flush();
        printWriter.close();
    }
}
