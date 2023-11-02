package org.example.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    private int id;
    private String nickname;
    private String password;
    private String regDate;

    public Member(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.nickname = (String)row.get("nickname");
        this.password = (String)row.get("password");
        this.regDate = (String)row.get("regDate");
    }

    public Member(String nickname, String password, String regDate) {
        this.nickname = nickname;
        this.password = password;
        this.regDate = regDate;
    }
}
