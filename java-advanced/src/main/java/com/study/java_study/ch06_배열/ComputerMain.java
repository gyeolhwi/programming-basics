package com.study.java_study.ch06_배열;

public class ComputerMain {
    public static void main(String[] args) {
        Computer[] computers = new Computer[3];
        computers[0] = new Computer("i3", "8GB");
        computers[1] = new Computer("i5", "16GB");
        computers[2] = new Computer("i7", "32GB");

        for (Computer computer : computers) {
            System.out.println(computer.toString());
        }
        
    }
}
