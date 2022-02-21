package com.revature.servlet;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repository.ReimbursementDAO;
import com.revature.repository.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateAllRequestformServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Update reimbursement in database
        if(session == null){
            // no session, so we can't get the user object
            PrintWriter out = response.getWriter();
            out.write("<h3>You should access this from the login page only</h3>");
            out.write("<a href='index.html'>Click Here</a>");
        } else {

            Double amount = Double.parseDouble(request.getParameter("amount"));
            int reimbursementId = Integer.parseInt(request.getParameter("requestId")) ;
            String getStatus = request.getParameter("status");
            User author = UserDAO.getByUsername(request.getParameter("username"));
            User resolver = (User) session.getAttribute("user");

            Status status = null;

            if(getStatus.equals("APPROVED")){
                status = Status.APPROVED;
            } else if(getStatus.equals("DENIED")){
                status = Status.DENIED;
               Reimbursement oldReimbursement = ReimbursementDAO.getById(reimbursementId);
                //ReimbursementDAO.updateAllowance(cost, author, oldReimbursement);
            }

            try {
                Reimbursement newReimbursement = new Reimbursement(reimbursementId, status, author, resolver, amount);
                ReimbursementDAO.update(newReimbursement);

                User userRole = UserDAO.getByUsername(resolver.getUsername());
                String role = userRole.getRole();
                if(role.equals("EMPLOYEE")) {
                    response.sendRedirect("employee.html");
                } else {
                    response.sendRedirect("manager.html");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
