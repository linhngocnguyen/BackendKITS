package com.example.music.models;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="tacgia")
@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_tgia")
    private int authorId;
    @Column(name="ten_tgia",length = 100, nullable = false)
    private String name;
    @Column(name="hinh_tgia",length = 100)
    private String picture;

}
