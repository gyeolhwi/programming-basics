package j06_조건;

import java.util.Scanner;

public class If1 {

	public static void main(String[] args) {
		
		/*
		 *  엘리베이터 승강장 고르기
		 *  max = 14
		 */
		Scanner scanner = new Scanner(System.in);
		
		int platform1 = 0;
		int platform2 = 0;
		
		System.out.println("1승강장 층 수: ");
		platform1 = scanner.nextInt();
		System.out.println("2승강장 층 수: ");
		platform2 = scanner.nextInt();
	
//		if (platform1 < platform2) {
//			System.out.println("1승강장을 이용하시오");
//		}
//		if(platform1 > platform2) {
//			System.out.println("2승강장을 이용하시오");
//		}
		if(platform1 < platform2) {
			System.out.println("1승강장을 이용하시오");
		}else {
			System.out.println("2승강장을 이용하시오");
		}
		// 자동정렬 : ⌘ ⇧ f
		/*
		 * if문의 기본구조
		 * if(조건문){
		 * 				<수행할 문장1>;
		 * 				<수행할 문장2>;
		 * 				<수행할 문장3>;
		 * 		 			  •
		 * 		 			  •
		 * 		 			  •
		 * }else{
		 * 				<수행할 문장a>;
		 * 				<수행할 문장b>;
		 * 				<수행할 문장c>;
		 * }
		 */
	}

}