package com.example.commentmicroservices.controllers;


import com.example.commentmicroservices.models.Comment;
import com.example.commentmicroservices.models.Product;
import com.example.commentmicroservices.models.User;
import com.example.commentmicroservices.services.CommentService;
import com.example.commentmicroservices.services.ProductService;
import com.example.commentmicroservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;
    private UserService userService;

    private ProductService productService;

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.saveComment(comment);
        return ResponseEntity.ok(savedComment);
    }

    @GetMapping("/user/{userid}/all")
    public ResponseEntity<List<Comment>> getAllCommentsByUser(@PathVariable("userid") int userId) {
        User user = userService.getUserById(userId);
        List<Comment> comments = commentService.getAllCommentsByUser(user);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/product/{productid}/all")
    public ResponseEntity<List<Comment>> getAllCommentsByProduct(@PathVariable("productid") Integer productId) {
        Product product = productService.getProductById(productId);
        List<Comment> comments = commentService.getAllCommentsByProduct(product);
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("id") Integer id) {
        commentService.deleteCommentById(id);
        return ResponseEntity.noContent().build();
    }
}
