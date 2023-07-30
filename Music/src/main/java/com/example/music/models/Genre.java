package com.example.music.models;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="theloai")
@Entity
@Data
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_tloai")
    private int genreId;
    @Column(name="ten_tloai",nullable = false)
    private String name;
}
