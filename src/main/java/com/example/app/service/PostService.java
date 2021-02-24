package com.example.app.service;

import com.example.app.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    // Singleton -> database ka sara ka sara data rakha hota hui
    private static ArrayList<Post> POSTS = new ArrayList<>();
    static {
        Post post1 = new Post();
        post1.setTitle("Worldwide");
        post1.setBody("A news in Uttarakhand reported heavy floods in UK Districts. Alert has been declared.");
        post1.setDate(new Date());
        POSTS.add(post1);

        Post post2 = new Post();
        post2.setTitle("Music");
        post2.setBody("HONEY PAAHJI...King of Punjabi Industry.");
        post2.setDate(new Date());
        POSTS.add(post2);

        Post post3 = new Post();
        post3.setTitle("Technology");
        post3.setBody("Apples new iOS 14.5, iPadOS 14.5 updates are out for BETA Testers.");
        post3.setDate(new Date());
        POSTS.add(post3);

        Post post4 = new Post();
        post4.setTitle("National");
        post4.setBody("College to be opened soon.");
        post4.setDate(new Date());
        POSTS.add(post4);
    }
    public ArrayList<Post> getAllPosts() {
        return POSTS;
    }

    public void createPost(Post newPost) {
        POSTS.add(newPost);
    }
}