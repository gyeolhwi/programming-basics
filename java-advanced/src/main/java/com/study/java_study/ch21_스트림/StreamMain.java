package com.study.java_study.ch21_스트림;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        /*
             생성(사용) 절차
             1. 배열 생성 -> 스트림으로 변환
             2. List 생성 -> 스트림으로 변환
             3. generate 메소드 -> 스트림 생성
             4. 범위 지정 -> 스트림 생성
             5. 빌더 -> 스트림생성

             중간(가공) 절차
             1. map(Function 인터페이스)
             2. filter(Predicate)
             3. sorted(Comparator)

             최종(결과) 절차
             다시 list로 바꿔서 보여주기
             1. collect -> stream을 list 변환
             2. 반복자 -> forEach
        */
        Stream<Integer> st1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(st1);
        // 중간 결과확인
        List<Integer> numberList = st1.map(n -> n * 2) // 동작
//                .peek(n -> System.out.println(n))
                .collect(Collectors.toList()); // 리스트로 만들어 줌
//                .forEach(n -> System.out.println(n));

        numberList.forEach(n -> System.out.println("n: " + n));

        List<Integer> filteringNumbersList = numberList.stream()
                .map(n -> n / 2)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(filteringNumbersList);

        List<Integer> sortedNumberList = numberList.stream()
                .sorted((o1, o2) -> o2 - o1)
                .collect(Collectors.toList());
        System.out.println(sortedNumberList);

        Stream<String> nameStream = Stream.<String>builder()
                .add("다")
                .add("가")
                .add("라")
                .add("나")
                .add("바")
                .add("마")
                .build();
//        nameStream.sorted().forEach(name -> System.out.println(name));
//        nameStream.sorted((o1,o2) -> Objects.hash(o2) - Objects.hash(o1)).forEach(name -> System.out.println(name));
        nameStream.sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o2, o1))
                .forEach(name -> System.out.println(name));
        List<Phone> phoneList = List.of(
                Phone.builder().number(1).model("아이폰").build(),
                Phone.builder().number(2).model("갤럭시").build(),
                Phone.builder().number(3).model("샤오미").build()
        );
        phoneList.stream().map(phone -> {
            phone.setNumber(phone.getNumber() * 2);
            return phone;
        });
        // 값 수정
        phoneList.stream()
                .map(phone -> Phone.builder()
                        .number(phone.getNumber() * 2)
                        .model(phone.getModel())
                        .build())
                .forEach(phone -> System.out.println(phone));

        // 필터에 걸리는것만 출력
        phoneList.stream()
                .filter(phone -> phone.getNumber() % 2 != 0)
                .forEach(phone -> System.out.println(phone));
        //역정렬
        phoneList.stream().sorted((o1, o2) -> o2.getNumber() - o1.getNumber()).forEach(phone -> System.out.println(phone));
        // ㄱㄴㄷ 정렬
        phoneList.stream().sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getModel(), o2.getModel()))
                .forEach(phone -> System.out.println(phone));

        phoneList.stream().sorted((o1, o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getModel(), o2.getModel()))
                .forEach(System.out :: println);
    }
}

