package com.study.java_study.ch10_추상화01;

public class Animal {
    //공통사항들이 있는 곳
    private String name;
    private int age;
    // 여기서 없는 것들은 확장인 거임


    public Animal() {
        System.out.println("동물 객체 생성");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void move() {
        System.out.println("동물이 움직입니다");
    }
}
