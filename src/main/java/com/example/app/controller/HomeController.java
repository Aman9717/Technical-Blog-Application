package com.example.app.controller;

import com.example.app.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getAllPost(Model model) {

        //BUSINESS LOGIC
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("iPhone");
        post1.setBody("iPhones are not better than android");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Tech");
        post2.setBody("Elon Must : KING OF TECH");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Phone");
        post3.setBody("I have note 10 lite");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        model.addAttribute("posts",posts);

        return "index";

    }
}
