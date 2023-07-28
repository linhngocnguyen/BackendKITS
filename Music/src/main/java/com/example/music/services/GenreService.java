package com.example.music.services;

import com.example.music.models.Genre;
import com.example.music.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getGenresWithoutArticles(){
        return genreRepository.findGenresWithoutArticles();
    }

    public Genre getGenreWithMostArticles(){
        return genreRepository.findGenreWithMostArticles();
    }
}
