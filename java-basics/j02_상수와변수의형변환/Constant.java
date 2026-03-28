package j02_상수와변수의형변환;

public class Constant {

	public static void main(String[] args) {
		
		final int MAX_NUMBER = 100;
		final int MIN_NUMBER= 0;
		/*
		 * 상수 : 변하지 않는 수
		 * 변수명 표기방식 → 전체대문자 and 스네이크표기법
		 * 상수는 무조건 선언과 초기화를 같이 해주어야함
		 */
		int number = 80;
		number = 50;
				
		System.out.println("최댓값: "+ MAX_NUMBER);
		System.out.println("최솟값: "+ MIN_NUMBER);
		System.out.println("현재값: "+ number);
	}
}
