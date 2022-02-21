package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repository.ReimbursementDAO;
import com.revature.service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewRequestFormServlet extends HttpServlet {


    AuthService authorService = new AuthService();

    ObjectMapper obj = new ObjectMapper();




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);
        User author = (User) session.getAttribute("user");
        PrintWriter out = response.getWriter();




        //view request

        User user = (User) session.getAttribute("user");
                if(user == null) {
                    response.sendRedirect("/login");


    }
                List<Reimbursement> reimbursements = ReimbursementDAO.getByUser(author.getUsername());
                ObjectMapper mapper = new ObjectMapper();
                String json = ((ObjectMapper) mapper).writeValueAsString(reimbursements);
                response.setContentType("application/json");
                response.getWriter().write(json);


    }
}
