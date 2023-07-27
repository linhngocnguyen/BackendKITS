package com.example.flexbook;

import com.example.flexbook.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.javafaker.Faker;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FlexBookApplication {

    public static void main(String[] args) {
        Faker faker = new Faker();

        // Generate fake users
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername(faker.name().username());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            user.setProfile_picture(faker.internet().avatar());
            user.setBio(faker.lorem().sentence());
            user.setCreated_at(new Timestamp(System.currentTimeMillis()));
            user.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            users.add(user);
        }

        // Generate fake posts
        List<Post> posts = new ArrayList<>();
        for (User user : users) {
            for (int i = 0; i < 5; i++) {
                Post post = new Post();
                post.setContent(faker.lorem().paragraph());
                post.setPost_image(faker.internet().image());
                post.setCreated_at(new Timestamp(System.currentTimeMillis()));
                post.setUpdated_at(new Timestamp(System.currentTimeMillis()));
                posts.add(post);
            }
        }

        // Generate fake comments
        List<Comment> comments = new ArrayList<>();
        for (Post post : posts) {
            for (int i = 0; i < 3; i++) {
                Comment comment = new Comment();
                comment.setUser(users.get(faker.number().numberBetween(0, 10)));
                comment.setPost(post);
                comment.setComment(faker.lorem().sentence());
                comment.setCreated_at(new Timestamp(System.currentTimeMillis()));
                comment.setUpdated_at(new Timestamp(System.currentTimeMillis()));
                comments.add(comment);
            }
        }

        // Generate fake likes
        List<Like> likes = new ArrayList<>();
        for (Post post : posts) {
            for (int i = 0; i < 5; i++) {
                Like like = new Like();
                like.setUser(users.get(faker.number().numberBetween(0, 10)));
                like.setPost(post);
                like.setCreated_at(new Timestamp(System.currentTimeMillis()));
                likes.add(like);
            }
        }

        // Generate fake friend requests
        List<Friend> friendRequests = new ArrayList<>();
        for (User user : users) {
            for (int i = 0; i < 3; i++) {
                User otherUser = users.get(faker.number().numberBetween(0, 10));
                if (user != otherUser) {
                    Friend friendRequest = new Friend();
                    friendRequest.setUser1(user);
                    friendRequest.setUser2(otherUser);
                    friendRequest.setStatus(Status.PENDING);
                    friendRequest.setActionUser(null);
                    friendRequest.setCreated_at(new Timestamp(System.currentTimeMillis()));
                    friendRequest.setUpdated_at(new Timestamp(System.currentTimeMillis()));
                    friendRequests.add(friendRequest);
                }
            }
        }

        // Generate fake friend requests actions
        for (Friend friendRequest : friendRequests) {
            if (faker.bool().bool()) {
                friendRequest.setStatus(Status.ACCEPTED);
                friendRequest.setActionUser(friendRequest.getUser2());
            } else {
                friendRequest.setStatus(Status.DECLINED);
                friendRequest.setActionUser(friendRequest.getUser1());
            }
            friendRequest.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        }
        SpringApplication.run(FlexBookApplication.class, args);
    }

}
