package com.study.java_study.ch06_배열;

import java.util.Scanner;

public class BookArrayService {
    public static void main(String[] args) {

        /* while 반복문 안에서 진행한다
         * 등록의 경우 배열의 차례대로 추가한다 이때 배열 크기를 늘려주는 작업을 해야한다
         * 수정과 삭제는 함수를 만들어 이용한다
         * 3. 삭제의 경우 배열을 줄여야한다
         * 4. 책 이름 찾기는 반복문을 돌려서 값이 있다면 true
         * 전체조회는 지금까지 등록된 책을 한번에 출력한다
         */
        //선언부
        BookArrayUtils utils = new BookArrayUtils();
        Scanner sc = new Scanner(System.in);
        String[] books = new String[0];
        boolean isRun = true;

        //-----------------------
        while (isRun) {
            System.out.println();
            System.out.println("[책 관리 프로그램]");
            System.out.println("1. 등록");
            System.out.println("2. 수정");
            System.out.println("3. 삭제");
            System.out.println("4. 책 이름 찾기");
            System.out.println("5. 전체조회");
            System.out.println("q. 나가기");
            System.out.print("메뉴 선택: ");
            String selectedMenu = sc.nextLine();
            //선언부
            String[] newbooks = new String[books.length + 1];
            int findIndex = -1;
            //---------------------

            switch (selectedMenu) {
                case "1": // 추가
                    System.out.println("[책 등록]");
                    // 공간부터 늘리기
                    for (int i = 0; i < books.length; i++) {
                        newbooks[i] = books[i];
                    }
                    books = newbooks;
                    System.out.print("책 제목을 입력하세요 : ");
                    books[books.length - 1] = sc.nextLine();
                    newbooks = null;

                    System.out.println(books[books.length - 1] + "이(가) 추가 되었습니다");
                    System.out.println("메뉴로 돌아갑니다");
                    System.out.println();
                    break;
                case "2": // 수정
                    System.out.println("[수정]");
                    System.out.print("책 이름 : ");
                    String beforeModifyBook = sc.nextLine();
                    findIndex = utils.findIndexByName(books, beforeModifyBook);
                    if (findIndex == -1) {
                        System.out.println(books[findIndex] + " 를 찾을 수 없습니다");
                        break;
                    }
                    System.out.print("새 이름 : ");
                    books[findIndex] = sc.nextLine();
                    break;
                case "3": // 삭제
                    System.out.println("[삭제]");
                    newbooks = new String[books.length - 1];
                    System.out.print("삭제할 책 이름을 입력하세요 : ");
                    String removeBook = sc.nextLine();
                    findIndex = utils.findIndexByName(books, removeBook);
                    if (findIndex == -1) {
                        System.out.println("책을 찾을 수 없습니다");
                        break;
                    }
                    for (int i = 0; i < newbooks.length; i++) {
                        if (i < findIndex) {
                            newbooks[i] = books[i];
                            continue;
                        }
                        newbooks[i] = books[i + 1];
                    }

                    books = newbooks;
                    newbooks = null;
                    System.out.println("삭제가 완료되었음");
                    for (int i = 0; i < books.length; i++) {
                        System.out.println(i + "번 : " + books[i]);
                    }
                    break;
                case "4": // 책 이름 조회
                    System.out.println("[책 이름 조회");
                    System.out.print("찾고자 하는 책 이름을 입력하세요 : ");
                    String findBook = sc.nextLine();
                    findIndex = utils.findIndexByName(books, findBook);
                    if (findIndex == -1) {
                        System.out.println(findBook + "을(를) 찾을 수 없습니다");
                        break;
                    }
                    System.out.println(findBook + " 은(는) " + findIndex + "번 입니다");
                    System.out.println();
                    break;
                case "5": // 전체조회
                    System.out.println("[전체조회]");
                    for (int i = 0; i < books.length; i++) {
                        System.out.println(i + "번 : " + books[i]);
                    }
                    System.out.println();
                    break;
                case "q": // 나가기
                    System.out.println("프로그램을 종료합니다");
                    isRun = false;
                    break;
            }
        }
    }
}