package com.naidiuk.webJdbcJson.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.naidiuk.webJdbcJson.entity.User;
import com.naidiuk.webJdbcJson.service.ClientImplementation;
import com.naidiuk.webJdbcJson.service.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/get-one-plus-remaining-years-until-retirement")
public class UsersGetOnePlusRemainingYearsUntilRetirement extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClientService clientService = new ClientImplementation();

        String userId = request.getParameter("id");

        User user = clientService.getUserById(Integer.parseInt(userId));

        int yearsUntilRetirement = clientService.calculateRemainingYearsUntilRetirement(user.getWorkExperienceYears());

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        PrintWriter printWriter = response.getWriter();
        printWriter.write(objectMapper.writeValueAsString(user));
        printWriter.write("\nyearsUntilRetirement : " + yearsUntilRetirement);
        printWriter.flush();
        printWriter.close();
    }
}
