package org.example.article.controller;

import org.example.Container;
import org.example.article.service.ArticleService;

public class ArticleController {
    ArticleService articleService = new ArticleService();
    long id = 0;
    public void write() {
        String category;
        String foodName;
        String brandName;
        long price;
        long weight;
        long scope;
        String review;

        System.out.println("1.카테고리를 입력해 주세요. (탄수화물 / 육류 / 어류 / 식물성 / 영양제 / 보충제 / 기타)");
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
                    System.out.println("올바른 카테고리를 입력해 주세요.");
                    continue;
            }
            break;
        }
        System.out.println("2.음식명을 입력해 주세요.");
        foodName = Container.getSc().nextLine().trim();

        System.out.println("3.브랜드명을 입력해 주세요.");
        brandName = Container.getSc().nextLine().trim();

        System.out.println("4.가격을 입력해 주세요.");
        while (true) {
            try {
                price = Integer.parseInt(Container.getSc().nextLine());
            }
            catch (Exception e) {
                System.out.println("입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("5.중량을 입력해 주세요.");
        while (true) {
            try {
                weight = Integer.parseInt(Container.getSc().nextLine());
            }
            catch (Exception e) {
                System.out.println("입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("6.별점을 입력해 주세요.\n5점 만점(1 / 2 / 3 / 4 / 5)");
        while (true) {
            try {
                scope = Integer.parseInt(Container.getSc().nextLine());
                if (scope > 5 || scope == 0) {
                    System.out.println("입력된 값은 정해진 값이 아닙니다. 다시 입력해 주세요.");
                    continue;
                }
            }
            catch (Exception e) {
                System.out.println("입력된 값은 숫자가 아닙니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        System.out.println("7.한 줄 리뷰를 입력해 주세요.");
        review = Container.getSc().nextLine().trim();

        id++;

        this.articleService.write(id, category, foodName, brandName, price, weight, scope, review);

        System.out.println("게시글 작성이 완료되었습니다.");

        Container.meneList2();
    }

    public void myPost() {
        System.out.println("번호 / 카테고리 / 음식명 / 브랜드명 / 가격 / 중량 / 별점 / 한 줄 리뷰");
        System.out.println("=".repeat(30));
        this.articleService.myPost();
    }
}
