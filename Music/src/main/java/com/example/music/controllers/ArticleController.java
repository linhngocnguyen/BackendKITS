package com.example.music.controllers;

import com.example.music.models.Article;
import com.example.music.models.ArticleDetail;
import com.example.music.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/genre")
    public List<Article> getByGenreName(){
        return articleService.getByGenreName();
    }

    @GetMapping("/author")
    public List<Article> getByAuthorName(){
        return articleService.getByAuthorName();
    }

    @GetMapping("/all")
    public List<ArticleDetail> getArticleDetails(){
        return articleService.getArticleDetails();
    }

    @GetMapping("/song-name-keywords")
    public List<Article> getArticlesBySongNameContainingKeywords(){
        return articleService.getArticlesBySongNameContainingKeywords();
    }

    @GetMapping("/song-name-title-keywords")
    public List<Article> getArticlesBySongNameOrTitleContainingKeywords(){
        return articleService.getArticlesBySongNameOrTitleContainingKeywords();
    }
}
