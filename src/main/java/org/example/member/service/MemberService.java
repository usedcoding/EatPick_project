package org.example.member.service;

import org.example.member.entity.Member;
import org.example.member.repository.MemberRepository;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    public Member getFindByNickname(String nickname) {
        return this.memberRepository.getFindByNickname(nickname);
    }

    public void join(String nickname, String password) {
        this.memberRepository.join(nickname, password);
    }
}
