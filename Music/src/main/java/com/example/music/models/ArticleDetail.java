package com.example.music.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ArticleDetail {
    private int articleId;
    private String title;
    private String songName;
    private String authorName;
    private String genreName;
    private LocalDateTime creationTime;
}
