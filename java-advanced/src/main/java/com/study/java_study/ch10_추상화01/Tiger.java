package com.study.java_study.ch10_추상화01;

public class Tiger extends  Animal{
    private String power;

    public Tiger() {
        super(); // 생략 되어있음 Animal객체 생성자 호출
        System.out.println("호랑이 객체 생성");
    }
    public Tiger(String name, int age, String power) {
        super(name, age);
        this.power = power;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "power='" + power + '\'' +
                "} " + super.toString();
    }
    
    @Override // 재정의
    public void move() {
        System.out.println("호랑이가 네발로 뛰어갑니다.");
    }
    public void hunt() {
        System.out.println("호랑이가 " + power + "의 힘으로 사냥을 합니다.");
    }
}
