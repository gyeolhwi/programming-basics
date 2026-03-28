package com.study.java_study.ch04_제어;

import java.util.Scanner;

public class WhilePra {
    Scanner scanner = new Scanner(System.in);

    void userFind() {
        System.out.println("회원 조회로 들어오셨습니다");
        System.out.println();

        boolean isRunMenu = true;
        while (isRunMenu) {
            System.out.println("[회원 조회]");
            System.out.println("1. 회원 번호로 조회");
            System.out.println("2. 회원 이름으로 조회");
            System.out.println("b. 뒤로가기");
            System.out.print("메뉴 선택 : ");
            System.out.println();
            String selectedMenu = scanner.nextLine();
            switch (selectedMenu) {
                case "1":
                    System.out.println("회원 번호로 조회합니다");
                    break;
                case "2":
                    System.out.println("회원 이름으로합니다");
                    break;
                case "b":
                    System.out.println("메인메뉴로 돌아갑니다");
                    isRunMenu = false;
                    break;
                default:
                    System.out.println("잘 못 입력하였습니다 다시 입력하세요");
            }
            System.out.println();
        }
    }
}
