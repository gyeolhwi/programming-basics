package com.study.java_study.ch17_컬렉션;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookArrayListMain {
    public static void main(String[] args) {
        
        /*
            도서명 : 도서 n
            저자명 : 저자 n  세번 입력받기
            new Book("도서n","저자n");
            반복 될 때 마다 bookList 추가

            도서 전체 조회
            도서명 >> 도서 1 ~ 3
            저자명 >> 저자 1 ~ 3

            삭제 할 도서명 : 도서 2

            도서 전체 조회
            도서명 >> 도서 1 , 3
            저자명 >> 저자 1 , 3
        */
        Scanner scanner = new Scanner(System.in);
        List<BookArray> bookList = new ArrayList<>();
//        List<String> bookList = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            String bookName;
            String author;
            System.out.print("도서명 : ");
            bookName = scanner.nextLine();
            System.out.print("저자명 : ");
            author = scanner.nextLine();

            bookList.add(new BookArray(bookName, author));
        }
        for (BookArray book : bookList) {
            System.out.println("도서명: " + book.getBookName());
            System.out.println("저자명: " + book.getAuthor());
        }
        System.out.print("삭제 할 도서명 :");
        String removeBookName = scanner.nextLine();

        for (BookArray book : bookList) {
            if (book.getBookName().equals(removeBookName)) {
                bookList.remove(book);
                break;
            }
        }
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getBookName().equals(removeBookName)) {
                bookList.remove(i);
                System.out.println("삭제된 도서 정보 : " + removeBookName);
            }
        }


        for (BookArray book : bookList) {
            System.out.println("도서명: " + book.getBookName());
            System.out.println("저자명: " + book.getAuthor());
        }

        for (int i = 0; i < bookList.size(); i++) {
            System.out.println("도서명: " + bookList.get(i).getBookName());
            System.out.println("저자명: " + bookList.get(i).getAuthor());
        }


    }
}
