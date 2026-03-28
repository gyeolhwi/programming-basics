package com.study.java_study.ch09_클래스04;

import java.util.Arrays;

public class BookRepository {
    // @Mapper
    // CRUD가 이루어질 곳

    private int bookId;
    private BookEntity[] books;

    public BookRepository() {
        books = new BookEntity[0];
    }

    public int autoIncrementBookId() {
        return ++bookId;
    }

    //배열확장
    private void extendBooks() {
//        BookEntity[] newBooks = new BookEntity[books.length + 1]; // 위에 기존 생성되는 books의 배열길이 +1 하나 생성하여 추가할거다
//        for (int i = 0; i < books.length; i++) {
//            newBooks[i] = books[i];
//        }
        books = Arrays.copyOf(books, books.length + 1);
        // 기존의 배열이 들어있는 books 변수에 새로운 배열의 주소를 대입 ( 배열 크기 늘리기 )
//        books = newBooks;
    }

    private int getLastIndex() {
        return books.length - 1;
    }


    // 왜 생성자에서 넣어주느냐 레포지토리 클래스가 생성될 때 배열도 같이 생성되어 주입하는 방식 (종속성 주입 DI)
    // 책 등록하기
    public void saveBook(BookEntity book) {
        extendBooks();

        // 배열의 마지막 인덱스에 매개변수로 받아 온 book 객체를 대입 ( 등록 )
        books[getLastIndex()] = book;
    }


    // 책 Id로 찾기
    public BookEntity findBookByBookId(int bookId) {
        BookEntity findBook = null;

        // 선형탐색
        for (BookEntity book : books) {
            if (book.getBookId() == bookId) {
                findBook = book;
                break;
            }
        }

        return findBook;
    }

    // 단건조회
    // 책 이름으로 찾기 이 메소드를 호출 했을 때 값이 들어있냐 없냐에 따라서 다음메소드실행
    public BookEntity findBookByBookName(String bookName) {
        BookEntity findBook = null;

        // 선형탐색
        for (BookEntity book : books) {
            if (book.getBookName().equals(bookName)) {
                findBook = book;
                break;
            }
        }
        return findBook;
    }

    // 연관검색의 배열크기를 설정하는 메소드
    /*
    public int getNewArraySize(String bookName, String author, String publisher) {
        int newArraySize = 0;
        for (BookEntity book : books) {
            if (book.getBookName().contains(bookName)
                    || book.getAuthor().contains(author)
                    || book.getPublisher().contains(publisher)) {
                newArraySize++;
            }
        }
        return newArraySize;
    }

    */


    // 연관검색
    // 다건조회
    /*
    public BookEntity[] searchBooks(String bookName, String author, String publisher) {
        int newArraySize = getNewArraySize(bookName, author, publisher);
        BookEntity[] searchBooks = new BookEntity[newArraySize];

        int cnt = 0;
        for (BookEntity book : books) {
            // equals 정확한 정보만을 받음 contains 문자열의 포함되어있다면 true값을 줌
            if (book.getBookName().contains(bookName)
                    || book.getAuthor().contains(author)
                    || book.getPublisher().contains(publisher)) {
                searchBooks[cnt] = book;
                cnt++;
            }
        }
        return searchBooks;
    }
     */
    public BookEntity[] findAlls(){
        return books;
    }
    //전체조회

    //다건조회 배열 추가
    public int getNewArraySize1(int option, String searchText) {
        int newArraySize = 0;
        switch (option) {
            case 1:     //통합검색
                for (BookEntity book : books) {
                    if (book.getBookName().contains(searchText)
                            || book.getAuthor().contains(searchText)
                            || book.getPublisher().contains(searchText)) {
                        newArraySize++;
                    }
                }
                break;
            case 2:     //도서명검색
                for (BookEntity book : books) {
                    if (book.getBookName().contains(searchText)) {
                        newArraySize++;
                    }
                }
                break;
            case 3:     //저자명검색
                for (BookEntity book : books) {
                    if (book.getAuthor().contains(searchText)) {
                        newArraySize++;
                    }
                }
                break;
            case 4:     //출판사검색
                for (BookEntity book : books) {
                    if (book.getPublisher().contains(searchText)) {
                        newArraySize++;
                        break;
                    }
                }
        }
        return newArraySize;
    }

    // 다건조회
    public BookEntity[] searchBooks(int option, String searchText) {
        int newArraySize = getNewArraySize1(option, searchText);

        BookEntity[] searchBooks = new BookEntity[newArraySize];

        int i = 0;
        switch (option) {
            case 1:     //통합검색
                for (BookEntity book : books) {
                    if (book.getBookName().contains(searchText)
                            || book.getAuthor().contains(searchText)
                            || book.getPublisher().contains(searchText)) {
                        searchBooks[i] = book;
                        i++; // 일치할 때만 추가 하고 카운팅
                    }
                }
                break;
            case 2:     //도서명검색
                for (BookEntity book : books) {
                    if (book.getBookName().contains(searchText)) {
                        searchBooks[i] = book;
                        i++;
                    }
                }
                break;
            case 3:     //저자명검색
                for (BookEntity book : books) {
                    if (book.getAuthor().contains(searchText)) {
                        searchBooks[i] = book;
                        i++;
                    }
                }
                break;
            case 4:     //출판사검색
                for (BookEntity book : books) {
                    if (book.getPublisher().contains(searchText)) {
                        searchBooks[i] = book;
                        i++;
                    }
                }
        }
        return searchBooks;
    }

//    // 배열축소
//    private BookEntity[] contractBooks(int bookId) {
//        BookEntity[] newBooks = new BookEntity[books.length - 1];
//        int findIdx = -1;
//        for (int i = 0; i < books.length; i++) {
//            newBooks[i] = books[i];
//            findIdx = i;
//        }
//
//        return newBooks;

    private int indexOfBookId(int BookId) {
        int findIndex = -1;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getBookId() == bookId) {
                findIndex = i;
                break;
            }
        }
        return findIndex;
    }

    // 도서삭제
    public void deleteBookByBookId(int bookId) {
        BookEntity[] newBooks = new BookEntity[getLastIndex()];
        int findIndex = indexOfBookId(bookId);

        //배열축소
        for (int i = 0; i < newBooks.length; i++) {
            if (i < findIndex) {
                newBooks[i] = books[i];
                continue;
            }
            newBooks[i] = books[i + 1];
        }
        books = newBooks;
    }
}
