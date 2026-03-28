package com.study.java_study.ch16_제네릭;

public class SenderMain {
    public static void main(String[] args) {
        //   [ Wrapper 자료형 ]
        // Integer          int
        // Boolean -언박싱-> boolean
        // Charcter <-박싱- char
        // Double           double
        // Long             long
        // Float            float

        Integer num = new Integer(10); // 박싱
        int num2 = num.intValue();  // 언박싱
        int numn = (int) num;

        Integer num3 = 20; // 자동 박싱
        int num4 = num3;  // 자동 언박싱

        Sender sender1 = new Sender<>("hi", 1, 3.14);


    }
}
