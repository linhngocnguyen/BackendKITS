package com.example.flexbook.service;

import com.example.flexbook.model.Post;
import com.example.flexbook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public Post createPost(Post newPost){
        newPost.setCreated_at(Timestamp.from(Instant.now()));
        return postRepository.save(newPost);
    }
}
