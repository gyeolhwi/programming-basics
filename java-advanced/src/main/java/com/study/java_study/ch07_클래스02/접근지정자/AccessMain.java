package com.study.java_study.ch07_클래스02.접근지정자;

import com.study.java_study.ch07_클래스02.StudyB;

public class AccessMain {
    private String test;

    public void printTest() {
    }

    public static void main(String[] args) {
        StudyB b = new StudyB("결",26);
        b.show();
        b.setName("김준이");
        System.out.println(b.getName());

    }
}
