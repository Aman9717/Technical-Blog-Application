package com.example.app.controller;

import com.example.app.model.Post;
import com.example.app.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class PostController {
    @RequestMapping("/posts")
    public String getUserPost(Model model) {
        PostService postService = new PostService();
        ArrayList<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "posts";
    }

    //Map GET req to /posts/newpost -> to get view of newpost
    //Map POST req to /posts/create

    @RequestMapping(method = RequestMethod.GET, value = "/posts/newpost")
    public String newPost() {
        return "posts/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/posts/create")
    public String createNewPost(Post newPost) {
        PostService postService = new PostService();
        newPost.setDate(new Date());
        postService.createPost(newPost);
        return "redirect:/posts";
    }

    }





