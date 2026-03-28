package com.study.java_study.ch19_익명클래스;

public class ButtonMain {
    public static void main(String[] args) {
        Button button = new HomeButton();
        button.onClick();

        Button loginButton = new Button() {
            @Override
            public void onClick() {
                System.out.println("로그인 하기");
            }
        };

        click(new HomeButton());
        click(loginButton);
        click(new Button() {
            @Override
            public void onClick() {
                System.out.println("또 만들어진 버튼");

            }
        });
    }

    public static void click(Button button) {
        System.out.println(button.getClass());
        button.onClick();
    }
}