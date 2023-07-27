package com.example.flexbook.service;

import com.example.flexbook.model.Comment;
import com.example.flexbook.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentByUser(int user_id) {
        return commentRepository.commentByUser(user_id);
    }

    public Comment createComment(Comment newComment){
        newComment.setCreated_at(Timestamp.from(Instant.now()));
        return commentRepository.save(newComment);
    }
}
