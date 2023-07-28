package com.example.music.services;

import com.example.music.models.Article;
import com.example.music.models.ArticleDetail;
import com.example.music.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    public List<Article> getByGenreName(){
        return articleRepository.findByGenreName("Nhạc trữ tình");
    }

    public List<Article> getByAuthorName(){
        return articleRepository.findByAuthorName("Nhacvietplus");
    }

    public List<ArticleDetail> getArticleDetails() {
        List<Object[]> results = articleRepository.getArticleDetails();
        List<ArticleDetail> articleDetailsList = new ArrayList<>();

        for (Object[] result : results) {
            int articleId = (int) result[0];
            String title = (String) result[1];
            String songName = (String) result[2];
            String authorName = (String) result[3];
            String genreName = (String) result[4];
            LocalDateTime creationTime = (LocalDateTime) result[5];

            ArticleDetail articleDetails = new ArticleDetail(articleId, title, songName, authorName, genreName, creationTime);
            articleDetailsList.add(articleDetails);
        }

        return articleDetailsList;
    }

    public List<Article> getArticlesBySongNameContainingKeywords() {
        String keyword1 = "yêu";
        String keyword2 = "thương";
        String keyword3 = "anh";
        String keyword4 = "em";

        return articleRepository.findArticlesBySongNameContainingKeywords(keyword1, keyword2, keyword3, keyword4);
    }

    public List<Article> getArticlesBySongNameOrTitleContainingKeywords() {
        String keyword1 = "yêu";
        String keyword2 = "thương";
        String keyword3 = "anh";
        String keyword4 = "em";

        return articleRepository.findArticlesBySongNameOrTitleContainingKeywords(keyword1, keyword2, keyword3, keyword4);
    }
}
