package com.naidiuk.servlets;

import com.naidiuk.service.ClientImplementation;
import com.naidiuk.service.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users/delete")
public class UsersDeleteServlet extends HttpServlet {
    private final ClientService clientService = new ClientImplementation();

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("id");

        clientService.deleteUser(Integer.parseInt(userId));
    }
}
