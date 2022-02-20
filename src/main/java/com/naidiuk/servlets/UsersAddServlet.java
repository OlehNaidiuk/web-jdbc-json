package com.naidiuk.servlets;

import com.naidiuk.entity.User;
import com.naidiuk.service.ClientImplementation;
import com.naidiuk.service.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users/add")
public class UsersAddServlet extends HttpServlet {
    private final ClientService clientService = new ClientImplementation();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        User user = createUserFromRequest(request);

        clientService.addUser(user);
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
}
