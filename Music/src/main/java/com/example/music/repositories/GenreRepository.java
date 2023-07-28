package com.example.music.repositories;

import com.example.music.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Query("SELECT g FROM Genre g WHERE NOT EXISTS (SELECT a FROM Article a WHERE a.genre = g)")
    List<Genre> findGenresWithoutArticles();

    @Query("SELECT g FROM Genre g JOIN Article a ON g.genreId = a.genre.genreId GROUP BY g.genreId, g.name ORDER BY COUNT(a) DESC LIMIT 1")
    Genre findGenreWithMostArticles();
}
