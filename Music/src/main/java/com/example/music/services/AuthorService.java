package com.example.music.services;

import com.example.music.models.Author;
import com.example.music.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getTop2AuthorsWithMostArticles() {
        List<Object[]> results = authorRepository.findTop2AuthorsWithArticleCount();
        List<Author> topAuthors = new ArrayList<>();

        for (Object[] result : results) {
            Author author = (Author) result[0];
            topAuthors.add(author);
        }

        return topAuthors;
    }
}
