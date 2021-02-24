package com.example.app.service;

import com.example.app.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //contains all the buiseness logic

    public boolean login(User user) {
        if(user.getUsername().equals("Aman Chauhan") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;
    }
}
