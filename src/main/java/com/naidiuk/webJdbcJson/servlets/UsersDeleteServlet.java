package com.naidiuk.webJdbcJson.servlets;

import com.naidiuk.webJdbcJson.service.ClientImplementation;
import com.naidiuk.webJdbcJson.service.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users/delete")
public class UsersDeleteServlet extends HttpServlet {

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        ClientService clientService = new ClientImplementation();

        String userId = request.getParameter("id");

        clientService.deleteUser(Integer.parseInt(userId));
    }
}
