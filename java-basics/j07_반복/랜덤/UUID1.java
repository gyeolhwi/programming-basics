package j07_반복.랜덤;

import java.util.Scanner;
import java.util.UUID;

public class UUID1 {
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid); // 같은 성질이라도 다른 고유명으로 만들 수 있는거
		
		Scanner scanner = new Scanner(System.in);
		
		String name = null;
		String name2= null;
		String name3 = null;
		
		name = scanner.nextLine();
		name2 = scanner.nextLine();
		name3= scanner.nextLine();
		
		System.out.println(name + "-" + UUID.randomUUID().toString());
		System.out.println(name2 + "-" + UUID.randomUUID().toString());
		System.out.println(name3 + "-" + UUID.randomUUID().toString());
	}
}