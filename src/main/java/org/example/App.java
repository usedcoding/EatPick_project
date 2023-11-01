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
        Container.meneList1();
        while (true) {
            System.out.printf("명령어) ");
            String command = Container.getSc().nextLine();

            switch (command) {
                case "종료":
                    systemController.exit();
                    return;
            }

            if (Container.getLoginedMember() == null) {
                switch (command) {
                    case "로그인":
                        memberController.login();
                        break;
                    case "회원가입":
                        memberController.join();
                        break;
                }
            }
            else if (Container.getLoginedMember() != null) {
                switch (command) {
                    case "로그아웃":
                        memberController.logout();
                        break;
                    case "게시글 작성":
                        articleController.write();
                        break;
                }
            }
        }
    }
}
