package com.study.java_study.ch13_추상화04;

public class ClassAMain {
    public static void main(String[] args) {
        ClassA a1 = new ClassA1();
        ClassA a2 = new ClassA2();
        InterfaceA i1 = new InterfaceA1();
        InterfaceA i2 = new InterfaceA2();
        // 추상클래스에서 공통된 메소드를 선언하여 각각 다른 클래스에서 확장하여 사용

        a1.print(i1);
        System.out.println();
        a1.print(i2);
        System.out.println();

        a2.print(i1);
        System.out.println();
        a2.print(i2);
        System.out.println();

        // 매개변수로는 인터페이스 자체를 받고 생성을 할 때 아래에 있는 걸 받아서 다양하게 사용

        
    }
}
