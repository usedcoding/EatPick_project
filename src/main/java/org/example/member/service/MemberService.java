package org.example.member.service;

import org.example.member.entity.Member;
import org.example.member.repository.MemberRepository;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    public Member getFindByNickname(String nickname) {
        return this.memberRepository.getFindByNickname(nickname);
    }

    public void join(int id, String nickname, String password, String regDate) {
        this.memberRepository.join(id, nickname, password, regDate);
    }
}
