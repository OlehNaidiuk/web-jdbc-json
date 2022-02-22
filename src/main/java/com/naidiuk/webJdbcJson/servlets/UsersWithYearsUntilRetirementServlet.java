package com.naidiuk.webJdbcJson.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.naidiuk.webJdbcJson.dao.UserDaoJDBC;
import com.naidiuk.webJdbcJson.dto.UserDto;
import com.naidiuk.webJdbcJson.service.ClientServiceImpl;
import com.naidiuk.webJdbcJson.service.ClientService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users/user-with-years-until-retirement")
public class UsersWithYearsUntilRetirementServlet extends HttpServlet {
    private final ClientService clientService = new ClientServiceImpl(new UserDaoJDBC());

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("id");
        UserDto userDto = clientService.getUserByIdWithYearsUntilRetirement(Integer.parseInt(userId));
        ObjectMapper objectMapper = UsersServlet.getObjectMapper();
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        printWriter.write(objectMapper.writeValueAsString(userDto));
        printWriter.flush();
        printWriter.close();
    }
}
