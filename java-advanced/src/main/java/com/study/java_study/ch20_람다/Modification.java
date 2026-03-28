package com.study.java_study.ch20_람다;

/*
    람다 Lambda
    1. 하나의 추상 메소드를 정의 하고 있는 인터페이스에서 사용한다.
    2. 매개변수 타입 생략가능
    3. 매개변수가 하나이면 매개변수를 감싸는 ()괄호 생략가능
    4. 다른 명령 없이 바로 리턴할 경우 {} 중괄호, return 생략 가능
*/
@FunctionalInterface
public interface Modification<T> {
    T modify(T oldData, T newData);
//    T modify2(T oldData, T newData);

}
