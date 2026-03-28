package j06_조건;

import java.util.Scanner;

public class If4 {
	public static void main(String[] args) {
		/*
		 * 승강장 3개 
		 * platform 1, 2, 3
		 * 
		 * 세개의 승강장 층수를 입력으로 받고 제일 낮은 위치의 승강장 탑승
		 */
		Scanner scanner = new Scanner(System.in);
		int platform1 = 0 ,platform2 = 0,platform3 = 0;
		String result = null;
		String result2 = null;
		
		System.out.print("platform1: ");
		platform1 = scanner.nextInt();
		System.out.print("platform2: ");
		platform2 = scanner.nextInt();
		System.out.print("platform3: ");
		platform3 = scanner.nextInt();
		
		int min = platform1;
		if (min > platform2) {
			min = platform2;
			result = "platform2";
		}
		if (min > platform3) {
			min = platform3;
			result = "platform3";
		}
		
		System.out.println(result+"승강장 이용");
		
		
		// 선생님
		if (platform1 < platform2 && platform1 < platform3) {
			result2 = "1승강장";
		}else if (platform2 < platform3 && platform2 < platform1) {
			result2 = "2승강장";
		}else {result2 = "3승강장";}
		System.out.println(result2);
	}
}
