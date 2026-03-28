package com.study.java_study.ch06_배열;

public class ArrayUtils {
    
    // 수정이던 삭제던 전부 원래있던 이름을 찾아야하므로 해당 함수를 만듬
    int findIndexByName(String[] names, String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
