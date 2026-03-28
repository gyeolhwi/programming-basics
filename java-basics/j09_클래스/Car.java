package j09_클래스;

import java.util.Scanner;


public class Car {
	
	static Scanner scanner = new Scanner(System.in);
	
// 변수
	String company = null;
	String model = null;
	String color = null;
	int colorchoice;
	int kmchoice = 0;
	int km= 0;
	
	public Car() {
		System.out.println("생성자호출");
		/*
		 * 기본생성자의 특징
		 * 1. 생성자는 무조건 클래스명과 동일하다
		 * 2. 생성자는 무조건 주소값을 리턴한다
		 * 3. 기본생성자는 생략이 가능하다
		 */
	}

	
	
// colorChange 메소드
	void colorChange(){
		System.out.println("변경 전 색상:"+color);
		System.out.print("1.레드 2. 블루 3. 그린\n변경할 색상:");
		colorchoice = scanner.nextInt();
		switch (colorchoice) {
		case 1: color = "레드";break;
		case 2: color = "블루";break;
		case 3: color = "그린";break;
//		default: System.out.println("네?");
		}
		System.out.println("변경 된 색상: "+color);
	}
		
//		kmCheck 메소드
	void kmcheck() {
		System.out.print("1.출 퇴근 2. 여행: ");
		kmchoice = scanner.nextInt();
		
		if(kmchoice == 1){
			km += 10;
			
		}else if(kmchoice ==2) {
			km += 100;
		}
	}
		
//	showInfo 메소드
	void showInfo() {
		System.out.println("회사:"+company);
		System.out.println("모델명:"+model);
		System.out.println("색상:"+color);
		System.out.println("주행거리:"+km);
	}
	
	
	
}
