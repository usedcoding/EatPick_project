package org.example;

import org.example.article.controller.ArticleController;
import org.example.member.controller.MemberController;
import org.example.member.service.MemberService;
import org.example.system.controller.SystemController;

public class App {
    SystemController systemController = new SystemController();
    MemberController memberController = new MemberController();
    ArticleController articleController = new ArticleController();
    public void run() {
        System.out.println("== Eat Pick 시작 ==");
        System.out.println("1.로그인");
        System.out.println("2.회원가입");
        System.out.println("3.종료");
        while (true) {
            System.out.printf("명령어) ");
            String command = Container.getSc().nextLine();
            switch (command) {
                case "종료":
                    systemController.exit();
                    return;
                case "로그인":
                    memberController.login();
                    System.out.println("1.게시글 작성");
                    System.out.println("2.내가 쓴 게시글 보기");
                    System.out.println("3.전체 게시글 보기");
                    System.out.println("4.카테고리 검색\n(탄수화물 / 육류 / 어류 / 식물성 / 영양제 / 보충제 / 기타)");
                    System.out.println("5.음식 검색");
                    System.out.println("6.브랜드 검색");
                    System.out.println("7.로그아웃");
                    System.out.println("8.종료");
                    break;
                case "로그아웃":
                    memberController.logout();
                    break;
                case "회원가입":
                    memberController.join();
                    break;
            }
        }
    }
}
