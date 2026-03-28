package com.study.java_study.ch06_배열;

import java.util.Scanner;

public class ArrayService {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] names = new String[0]; // 공간 0

        ArrayUtils utils = new ArrayUtils();

        boolean isRun = true;

        while (isRun) {

            System.out.println("[이름 관리 프로그램]");
            System.out.println("1. 등록");
            System.out.println("2. 수정");
            System.out.println("3. 삭제");
            System.out.println("4. 이름찾기");
            System.out.println("5. 전체조회");
            System.out.println("q. 나가기");
            System.out.print("메뉴 선택: ");
            String selectedMenu = scanner.nextLine();

            // 케이스 1에서도 사용하고 3에서도 사용하기 위해서 스위치문 바깥으로 빼냄
            int findIndex = -1;

            String[] newNames = new String[names.length + 1]; // 1
            switch (selectedMenu) {
                case "1":
                    System.out.println("[이름등록]");
                    for (int i = 0; i < names.length; i++) {
                        newNames[i] = names[i];
                    }
                    names = newNames; // 공간이..추가된건가요?
                    newNames = null;

                    System.out.print("등록 할 이름 : ");
                    names[names.length - 1] = scanner.nextLine();
                    break;
                case "2":
                    // 중복값이 있다면 앞에 있는 거 지우거나 수정
                    System.out.println("[수정]");
                    System.out.print("이름을 입력하세요 : ");
                    String oringName = scanner.nextLine();
                    System.out.print("수정할 이름을 입력하세요 : ");
                    String modifyedName = scanner.nextLine();
                    //메소드 사용
                    findIndex = utils.findIndexByName(names, modifyedName);
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].equals(oringName)) {
                            names[i] = modifyedName;
                            System.out.println("수정이 완료되었습니다");
                            break;
                        }
                    }
                    /*
                    // 강사님 답
                    if(findIndex == -1){
                        System.out.println("해당이름은 존재하지않습니다");
                        break;
                    }

                    for (int i = 0; i < names.length; i++) {
                        String name = names[i];
                        if(name.equals(modifyedName)){
                            System.out.print("새 이름:");
                            names[findIndex] = scanner.nextLine();
                            System.out.println("이름이 수정되었음");
                            break;
                        }
                    }
                    함수 이용
                    for(int i = 0; i< names.length; i++){

                     */
                    System.out.println("잘못된 접근입니다");
                    System.out.println();
                    break;

                case "3":
                    // 중복값이 있다면 앞에 있는 거 지우거나 수정
                    System.out.println("[삭제]");
                    System.out.print("삭제할 이름 입력: ");
                    String removename = scanner.nextLine();
                    String[] afterIdx = new String[names.length - 1];
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].equals(removename)) {
                            findIndex = i;
                            break;
                        }
                        afterIdx[i] = names[i];
                    }
                    // 찾지 못했을 때 오류처리
                    if (findIndex == -1) {
                        System.out.println("해당 이름은 존재하지 않습니다");
                        afterIdx = null;
                        break;
                    }
                    for (int i = findIndex; i < afterIdx.length; i++) {
                        afterIdx[i] = names[i + 1];
                    }
                    names = afterIdx;
                    // 강사님 풀이
                    /* ------------------------------------------------
                    newNames = new String[names.length - 1];
                    for (int i = 0; i < newNames.length; i++) {
                        if(i < findIndex){
                            newNames[i] = names[i];
                            continue;
                        }
                        newNames[i] = names[i + 1];
                    }
                    ----------------------------------------------------*/



                    /* 오답
                    String[] afterIdx = new String[names.length - 1];
                    int idx = 0;
                    for (int i = 0; i < names.length; i++) {
                        if(names[i].equals(removename)){
                            idx = i;
                            break;
                        }
                    }
                    for(int i = idx; i < afterIdx.length; i++){
                        afterIdx[i] = names[i];
                    }
                            // 삭제할 이름 받기
                     int removeIndex;
                    // 삭제할 인덱스
                    String[] strArr = new String[names.length - 1];
                    // 공간하나 줄어든 배열
                    int cnt = 0;
                    // 카운트
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].equals(removename)) {
                            // 삭제하고자 하는 이름을 찾으면
                            removeIndex = i;
                            // 해당 인덱스 추출
                            names[removeIndex] = "";
                            // 해당 인덱스 빈값 만들기
                            // 건너뛰기
                        }
                        strArr[cnt] = names[i];
                        cnt++;
                    }
                    names = strArr; */

                    System.out.println(removename + "삭제완료");
                    break;
                case "4":
                    System.out.println("[이름찾기]");
                    System.out.print("조회 할 이름 : ");
                    String findName = scanner.nextLine();
                    findIndex = utils.findIndexByName(names, findName);
                    if (findIndex == -1) {
                        System.out.println("해당 이름은 존재하지 않습니다");
                        break;
                    }

                    System.out.println();
                    break;
                case "5":
                    System.out.println("[전체조회]");
                    for (int i = 0; i < names.length; i++) {
                        System.out.println("index[" + i + "] : " + names[i]);
                    }
                    break;
                case "q":
                    System.out.println("q. 나가기");
                    break;
                default:
                    System.out.println("다시 입력하세요");
            }
        }


    }
}
