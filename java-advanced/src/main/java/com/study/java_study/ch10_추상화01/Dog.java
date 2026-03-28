package com.study.java_study.ch10_추상화01;

public class Dog extends Animal{
    private String breed;

    public Dog() {
        super(); // extends 하면 생략 되어있음 Animal객체 생성자 호출
        System.out.println("강아지 객체 생성");
    }

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                '}';
    }
    @Override
    public void move() {
        System.out.println("강아지가 나를 핥습니다");
    }
    public  void bark() {
        System.out.println(breed + "종의 강아지가 짖습니다");
    }
}
