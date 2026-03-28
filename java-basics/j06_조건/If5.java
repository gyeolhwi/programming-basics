package j06_조건;

import java.util.Scanner;

public class If5 {
	public static void main(String[] args) {
		/*
		 * 3개 승강장 (ture = 올라감 , false = 내려감
		 * Bplatform1 = true
		 * platform1 = 5
		 * 1층 이동하는데 걸리는 시간 5초
		 * 
		 * 14층에서 올라갈 때 10층 내려올 때 13층 총 23층 
		 * platform1 , 2 3
		 * calc = 
		 */
		Scanner scanner = new Scanner(System.in);
		
		int platform1 = 1,platform2 = 1,platform3 = 1;
		Boolean Bplatform1 = false,Bplatform2 = false,Bplatform3 = false;
		String result = null;
		
		System.out.println(Bplatform1);
		
		System.out.print("1승강장의 상태를 입력: ");
		Bplatform1 = scanner.nextBoolean();
		System.out.print("1승강장의 층 수 입력 : ");
		platform1 = scanner.nextInt();
		
		System.out.println("2승강장의 상태를 입력: ");
		Bplatform2 = scanner.nextBoolean();
		System.out.println("2승강장의 층 수 입력 : ");
		platform2 = scanner.nextInt();
		
		System.out.println("3승강장의 상태를 입력: ");
		Bplatform3 = scanner.nextBoolean();
		System.out.println("3승강장의 층 수 입력 : ");
		platform3 = scanner.nextInt();
		
		if (Bplatform1 == false) {
			platform1 = (platform1) * 5;
		
		}else { platform1 = (27 - platform1) * 5;}
		
		
		if (Bplatform2 == false) {
			platform2 = (platform2) * 5;
			
		}else { platform2 = (27 - platform2) *5;}		
		
		if (Bplatform3 == false) {
			platform3 = (platform3) * 5;
			
		}else { platform3 = (27 - platform3) *5;}	
		
		System.out.println(platform1);
		System.out.println(platform2);
		System.out.println(platform3);
		
		if (platform1 < platform2 && platform1 < platform3) {
			result = "1승강장";
		}else if (platform2 < platform3 && platform2 < platform1) {
			result = "2승강장";
		}else {result = "3승강장";}
		
		System.out.println(result+"이용");
		
		// 선생님
		
		
	}
}














