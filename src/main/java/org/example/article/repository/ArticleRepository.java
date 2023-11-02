package org.example.article.repository;

import org.example.Container;
import org.example.article.entity.Article;
import org.example.db.DBConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    private DBConnection dbConnection;

    public ArticleRepository () {
        dbConnection = Container.getDBconnection();
    }

    List<Article> articles = new ArrayList<>();
    long postId;

    public void write(String category, String foodName, String brandName, long price, long weight, long scope, String review, String writer) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("INSERT INTO article "));
        sb.append(String.format("SET category = '%s', ", category));
        sb.append(String.format("foodName = '%s', ", foodName));
        sb.append(String.format("brandName = '%s', ", brandName));
        sb.append(String.format("price = %d, ", price));
        sb.append(String.format("weight = %d, ", weight));
        sb.append(String.format("scope = %d, ", scope));
        sb.append(String.format("review = '%s', ", review));
        sb.append(String.format("writer = '%s', ", writer));
        sb.append(String.format("regDate = now() "));

        int id = dbConnection.insert(sb.toString());
    }

    public void myPost() {
        postId = 1;
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (Container.getLoginedMember().getNickname().equals(article.getWriter())) {
                System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %d" + "g,ml" + " / %d" + "점" + " / %s\n", postId, article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview());
                postId++;
            }
        }
    }

    public void allPost() {
        postId = 1;
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %d" + "g,ml" + " / %d" + "점" + " / %s / %s\n", postId, article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview(), article.getWriter());
            postId++;
        }
    }

    public List<Article> getArticleListAll() {
        List<Article> articles = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("SELECT * FROM article"));

        List<Map<String, Object>> rows = dbConnection.selectRows(sb.toString());

        for (Map<String, Object> row : rows) {
            articles.add(new Article(row));
        }

        return articles;
    }
}
