package org.example.member.controller;

import org.example.Container;
import org.example.member.entity.Member;
import org.example.member.service.MemberService;

public class MemberController {
    MemberService memberService = new MemberService();
    public void login() {
        if (Container.getLoginedMember() != null) {
            System.out.println("현재 로그인 상태입니다.");
            return;
        }

        System.out.printf("닉네임 : ");
        String nickname = Container.getSc().nextLine().trim();
        System.out.printf("비밀번호 : ");
        Long password = Container.getSc().nextLong();
        Container.getSc().nextLine();

        Member member = this.memberService.getFindByNickname(nickname);

        if (member == null) {
            System.out.println("해당 아이디는 존재하지 않습니다.");
            return;
        }

        if ((member.getPassword() == password) == false) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            return;
        }

        Container.setLoginedMember(member);

        System.out.println(Container.getLoginedMember().getNickname() + "님 환영합니다! 로그인이 완료됐습니다.");
    }

    public void logout() {
        Container.setLoginedMember(null);
        System.out.println("로그아웃이 완료됐습니다.");
    }
    public void join() {
    }
}
