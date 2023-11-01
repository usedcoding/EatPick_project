package org.example.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Article {
    private long id;
    private String category;
    private String foodName;
    private String brandName;
    private long price;
    private long weight;
    private long scope;
    private String review;
}
