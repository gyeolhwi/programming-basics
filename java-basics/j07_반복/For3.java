package j07_반복;

public class For3 {
	public static void main(String[] args) {
		/*
		 *  String str = abcdefghijk
		 *  a
		 *  b
		 *  c
		 *  d
		 *  ~
		 */
		String a = null;
		for (int i = 0; i < 11; i++) {
//			System.out.println((str)i+64);
		}
		// 선생님 subString 활용
		
		String str = "abcdefghijkabadsfasfdc";
		
		System.out.println(str.length()); // 센스있는 식 
		
		for(int i = 0; i < str.length(); i++) {
			System.out.println(str.substring(i,i+1));
		}
		// 결합도는 낮추고 응집도는 높인다
		
	}

}
