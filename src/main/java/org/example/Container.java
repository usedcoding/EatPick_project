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
}
