package com.study.java_study.ch04_제어;

import java.util.Scanner;

public class WhilePraMain {
    public static void main(String[] args) {
        WhilePra praMethod = new WhilePra();

        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;
        System.out.println("프로그램 시작");
        while (isRun) {
            System.out.println("[메인 메뉴]");
            System.out.println("1. 회원 등록");
            System.out.println("2. 회원 조회");
            System.out.println("3. 회원 탈퇴");
            System.out.println("q. 프로그램 종료");
            System.out.println();

            System.out.print("메뉴 입력: ");
            String selectedMenu = scanner.nextLine();
            switch(selectedMenu) {
                case "1":
                    break;
                case "2":
                  praMethod.userFind();
                    break;
                case "3":
                    break;

                case "q":
                    System.out.println("프로그램을 종료합니다");
                    isRun = false;
                    break;
            }
        }
        System.out.println("while문 나오고 완전 종료");

    }


    }
