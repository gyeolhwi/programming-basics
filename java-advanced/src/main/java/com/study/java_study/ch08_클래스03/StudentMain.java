package com.study.java_study.ch08_클래스03;

import java.util.Arrays;

public class StudentMain {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        String[] str = new String[5];

//        for (int i = 0; i < students.length; i++) {
//            students[i] = new Student();
//        }

        Student[] students = new Student[5]; // null을 가지고있음 각 배열에 새로운 주소지를 각각 할당

        students[0] = new Student(20240501, "김준일", 31);

        students[1] = new Student(20240502, "김준이", 32);
        students[4] = new Student(20240503, "김준삼", 33);
        System.out.println(students[0].getName());

        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                continue;
            }
            System.out.println("학번: " +students[i].getCode());
            System.out.println("이름: " +students[i].getName());
            System.out.println("나이: " +students[i].getAge());
        }
    }
}