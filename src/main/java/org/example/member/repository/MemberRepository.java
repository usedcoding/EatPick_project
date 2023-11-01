package org.example.member.repository;

import org.example.member.entity.Member;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    List<Member> members = new ArrayList<>();

    public MemberRepository() {
        Member manager = new Member(0, "관리자", "111", Util.nowDateTime());
        members.add(manager);
        Member tester = new Member(0, "테스터", "111", Util.nowDateTime());
        members.add(tester);
    }
    public Member getFindByNickname(String nickname) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getNickname().equals(nickname)) {
                return member;
            }
        }
        return null;
    }

    public void join(int id, String nickname, String password, String regDate) {
        Member member = new Member(id, nickname, password, regDate);
        members.add(member);
    }
}
