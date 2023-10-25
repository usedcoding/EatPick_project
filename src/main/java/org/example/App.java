package org.example;

import jdk.jshell.spi.SPIResolutionException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor

public class App {
    Scanner sc = new Scanner(System.in);

    int id = 0;

    List<Member> members = new ArrayList<>();

    public void run() {
        System.out.println("== Eat Pick 프로그램 시작 ==");

        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("3. 종료");

        while (true) {
            System.out.printf("명령어) ");
            String command = sc.nextLine();
            if (command.equals("종료")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            if (command.equals("회원가입")) {
                String userId;
                String userPw;
                String userPwConfirm;

                while (true) {
                    System.out.println("아이디 : ");
                    userId = sc.nextLine();

                    Member member = this.getUserIdCheck(userId);

                    if (member == null) {
                        System.out.println("아이디가 중복입니다. 다시 입력해 주세요.");
                        continue;
                    }
                    break;
                }

                while (true) {
                    System.out.println("비밀번호 : ");
                    userPw = sc.nextLine();
                    System.out.println("비밀번호 확인 : ");
                    userPwConfirm = sc.nextLine();

                    if (userPw.equals(userPwConfirm) == false) {
                        System.out.println("비밀번호가 동일하지 않습니다. 다시 입력해 주세요.");
                        continue;
                    }
                    break;
                }

                LocalDate now = LocalDate.now();

                id += 1;

                Member member = new Member(id, userId, userPw, now.toString());
                members.add(member);

                System.out.println(userId + "님 회원가입이 완료되었습니다.");
            }
        }

        sc.close();
    }

    private Member getUserIdCheck(String userId) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getUserId().equals(userId)) {
                return member;
            }
        }
        return null;
    }
}
