package j07_반복;

import java.util.Scanner;

public class While3 {
	public static void main(String[] args) {
		/*
		 * 엘리베이터
		 * 
		 * 확인한 층 수: 12
		 * 12
		 * 13
		 * 14
		 * 도착했습니다.
		 *  
		 */
		Scanner scanner = new Scanner(System.in);
		
		int floor;
		System.out.print("확인한 층 수 :");
		floor = scanner.nextInt();
		while ( floor < 15) {
			System.out.println(floor+"층");
			floor++;
		}
		System.out.println("도착했습니다.");
		int floor2;
		System.out.print("확인한 층 수 :");
		floor2 = scanner.nextInt();
		while ( floor2 > 0) {
			System.out.println(floor2+"층");
			floor2--;
	}
		System.out.println("도착했습니다.");
		floor2 = 14;
		//선생님
		int t = 0;
		while(t < floor2) {
			System.out.println(floor2 - t);
			t++;
		}
	}
}
