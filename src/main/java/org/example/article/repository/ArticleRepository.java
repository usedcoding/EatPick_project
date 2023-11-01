package org.example.article.repository;

import org.example.article.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    List<Article> articles = new ArrayList<>();

    public void write(long id, String category, String foodName, String brandName, long price, long weight, long scope, String review) {
        Article article = new Article(id, category, foodName, brandName, price, weight, scope, review);
        articles.add(article);
    }

    public void myPost() {
        for (int i = articles.size() - 1; i >= 0; i--) {
            System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %d / %d / $s\n");
        }
    }
}
