package com.example.app.service;

import com.example.app.model.Post;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
public class PostService {

    // Singleton -> database ka sara ka sara data rakha hota hui
    private static ArrayList<Post> POSTS = new ArrayList<>();
    /*static {
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
    }*/

    private final String url = "jdbc:postgresql://localhost:5432/technicalapp";
    private final String username = "postgres";
    private final int password = 8520;

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url,username, String.valueOf(password));
    }
    public ArrayList<Post> getAllPosts() {
       try {
            // Business logic for connecting the database
           // STEP 1 - Connect to the database
           Connection connection  = connect();

           // STEP - Get/Create the statement **In GET we create a statement and in POST we prepare a statement
           Statement statement = connection.createStatement();

           //STEP 3 - Execute the SELECT query
           ResultSet resultSet = statement.executeQuery("SELECT * FROM posts");

           //STEP 4 * Loop into the resultset and get the data
           while(resultSet.next()) {
               Post post1 = new Post();
               post1.setTitle(resultSet.getString("title"));
               post1.setBody(resultSet.getString("body"));
               post1.setDate(resultSet.getDate("date"));

               // store data in Singleton
               POSTS.add(post1);

           }



        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }

        return POSTS;
    }

    public void createPost(Post newPost) {
        String query = "INSERT INTO posts(title,body,date) VALUES(?,?,?)";
        try {
            // STEP 1 - Connect to the database
            Connection connection  = connect();

            // STEP 2 - Prepare a statement
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            // STEP 3 - fix the values from VIEWS;
            preparedStatement.setString(1,newPost.getTitle());
            preparedStatement.setString(2,newPost.getBody());
            preparedStatement.setDate(3, new Date(newPost.getDate().getTime()));

            int updatedRows = preparedStatement.executeUpdate();

            if(updatedRows > 0)
            {
                System.out.println("Update is working fine");
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}