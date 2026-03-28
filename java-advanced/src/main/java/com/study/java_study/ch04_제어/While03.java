package com.study.java_study.ch04_제어;

import java.util.Scanner;

public class While03 {
    public static void main(String[] args) {
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
            System.out.print("메뉴 선택: ");
            String selectedMenu = scanner.nextLine();

            switch (selectedMenu) {
                case "1":
                    System.out.println("회원 등록으로 들어오셨습니다");
                    register();
                    break;
                case "2":
                    System.out.println("회원 조회로 들어오셨습니다");
//                    userFind();
                    boolean isRunMenu2 = true;
                    while (isRunMenu2) {
                        System.out.println("[회원 조회]");
                        System.out.println("1. 회원 번호로 조회");
                        System.out.println("2. 회원 이름으로 조회");
                        System.out.println("b. 뒤로가기");
                        System.out.print("메뉴 선택 : ");
                        selectedMenu = scanner.nextLine();
                        switch (selectedMenu) {
                            case "1":
                                System.out.println("회원 번호로 조회를 합니다");
                                break;
                            case "2":
                                System.out.println("회원 이름으로 조회를 합니다");
                                break;
                            case "b":
                                System.out.println("메인메뉴로 돌아갑니다");
                                isRunMenu2 = false;
                                break;
                                // 프로그램 종료에서 isRun = false 구문을 실행 한 상태에서 isRunMenu2를 다시실행 한 뒤 b 를 입력하게되면
                                // isRunMenu2 빠져나오고 isRun = false값 그대로 들고온 상태라 isRunMenu도 빠져나오게 됨

// --------------------------------------------------------------------------------------------
                            case "q":                                                        //
                                System.out.println("프로그램을 종료합니다");                     //
                                isRun = false;                                               //
//                                isRunMenu2 = false;                                        //
// --------------------------------------------------------------------------------------------

                            default:
                                System.out.println("다시 입력하세요.");
                        }
                        System.out.println();
                    }
                    break;
                case "3":
                    System.out.println("회원 탈퇴로 들어오셨습니다");
                    break;
                case "q":
                    System.out.println("프로그램을 종료합니다");
                    isRun = false;
                    break;
                default:
                    System.out.println("다시 입력하세요.");
            }
            System.out.println();

//            if (selectedMenu.equals("q")) {
//                isRun = false;
//            }
        }
        System.out.println("프로그램 종료");
    }

    static void register() {
        System.out.print("회원정보를 입력하세요 :");
        Scanner scanner = new Scanner(System.in);
        String user = scanner.nextLine();
    }

    static void userFind() {
        boolean isRunMenu2 = true;
        System.out.println("[회원 조회]");
        System.out.println("1. 회원 번호로 조회");
        System.out.println("2. 회원 이름으로 조회");
        System.out.println("b. 뒤로가기");
        System.out.print("메뉴 선택 : ");
    }
}
