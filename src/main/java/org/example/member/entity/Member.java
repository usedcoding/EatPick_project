package org.example.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
    private int id;
    private String nickname;
    private long password;
    private String regDate;
}
