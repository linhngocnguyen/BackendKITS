package com.example.flexbook.controller;

import com.example.flexbook.model.Post;
import com.example.flexbook.model.User;
import com.example.flexbook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }


    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        Post newPost = postService.createPost(post);
        return ResponseEntity.ok().body(newPost);
    }
}
