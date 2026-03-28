package j10_배열;

public class Array4 {
	public static void main(String[] args) {
		/*
		 * 실습
		 * names,studentYears,scores
		 * 홍길동 3 75.9
		 * 오재근 3 80.5
		 * 강유성 2 88.7
		 * 김지후 1 69.4
		 * 김결휘 2 78.5
		 * 
		 * 출력 >>>
		 * 홍길동 3학년 75.9점
		 * ...
		 * 
		 */
		String[] names = {"홍길동","오재근","강유성","김지후","김결휘"};
		int[] studentYears = {3,3,2,1,2};
		double[] scores = {75.9, 80.5 , 88.7 ,69.4 , 78.5};  // float랑 뭐가 다른거죠??
		
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]+" "+studentYears[i]+"학년 "+scores[i]+"점");
		}
		
		
		
		
	}
}
