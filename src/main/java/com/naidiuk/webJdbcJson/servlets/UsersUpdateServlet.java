package com.naidiuk.webJdbcJson.servlets;

import com.naidiuk.webJdbcJson.entity.User;
import com.naidiuk.webJdbcJson.service.ClientImplementation;
import com.naidiuk.webJdbcJson.service.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/users/update")
public class UsersUpdateServlet extends HttpServlet {

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        ClientService clientService = new ClientImplementation();

        String userId = request.getParameter("id");

        User updatedUser = createUpdatedUserFromRequest(request);

        clientService.updateUser(updatedUser, Integer.parseInt(userId));
    }

    private User createUpdatedUserFromRequest(HttpServletRequest request) {
        String userName = request.getParameter("name");
        String userSurname = request.getParameter("surname");
        String userSalary = request.getParameter("salary");
        String userWorkExperienceYears = request.getParameter("work_experience_years");

        User updatedUser = new User();
        updatedUser.setName(userName);
        updatedUser.setSurname(userSurname);
        updatedUser.setSalary(Integer.parseInt(userSalary));
        updatedUser.setWorkExperienceYears(Integer.parseInt(userWorkExperienceYears));

        return updatedUser;
    }
}
