package com.study.java_study.ch06_배열;

public class BookArrayUtils {
    int findIndexByName(String[] arrays, String name){
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

}
