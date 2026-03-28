package com.study.java_study.ch09_클래스04;

import java.util.Scanner;

public class BookService { // interface
    private Scanner scanner;
    private BookRepository bookRepository;

    public BookService() {
        scanner = new Scanner(System.in);
        bookRepository = new BookRepository();
    }


    private String selectMenu() {
        String[] menus = {"1", "2", "3", "4", "5", "q"};
        String selectedMenu = null;

        while (true) {
            System.out.print("메뉴 선택: ");
            selectedMenu = scanner.nextLine();
            for (String menu : menus) {
                if (menu.equals(selectedMenu)) {
                    return selectedMenu;
                }
            }
//            if (Arrays.binarySearch(menus, selectedMenu) > -1) {break;} -> 이진탐색 비교 메서드
            System.out.println("잘못 입력하였습니다 다시 입력하세요");
        }
    }


    public boolean run() {
        boolean isRun = true;

        System.out.println("[ 도서 관리 프로그램]");
        System.out.println("1. 도서 등록");
        System.out.println("2. 도서 검색");
        System.out.println("3. 도서 수정");
        System.out.println("4. 도서 삭제");
        System.out.println("5. 전체조회");
        System.out.println("q. 프로그램 종료");
        String selectedMenu = selectMenu();

        switch (selectedMenu) {
            case "q":
                isRun = false;
                break;
            case "1":
                registerBook();
                break;
            case "2":
                search();
                break;

            case "3":
                modify();
                break;

            case "4":
                remove();
                break;
            case "5":
                findAll();
                break;
            default:
                System.out.println("입력오류");
        }
        System.out.println();

        return isRun;
    }

    //전체조회
    private void findAll() {
        BookEntity[] books = bookRepository.findAlls();
        for (BookEntity book : books) {
            System.out.println(book.toString());
        }
    }

    // 입력받기 메소드 title -> 도서,저자,
    private String validateValue(String title) {
        String value = null;
        while (true) {
            System.out.print(title + "명 입력: ");
            value = scanner.nextLine();
            // 공백체크
            if (!value.isBlank()) {
                break;
            }
            System.out.println(title + "명은 공백일 수 없습니다. 다시 입력하세요");
        }
        return value;
    }

    private String duplicateBookName() {
        String bookName = null;
        while (true) {
            // 공백체크
            bookName = validateValue("도서");
            // 중복체크
            if (bookRepository.findBookByBookName(bookName) == null) {
                break;
            }
            System.out.println("해당 도서명이 이미 존재합니다. 다시 입력하세요");
        }
        return bookName;
    }

    // 1. 도서등록
    private void registerBook() {
        // 중복체크
        System.out.println("[ 도서 등록]");
        // 도서객체를 생성하기 위해서 실행하는 메소드
        int bookId = bookRepository.autoIncrementBookId();
        String bookName = duplicateBookName();
        String author = validateValue("저자");
        String publisher = validateValue("출판사");

        // 도서 등록 완료
        BookEntity book = new BookEntity(bookId, bookName, author, publisher);
        bookRepository.saveBook(book);
        System.out.println(book.toString() + "\n새로운 도서를 등록하였습니다.");

    }

    // 2. 도서 검색
    private void search() {
        System.out.println("[ 도서검색 ]");
        System.out.println("1. 통합검색");
        System.out.println("2. 도서명 검색");
        System.out.println("3. 저자명 검색");
        System.out.println("4. 출판사명 검색");
        System.out.print("옵션 선택: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        System.out.print("검색어 입력 :");
        String searchText = scanner.nextLine();

        BookEntity[] searchBooks = bookRepository.searchBooks(option, searchText);

        if (searchBooks.length == 0) {
            System.out.println("검색 결과가 없습니다");
            return;
        }
        for (BookEntity book : searchBooks) {
            System.out.println(book.toString());
        }
    }

    // 4. 도서삭제
    public void remove() {
        System.out.println("[도서삭제]");
        search();
        System.out.print("삭제할 도서 번호를 입력 :");
        int removeId = scanner.nextInt();
        scanner.nextLine();
        BookEntity book = bookRepository.findBookByBookId(removeId);
        if (book == null) {
            System.out.println("해당 도서번호는 존재하지 않습니다");
            return;
        }
        bookRepository.deleteBookByBookId(removeId);
    }

    // 도서수정
    private void modify() {
        System.out.println("[도서 수정]");
        search();
        System.out.print("수정 할 도서번호 입력: ");
        int modifyBookId = scanner.nextInt();
        scanner.nextLine();
        BookEntity book = bookRepository.findBookByBookId(modifyBookId);

        if (book == null) {
            System.out.println("해당 도서번호는 존재하지 않습니다");
            return;
        }

        System.out.println("<<도서 수정 정보 입력 >>");
        for (int i = 0; i < 3; i++) {
            String selected = null;
            switch (i) {
                case 0:
                    System.out.print("도서명을 수정하시겠습니까?(y/n) : ");
                    selected = scanner.nextLine();
                    if (selected.equalsIgnoreCase("y")) {
                        String bookName = duplicateBookName();
                        book.setBookName(bookName);
                        break;
                    }
                    break;

                case 1:
                    System.out.print("저자명을 수정하시겠습니까?(y/n) : ");
                    selected = scanner.nextLine();
                    if (selected.equalsIgnoreCase("y")) {
                        String author = validateValue("저자");
                        book.setAuthor(author);
                        break;
                    }
                    break;
                case 2:
                    System.out.print("출판사명을 수정하시겠습니까?(y/n) : ");
                    selected = scanner.nextLine();
                    if (selected.equalsIgnoreCase("y")) {
                        String publisher = validateValue("출판사");
                        book.setPublisher(publisher);
                        break;
                    }
            }
            System.out.println();
            System.out.println("수정되었습니다");
        }
    }


}