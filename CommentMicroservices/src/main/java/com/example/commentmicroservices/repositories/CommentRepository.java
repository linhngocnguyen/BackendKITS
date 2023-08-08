package com.example.commentmicroservices.repositories;

import com.example.commentmicroservices.models.Comment;
import com.example.commentmicroservices.models.Product;
import com.example.commentmicroservices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByUser(User user);

    List<Comment> findAllByProduct(Product product);
}