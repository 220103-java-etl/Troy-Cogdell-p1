package com.revature.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repository.ReimbursementDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ViewAllRequestForm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User author = (User) session.getAttribute("user");
        if (author == null || "EMPLOYEE".equals(author.getRole())){
            response.sendRedirect("/login");
        }
        List<Reimbursement> reimbursements = ReimbursementDAO.getAll();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(reimbursements);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

}
