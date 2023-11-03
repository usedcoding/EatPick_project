package org.example.article.controller;

import org.example.Container;
import org.example.article.entity.Article;
import org.example.article.service.ArticleService;
import org.example.util.Util;

import java.util.List;

public class ArticleController {
    ArticleService articleService = new ArticleService();

    public void write() {
        String category;
        String foodName;
        String brandName;
        int price;
        int weight;
        int scope;
        String review;

        System.out.println("\n1.카테고리를 입력해 주세요. (탄수화물 / 육류 / 어류 / 식물성 / 영양제 / 보충제 / 기타)");
        while (true) {
            category = Container.getSc().nextLine().trim();

            switch (category) {
                case "탄수화물":
                    break;
                case "육류":
                    break;
                case "어류":
                    break;
                case "식물성":
                    break;
                case "영양제":
                    break;
                case "보충제":
                    break;
                case "기타":
                    break;
                default:
                    System.out.println("\n올바른 카테고리를 입력해 주세요.");
                    continue;
            }
            break;
        }
        System.out.println("\n2.음식명을 입력해 주세요.");
        foodName = Container.getSc().nextLine().trim();

        System.out.println("\n3.브랜드명을 입력해 주세요.");
        brandName = Container.getSc().nextLine().trim();

        System.out.println("\n4.가격을 입력해 주세요.");
        while (true) {
            try {
                price = Integer.parseInt(Container.getSc().nextLine());
            }
            catch (Exception e) {
                System.out.println("\n입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("\n5.중량을 입력해 주세요.");
        while (true) {
            try {
                weight = Integer.parseInt(Container.getSc().nextLine());
            }
            catch (Exception e) {
                System.out.println("\n입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("\n6.별점을 입력해 주세요.\n5점 만점(1 / 2 / 3 / 4 / 5)");
        while (true) {
            try {
                scope = Integer.parseInt(Container.getSc().nextLine());
                if (scope > 5 || scope == 0) {
                    System.out.println("\n입력된 값은 정해진 값이 아닙니다. 다시 입력해 주세요.");
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("\n입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("\n7.한 줄 리뷰를 입력해 주세요.");
        review = Container.getSc().nextLine().trim();

        this.articleService.write(category, foodName, brandName, price, weight, scope, review, Container.getLoginedMember().getNickname());

        System.out.println("\n게시글 등록이 완료되었습니다.");

        Container.meneList2();
    }
    public void modify() {
        myPostList();

        System.out.println("\n수정할 번호를 입력해 주세요.");
        String inputNum = Container.getSc().nextLine().trim();

    }
    public void remove() {

    }
    public void myPost() {
        List<Article> articles = articleService.getArticleListMy();

        if (articles.size() == 0) {
            System.out.println("\n게시글이 존재하지 않습니다.");

            Container.meneList2();
        }
        else {
            System.out.println("\n번호 / 카테고리 / 음식명 / 브랜드명 / 가격 / 중량 / 별점 / 한 줄 리뷰");
            System.out.println("=".repeat(70));

            for (int i = 0; i < articles.size(); i++) {
                Article article = articles.get(i);
                if (Container.getLoginedMember().getNickname().equals(article.getWriter())) {
                    System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %d" + "g,ml" + " / %d" + "점" + " / %s\n", article.getId(), article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview());
                }
            }

            Container.meneList2();
        }
    }
    public void allPost() {
        List<Article> articles = articleService.getArticleListAll();

        if (articles.size() == 0) {
            System.out.println("\n게시글이 존재하지 않습니다.");

            Container.meneList2();
        }
        else {
            System.out.println("\n번호 / 카테고리 / 음식명 / 브랜드명 / 가격 / 중량 / 별점 / 한 줄 리뷰 / 작성자");
            System.out.println("=".repeat(70));

            for (int i = 0; i < articles.size(); i++) {
                Article article = articles.get(i);
                System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %d" + "g,ml" + " / %d" + "점" + " / %s / %s\n", article.getId(), article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview(), article.getWriter());
            }

            Container.meneList2();
        }
    }

    public void myPostList() {
        List<Article> articles = articleService.getArticleListMy();

        if (articles.size() == 0) {
            System.out.println("\n게시글이 존재하지 않습니다.");

            Container.meneList2();
        }
        else {
            System.out.println("\n번호 / 카테고리 / 음식명 / 브랜드명 / 가격 / 중량 / 별점 / 한 줄 리뷰");
            System.out.println("=".repeat(70));

            for (int i = 0; i < articles.size(); i++) {
                Article article = articles.get(i);
                if (Container.getLoginedMember().getNickname().equals(article.getWriter())) {
                    System.out.printf("%d / %s / %s / %s / %d" + "원" + " / %d" + "g,ml" + " / %d" + "점" + " / %s\n", article.getId(), article.getCategory(), article.getFoodName(), article.getBrandName(), article.getPrice(), article.getWeight(), article.getScope(), article.getReview());
                }
            }
        }
    }
}
