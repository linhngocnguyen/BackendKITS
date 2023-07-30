package com.example.music.repositories;

import com.example.music.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query("SELECT a, COUNT(ar) AS articleCount FROM Author a JOIN Article ar ON ar.author = a GROUP BY a ORDER BY articleCount DESC LIMIT 2")
    List<Object[]> findTop2AuthorsWithArticleCount();
}
