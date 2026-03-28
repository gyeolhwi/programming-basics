package com.study.java_study.ch18_빌더;


public class Student {
    private int studentCode;
    private String name;
    private int age;

    public Student(int studentCode, String name, int age) {
        this.studentCode = studentCode;
        this.name = name;
        this.age = age;
    }

    /*
            전체생성자
            빌더메서드에서 생성자 리턴
            빌더 내부클래스 생성
            빌더라는 데이터집합 안에
            각 데이터들 return -> getter 형식?
            마지막 build 에 생성자
    */
    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    public static class StudentBuilder {
        private int studentCode;
        private String name;
        private int age;

        public StudentBuilder studentCode(int studentCode) {
            this.studentCode = studentCode;
            return this;
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Student build() {
            return new Student(studentCode, name, age);
        }

    }
}