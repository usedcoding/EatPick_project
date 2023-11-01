package org.example.article.service;

import org.example.article.repository.ArticleRepository;

public class ArticleService {
    ArticleRepository articleRepository = new ArticleRepository();
    public void write(long id, String category, String foodName, String brandName, long price, long weight, long scope, String review) {
        this.articleRepository.write(id, category, foodName, brandName, price, weight, scope, review);
    }

    public void myPost() {
        this.articleRepository.myPost();
    }
}
