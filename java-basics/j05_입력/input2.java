package j05_입력;

import java.util.Scanner;

public class input2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("현재 주소를 입력하시오:");
		String address = scanner.nextLine();	// 띄어쓰기 인식
		
		
		System.out.println("주소" + address);
	}
}
