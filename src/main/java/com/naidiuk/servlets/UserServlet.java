package com.naidiuk.servlets;

import com.naidiuk.dao.UserDaoJDBC;
import com.naidiuk.dao.UserDaoService;
import com.naidiuk.entity.User;
import com.naidiuk.service.Default;
import com.naidiuk.service.Service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private final Service service = new Default();
    private final UserDaoService userDaoService = new UserDaoJDBC();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String method = request.getMethod();
        String id = request.getParameter("id");
        String userName = request.getParameter("name");
        String userSurname = request.getParameter("surname");
        String userSalary = request.getParameter("salary");
        String userWorkExperience = request.getParameter("work_experience");

        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setName(userName);
        user.setSurname(userSurname);
        user.setSalary(Integer.parseInt(userSalary));
        user.setWorkExperienceYears(Integer.parseInt(userWorkExperience));



        PrintWriter printWriter = response.getWriter();
        printWriter.write(response.getStatus());
    }
}
