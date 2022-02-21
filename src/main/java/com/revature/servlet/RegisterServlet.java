package com.revature.servlet;

import com.revature.models.User;
import com.revature.repository.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

       User user = UserDAO.getByUsername(username);
        if (user == null) {
            try {
                User newUser = new User (firstName, lastName, username, email, password, "EMPLOYEE");
                UserDAO.create(newUser);
            } catch (Exception e) {
                System.out.println("new user unsuccessful");
            }
            System.out.println("Username already exists");

        }
        response.sendRedirect("index.html");
    }

}
