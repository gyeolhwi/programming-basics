package com.study.java_study.ch17_컬렉션;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookService {
    // 싱글톤 사용
    private static BookService instance;

    private BookService() {}

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    // 리스트 안에서 맵을 구성
    private List<Map<String, Object>> bookDB = List.of(
            Map.of(
                    "bookId", 1,
                    "bookName", "자바의 정석"
            ),
            Map.of(
                    "bookId", 2,
                    "bookName", "파이썬의 정석"
            ),
            Map.of(
                    "bookId", 3,
                    "bookName", "데이터베이스의 정석"
            )
    );
    // -------------------------------------------------


    public void run1() {
        System.out.println("도서 전체 정보를 요청합니다");
        run2();
    }

    public void run2() {
        System.out.println("도서 전체 정보 요청을 받았습니다");
        List<BookEntity> bookEntities = run3(); //1
        BookRequestDto bookRequestDto = new BookRequestDto(200, "조회 완료", bookEntities);
        run4(bookRequestDto);
    }



    public List<BookEntity> run3() {
        System.out.println("데이터베이스에서 도서 전체 정보를 조회합니다");
        // 보여주기 위해서 만들어놓은 거 Get 구성원
        List<BookEntity> bookEntities = new ArrayList<>();

        // bookDB에 있는 각 value들을 Entity로 보내주는 거
        for (Map<String, Object> bookMap : bookDB) {
            BookEntity bookEntity = new BookEntity(
                    (int) bookMap.get("bookId"),
                    (String)bookMap.get("bookName")
            );
            bookEntities.add(bookEntity); // 값만 들어감
        }
        return bookEntities;
    }

    public void run4(BookRequestDto dto) {
        System.out.println("데이터베이스의 정보를 요청한 클라이언트에게 응답합니다");
        System.out.println("[ 응답 데이터 ]");
        System.out.println(dto);
    }

    public void callprint() {

        System.out.println(bookDB.get(0).keySet());
        System.out.println(bookDB.get(0).values());
    }

}
