package j04_문자열;

public class String2 {

	public static void main(String[] args) {
		String address = "부산 금정구 부곡동";
		int index = address.indexOf("부");
		
		System.out.println(index);
		
		int index2 = address.lastIndexOf("부");
		System.out.println(index2);
		
		String subAddress = address.substring(0,3);
		System.out.println(subAddress);
		
		String subAddress2 = address.substring(3,5);
		System.out.println(subAddress2);
		
	}
}
