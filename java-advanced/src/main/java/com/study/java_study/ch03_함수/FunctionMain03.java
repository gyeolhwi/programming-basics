package com.study.java_study.ch03_함수;

public class FunctionMain03 {
    public static void main(String[] args) {
        Function03 fnc = new Function03();
        fnc.fx01(1234,"겨리",26,"01068185091");
        Student std = new Student();

        std.name = "결";
        std.age = 26;
        std.phone = "010303030";
        std.studentCode = 11;

        fnc.fx02(std);
    }
}