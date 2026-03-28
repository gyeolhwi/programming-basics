package com.study.java_study.ch15_Static;

/*
    싱글톤 디자인 패턴
    1. 객체를 유일하게 하나만 생성하여 사용하는 기법
    2. 생성자가 private으로 외부에서는 생성할 수 없다.
    3.
 */

public class StudentMain {
    public static void main(String[] args) {

    StudentService studentService = StudentService.getInstance(); // 같은
    StudentService studentService2 = StudentService.getInstance(); // 주소
    StudentRepository studentRepository = StudentRepository.getInstance(); // 다른 주소

    studentService.addStudent();
    StudentRepository.getInstance().add("김준이");
    studentService2.addStudent();



    }
}
