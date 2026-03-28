package j04_문자열;

public class String1 {

	public static void main(String[] args) {
		// 쌍따옴표 출력 하고싶을 땐 \" name\" 형식
		
		String address = "부산 진구 가야동";
		
		// indexOf 문자열 인덱싱 출력
		int index = address.indexOf("산"); // >>> 1 
		System.out.println(index);
		
		int index2 = address.indexOf("구");	// >>> 4
		System.out.println(index2);
	}
}
