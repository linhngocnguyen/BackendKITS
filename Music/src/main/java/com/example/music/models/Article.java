package com.example.music.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name="baiviet")
@Entity
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ma_bviet")
    private int articleId;
    @Column(name="tieude", nullable = false, length = 200)
    private String title;
    @Column(name="ten_bhat", nullable = false, length = 100)
    private String songName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ma_tloai", referencedColumnName = "ma_tloai")
    private Genre genre;
    @Column(name="tomtat", nullable = false)
    private String summary;
    @Column(name="noidung")
    private String content;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ma_tgia", referencedColumnName = "ma_tgia")
    private Author author;

    @Column(name="ngayviet", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationTime;
    @Column(name="hinhanh", length = 200)
    private String picture;
}
