package com.example.commentmicroservices.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tb_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String content;
    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;
    private LocalDateTime createdAt = LocalDateTime.now();;
    private LocalDateTime updatedAt = LocalDateTime.now();;
}