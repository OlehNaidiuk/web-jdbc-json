package com.naidiuk.servlets;

import com.naidiuk.dao.UserDaoJDBC;
import com.naidiuk.dao.UserDaoService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;


@WebServlet("/users/all")
public class UsersAll extends HttpServlet {
    private final UserDaoService userDaoService = new UserDaoJDBC();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}
