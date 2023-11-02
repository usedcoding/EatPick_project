package org.example.article.service;

import org.example.article.entity.Article;
import org.example.article.repository.ArticleRepository;

import java.util.List;

public class ArticleService {
    ArticleRepository articleRepository = new ArticleRepository();
    public void write(String category, String foodName, String brandName, long price, long weight, long scope, String review, String writer) {
        this.articleRepository.write(category, foodName, brandName, price, weight, scope, review, writer);
    }

    public void myPost() {
        this.articleRepository.myPost();
    }

    public List<Article> getArticleListAll() {
        return this.articleRepository.getArticleListAll();
    }
}
