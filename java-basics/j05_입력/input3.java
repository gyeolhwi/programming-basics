package j05_입력;

import java.util.Scanner;

public class input3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		/*
		 * 이름,층수(단독주택은 1로표기),거주지,연락처 = 홍길동,부산 진구 부전동,14,010-1234-5678
		 *	변수명 : name,floor,address,phone
		 * >>>
		 * 이름은 홍길동 이고 거주지는 부산 진구 부전동 입니다.
		 * 층수는 14층입니다.
		 * 연락처는 010-1234-5678 입니다.
		 */
		String name = null,address = null,phone = null; 
		int floor = 0;
		
		System.out.print("이름: ");
		name = scanner.next();
		System.out.print("층수: ");
		floor = scanner.nextInt();
		
		System.out.print("거주지: ");scanner.nextLine();
		address = scanner.nextLine();
		System.out.print("연락처: ");
		phone = scanner.nextLine();
		
		System.out.println("이름은"+name+" 이고 거주지는 "+address+" 입니다.\n층수는 "+floor+"입니다.\n연락처는 "+phone+" 입니다.");
	}
}
