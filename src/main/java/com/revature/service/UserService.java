package com.revature.service;

import com.revature.models.User;
import com.revature.repository.UserDAO;

public class UserService {

 private UserDAO userDAO = new UserDAO();

 public User login(String username, String password) {
     User u = userDAO.getByUsername(username);
     if(u != null){
         System.out.println(u.getUsername());
         System.out.println(u.getPassword());


     if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
         return u;
     }
     }
     System.out.println("Credentials do not match");
     return null;
 }
}
