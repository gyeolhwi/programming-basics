package j05_입력;

import java.util.Scanner;

public class input1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		String str = scanner.next();
//		System.out.println("입력받은 값 "+ str);
		
		System.out.print("이름:");
		String name = scanner.next();
		
		System.out.print("거주하고 있는 구: ");
		String address = scanner.next();
		
		System.out.print("나이: ");
		int age = scanner.nextInt();
		
		System.out.println();
		System.out.println("이름: " + name);
		System.out.println("주소(구): " + address);
		System.out.println("나이: " + age);
	}
}