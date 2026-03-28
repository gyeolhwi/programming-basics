package j04_문자열;

public class String3 {
	public static void main(String[] args) {
		String address = "부산 서구 부민동";
		/*
		 * "부"의 위치 찾는방법을 활용하여
		 *  "부산 서구"를 출력하시오
		 */
		//1
		String result = address.substring(0, 6);
		System.out.println(result);
		
		//2
		int indexNum = address.indexOf("구")+1;
		String result2 = address.substring(0,indexNum);
		System.out.println(result2);
		
		// 선생님
		int index = address.indexOf("부");
		int lastIndex = address.lastIndexOf("부");
		String subAddress = address.substring(index,lastIndex - 1);
		System.out.println(subAddress);
		
		// replace 값 바꾸기
		String replaceAddress = address.replace(' ', '-');  // replace 문자를바
		System.out.println(replaceAddress);
		
		String replaceAllAddress = address.replaceAll("부민동","연산동"); // replaceAll 문자열을 바꿈
		System.out.println(replaceAllAddress);
	}
}
