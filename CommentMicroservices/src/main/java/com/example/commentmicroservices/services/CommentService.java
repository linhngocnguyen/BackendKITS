package com.example.ecommerce.services;

import com.example.ecommerce.exception.ThereIsNoCommentOnProductException;
import com.example.ecommerce.exception.ThereIsNoCommentOnUserException;
import com.example.ecommerce.models.Comment;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.User;
import com.example.ecommerce.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllCommentsByUser(User user) {
        List<Comment> comments = commentRepository.findAllByUser(user);
        if (comments.isEmpty()) {
            throw new ThereIsNoCommentOnUserException("There are no comments on the user: " + user.getUsername());
        }
        return comments;
    }

    public List<Comment> getAllCommentsByProduct(Product product) {
        List<Comment> comments = commentRepository.findAllByProduct(product);
        if (comments.isEmpty()) {
            throw new ThereIsNoCommentOnProductException("There are no comments on the product with ID: " + product.getProductId());
        }
        return comments;
    }
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteCommentById(Integer id) {
        commentRepository.deleteById(id);
    }
}
