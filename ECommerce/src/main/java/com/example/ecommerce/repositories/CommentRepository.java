package com.example.ecommerce.repositories;

import com.example.ecommerce.models.Comment;
import com.example.ecommerce.models.Product;
import com.example.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByUser(User user);

    List<Comment> findAllByProduct(Product product);
}