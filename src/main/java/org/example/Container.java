package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.member.entity.Member;
import org.example.system.controller.SystemController;

import java.util.Scanner;

public class Container {
    @Getter
    private static Scanner sc;

    @Getter
    @Setter
    private static Member loginedMember = null;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void close() {
        sc.close();
    }

    public static void meneList1() {
        System.out.println("1.로그인 / 2.회원가입 / 3.종료");
    }

    public static void meneList2() {
        System.out.println("1.게시글 작성 / 2.나의 게시글 / 3.전체 게시글 / 4.카테고리 검색 / 5.음식명 검색 / 6.브랜드명 검색 / 7.로그아웃 / 8.종료");
    }

}
