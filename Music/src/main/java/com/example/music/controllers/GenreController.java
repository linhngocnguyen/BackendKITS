package com.example.music.controllers;

import com.example.music.models.Genre;
import com.example.music.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/no-article")
    public List<Genre> getGenreWithoutArticles(){
        return genreService.getGenresWithoutArticles();
    }

    @GetMapping("/most-articles")
    public Genre getGenreWithMostArticles(){
        return genreService.getGenreWithMostArticles();
    }
}
