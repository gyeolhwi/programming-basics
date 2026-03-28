package com.study.java_study.ch09_클래스04;

//Data
public class BookEntity {

    private int bookId;
    private String bookName;
    private String author;
    private String publisher;

    // Entity? 정보의 집합체

    // 가지고있는 정보들을 출력할 수 있는 메소드
    @Override
    public String toString() {
        return "BookEntity{" + "bookId=" + bookId + ", 도서명='" + bookName + '\'' + ", 저자명='" + author + '\'' + ", 출판사명='" + publisher + '\'' + '}';
    }

    // NoArgsConstructor
    public BookEntity() {
    }

    // AllArgsConstructor
    public BookEntity(int bookId, String bookName, String author, String publisher) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
    }

    // getter & setter
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


}
