package j03_연산자;

public class Operation5 {

	public static void main(String[] args) {
		/*
		 * 점수 score
		 * 결과 result
		 * 
		 * 점수가 89보다 크면 A학점
		 * 점수가 79보다 크면 B학점
		 * 점수가 69보다 크면 C학점
		 * 점수가 59보다 크면 D학점
		 * 나머지 F
		 * 
		 * 점수가 0보다 작거나 100보다 크면 계산불
		 */
		
		int score = 58;
		String result = null; // 통상적으로 초기값을 null로 잡아준다 "" 쌍따옴표 두개랑 차이는 없음
		result  =  score < 0 || score > 100 ? "계산불가"
						 : score > 89 ? "A"
						 : score > 79 ? "B"
						 : score > 69 ? "C"
						 : score > 59 ? "D"
						 : "F";
						 
			System.out.println(result);
	}
}
