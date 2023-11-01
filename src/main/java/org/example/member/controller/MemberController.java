package org.example.member.controller;

import org.example.Container;
import org.example.member.entity.Member;
import org.example.member.service.MemberService;
import org.example.util.Util;

public class MemberController {
    MemberService memberService = new MemberService();
    int lastId = 0;
    public void login() {
        System.out.printf("닉네임 : ");
        String nickname = Container.getSc().nextLine().trim();
        System.out.printf("비밀번호 : ");
        String password = Container.getSc().nextLine().trim();

        Member member = this.memberService.getFindByNickname(nickname);

        if (member == null) {
            System.out.println("해당 아이디는 존재하지 않습니다.");
            return;
        }

        if (member.getPassword().equals(password) == false) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }

        Container.setLoginedMember(member);

        System.out.println(Container.getLoginedMember().getNickname() + "님 환영합니다! 로그인이 완료됐습니다.");

        Container.meneList2();
    }

    public void logout() {
        Container.setLoginedMember(null);
        System.out.println("로그아웃이 완료됐습니다.");

        Container.meneList1();
    }
    public void join() {
        String nickname;
        String password;
        String passwordConfirm;

        while (true) {
            System.out.println("닉네임을 입력해 주세요.");
            nickname = Container.getSc().nextLine().trim();

            Member member = this.memberService.getFindByNickname(nickname);

            if (member != null) {
                System.out.println("해당 닉네임은 중복된 닉네임 입니다. 다른 닉네임을 입력해 주세요.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.printf("비밀번호 : ");
            password = Container.getSc().nextLine().trim();
            System.out.printf("비밀번호 확인 : ");
            passwordConfirm = Container.getSc().nextLine().trim();

            if (password.equals(passwordConfirm) == false) {
                System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
                continue;
            }
            break;
        }

        lastId++;

        this.memberService.join(lastId, nickname, password, Util.nowDateTime());

        System.out.println("회원가입이 완료됐습니다.");

        Container.meneList1();
    }
}
