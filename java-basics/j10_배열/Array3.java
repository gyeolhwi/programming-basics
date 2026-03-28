package j10_배열;

public class Array3 {
	public static void main(String[] args) {
		
	/*
	 * 실습
	 *  1~1000까지 배열 넣고 출력
	 */
		
		int[] numbers = new int[1000];
		for (int i = 0; i < numbers.length; i++) {
		numbers[i] = i+1;
		
		}
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
	}
}
