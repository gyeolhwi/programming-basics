package com.study.java_study.ch18_빌더;

public class Main {
    public static void main(String[] args) {
        // 내부클래스
        A a = new A();
        A.B b = a.new B();
        a.test();
        b.print();

        // static는 생성하지않고 사용할 수 있다. type만 A인거임
        A.C c = new A.C();
        // show 메서드는 static가 아니기 때문에 c라는 주소참조를 통해서 사용해야함
        c.show();
        // show2 메서드는 static이기 때문에 내부클래스 참조를 통해서 바로 사용가능하다.
        A.C.show2();
    }
}
