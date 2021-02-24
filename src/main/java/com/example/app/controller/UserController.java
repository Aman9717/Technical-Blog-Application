package com.example.app.controller;


import com.example.app.model.Post;
import com.example.app.model.User;
import com.example.app.service.PostService;
import com.example.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserService userService = new UserService();
    private PostService postService = new PostService();
    //GET REQUEST TO "/users/login"
    @RequestMapping(method = RequestMethod.GET, value="/users/login")
    public String login(Model model) {
        model.addAttribute("user",new User());
        return "users/login";
    }

    // POST REQUEST TO "/users/login"


    @RequestMapping(method = RequestMethod.POST, value = "/users/login")
    public String loginUser(User user) {
        // check if credentials match
        if(userService.login(user)){
            return "redirect:/posts";
        }
        else {
            return "users/login";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "users/registration")
    public String Registration() {
        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/registration")
    public String userRegistration(User user) {
        // BUSINESS LOGIC TO SAVE CREDS OF TH USER TO THE GIVEN DATABASE

        return "redirect:/users/login";
    }

    @RequestMapping(value="/users/logout")
    public String userLogout(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "redirect:/";
    }
}
