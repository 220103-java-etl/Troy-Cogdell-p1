package com.revature.service;

import com.revature.models.User;
import com.revature.repository.UserDAO;

import java.util.Optional;

public class AuthService {


    public static User login(String username, String password){
        UserDAO userDAO = new UserDAO();
        User u = userDAO.getByUsername(username);
        if (u != null){
            if(username.equals(u.getUsername()) && password.equals(u.getPassword())){
                return u;
            }
        }
        System.out.println("Credential do not match");
        return null;
    }


    public static User register(User userToBeRegiestered){
        return null;
    }

    public Optional<User> exampleRetrieveCurrentUser(){
        return Optional.empty();
    }
}
