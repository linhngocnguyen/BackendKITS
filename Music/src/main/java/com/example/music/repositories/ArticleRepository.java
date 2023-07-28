package com.example.music.repositories;

import com.example.music.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query("SELECT a.articleId, a.title, a.songName, a.author.name, a.genre.name, a.creationTime FROM Article a")
    List<Object[]> getArticleDetails();
    @Query("select a from Article a where a.genre.name LIKE %:genre%")
    List<Article> findByGenreName(@Param("genre") String genre);
    @Query("select a from Article a where a.author.name LIKE %:author%")
    List<Article> findByAuthorName(@Param("author") String author);

    @Query("SELECT a FROM Article a WHERE a.songName LIKE %:keyword1% OR a.songName LIKE %:keyword2% OR a.songName LIKE %:keyword3% OR a.songName LIKE %:keyword4%")
    List<Article> findArticlesBySongNameContainingKeywords(@Param("keyword1") String keyword1, @Param("keyword2") String keyword2, @Param("keyword3") String keyword3, @Param("keyword4") String keyword4);

    @Query("SELECT a FROM Article a WHERE a.title LIKE %:keyword1% OR a.title LIKE %:keyword2% OR a.title LIKE %:keyword3% OR a.title LIKE %:keyword4%" +
            "OR a.songName LIKE %:keyword1% OR a.songName LIKE %:keyword2% OR a.songName LIKE %:keyword3% OR a.songName LIKE %:keyword4%")
    List<Article> findArticlesBySongNameOrTitleContainingKeywords(@Param("keyword1") String keyword1, @Param("keyword2") String keyword2, @Param("keyword3") String keyword3, @Param("keyword4") String keyword4);
}
