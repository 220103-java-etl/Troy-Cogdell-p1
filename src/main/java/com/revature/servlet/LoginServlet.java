package com.revature.servlet;

import com.revature.models.User;
import com.revature.repository.UserDAO;
import com.revature.service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       UserDAO userDAO = new UserDAO();



        String username = request.getParameter("username");
        String password =request.getParameter("password");
        System.out.println("servlet" + username);
        System.out.println("servlet" + password);


        User u = new User(); //(rs.getInt("id"), rs.getString("status"), rs.getString("author"), rs.getString("resolver"), rs.getString("amount"), rs.getString("date"), rs.getString("location"), rs.getString("justification"), rs.getString("title"));
        u.setUsername(username);
        u.setPassword(password);

        try{
            User userAuth = AuthService.login(username, password);
            System.out.println(userAuth);
            if(userAuth != null) {
                HttpSession session = request.getSession();

                User user = userDAO.getByUsername(username);
                session.setAttribute("user", user);

                User userRole = userDAO.getByUsername(username);
                String position = userRole.getPosition();

                if (position.equals("EMPLOYEE")) {
                    response.sendRedirect("Employee.html");
                } else if(position.equals("FINANCE MANAGER")){
                response.sendRedirect("Manager.html");}

            } else {
                response.sendRedirect("index.html");
            }
        }catch(Exception e){
            System.out.println("Sorry, invalid username or password");
            response.getWriter().write("invalid username or password");
        }

    }

}
