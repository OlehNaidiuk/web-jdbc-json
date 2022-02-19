package com.naidiuk.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.naidiuk.dao.UserDaoJDBC;
import com.naidiuk.dao.UserDaoService;
import com.naidiuk.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/users/all")
public class UsersAll extends HttpServlet {
    private final UserDaoService userDaoService = new UserDaoJDBC();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<User> users = userDaoService.getAllUsers();

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
