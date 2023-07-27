package com.example.flexbook.controller;

import com.example.flexbook.model.Comment;
import com.example.flexbook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/{user_id}")
    public List<Comment> getCommentsByUser(@PathVariable int user_id) {
        return commentService.getCommentByUser(user_id);
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComment(@RequestBody Comment Comment){
        Comment newComment = commentService.createComment(Comment);
        return ResponseEntity.ok().body(newComment);
    }
}
