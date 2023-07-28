package com.example.music.controllers;

import com.example.music.models.Author;
import com.example.music.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/top-2")
    public List<Author> getTop2AuthorsWithMostArticles(){
        return authorService.getTop2AuthorsWithMostArticles();
    }
}
