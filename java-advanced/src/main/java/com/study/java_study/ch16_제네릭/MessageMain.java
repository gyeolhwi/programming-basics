package com.study.java_study.ch16_제네릭;

public class MessageMain {
    // 제네릭 와일드카드: 기호 -> ?
    public static void main(String[] args) {
        Message<?> m1;
        Message<String> m2 = null;

        m1 = new Message<>("10");
        String s = (String) m1.getMessage();

        // 와일드 카드 제약
//        Message<? extends  String> m3; // 해당 클래스 본인과 상속받은 것들만 사용가능
        Message<? extends String> m3 = new Message<>("10"); // 하행
        Message<? super String> m4 = new Message<>(new Object()); // 본인과 본인의 상위 클래스는 전부 사용 가능 상행

        String s2 = m3.getMessage();
    }
}
