package j07_반복;

import java.util.Scanner;

public class DoubleWhile2 {
	public static void main(String[] args) {
		/*
		 *	수업 시작 시간 : 7
		 * 7시
		 * 			1분 
		 * 			2분 
		 * 			3분 
		 * 			• 
		 * 			• 
		 * 			• 
		 * 			50분
		 * 			쉬는시간
		 * 			1분
		 * 			2분
		 * 			• 
		 * 			•
		 * 			10분
		 * 8시
		 * 			1분
		 * 			•
		 * 			•
		 * 			50분
		 * 			쉬는시간
		 * 			•••
		 * 			10분 
		 * 9시
		 * 
		 * 			•••
		 * 
		 * 수업 끝 !

		 */
//		int i = 7 ,j = 0, k = 0;
//		System.out.println("수업시작시간: 7");
//		while( i < 9) {
//			System.out.println(i+"시");
//			i++;
//			j = 0;
//			while(j < 50) {
//				System.out.println("\t"+j+"분");
//				j++;
//				k=0;
//				while(k<10) {
//					System.out.println(k+"분");
//					
//				} k = 0;
//				
//			}
//		} System.out.println("쉬는시간");j = 0;
		
		//선생님
		Scanner scanner = new Scanner(System.in);
		int time = 0;
		System.out.print("수업 시작 시간:");
		time = scanner.nextInt();
		
		int i = 0;			//	반복문 선언
		while ( i < 3) {
			System.out.println((time + i ) + "시");	
			
			int j = 0;		// 반복문 안에 j의 반복문 선언
			while ( j < 60) {
				int num = j + 1;	// j가 1부터 시작되게 해주는 것
				if( j < 50) {		// j가 50이 될 때 까지 반복
					System.out.println("\t" + num + "분");
				}else {				//
					if(j == 50) {	// j 가 50이 되면 출력
						System.out.println("\t10분 쉬는 시간");
					}				// num 재활용
					System.out.println("\t" + (num-50)+ "분");
				}
				j++;
			}
			i++;
		}
	}
}
