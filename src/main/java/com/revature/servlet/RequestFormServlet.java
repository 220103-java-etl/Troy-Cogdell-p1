package com.revature.servlet;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repository.ReimbursementDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RequestFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        if(session == null){
            PrintWriter out = response.getWriter();
            out.write("<h1>Only accessible through Login");
            out.write("<a href='index.html'>Click Here</a>");
        }else {
            String date = request.getParameter("date");
            String location = request.getParameter("location");
            String title = request.getParameter("title");
            Double amount = Double.parseDouble(request.getParameter("amount"));
            String justification = request.getParameter("justification");
            String grade = request.getParameter("grade");


            User author =  (User) session.getAttribute("user");

            Status status = Status.PENDING;




            //User resolver = new User();
            try{
                Reimbursement newReimbursement;
                newReimbursement = new Reimbursement(0, status, author, amount, date, location, justification, grade, title);
                ReimbursementDAO.create(newReimbursement);
                response.sendRedirect("Employee.html");
                System.out.println( newReimbursement);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
