package com.naidiuk.servlets;

import com.naidiuk.dao.UserDaoJDBC;
import com.naidiuk.dao.UserDaoService;
import com.naidiuk.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/add")
public class UsersAdd extends HttpServlet {
    private final UserDaoService userDaoService = new UserDaoJDBC();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String userName = request.getParameter("name");
        String userSurname = request.getParameter("surname");
        String userSalary = request.getParameter("salary");
        String userWorkExperience = request.getParameter("work_experience_years");

        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setName(userName);
        user.setSurname(userSurname);
        user.setSalary(Integer.parseInt(userSalary));
        user.setWorkExperienceYears(Integer.parseInt(userWorkExperience));

        userDaoService.addUser(user);
    }
}
