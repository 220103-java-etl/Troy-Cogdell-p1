package com.revature.service;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repository.ReimbursementDAO;
import com.revature.repository.UserDAO;

import java.util.Collections;
import java.util.List;

public class ReimbursementService {

    ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
    UserDAO userDAO = new UserDAO();

/*public Reimbursement addReimbursement(Reimbursement r){
    User u = userDAO.getByUsername(r.getTitle());
    if(u != null){
        return reimbursementDAO.add(r);
    }else{
        User newUser = userDAO.add(u.getUsername());
        r.setAuthor( newUser);
        return reimbursementDAO.add(r);
    }
}*/
public Reimbursement getReimbursementById(int id){
    return reimbursementDAO.getById(id);
}
public List<Reimbursement>getAllReimbursement(){
    return ReimbursementDAO.getAll();
}
public void updateReimbursement(Reimbursement r){
    ReimbursementDAO.update(r);
}
public void deleteReimbursement(int id){
    reimbursementDAO.delete(id);
}

    public Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStats, User resolver){
        return null;
    }
    public List<Reimbursement> getReimbursementsByStatus(Status status) {return Collections.emptyList();}


}
