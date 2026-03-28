package j07_반복;

public class For4 {
	public static void main(String[] args) {
		/*
		 * 강덕현, 강민석, 김결휘, 김지후, 손수빈, 이준우
		 * 
		 * 강덕현
		 * 강민석
		 * .
		 * .
		 * .
		 * 이준우
		 */
		String name = ("강덕현, 강민석, 김결휘, 김지후, 손수빈, 이준우, 백승원");  
		for ( int i = 0 ; i < 6; i++) {
//			System.out.println(name.substring()
					
		
		}
		// 선생님
		int index = name.length() /5 + 1;
		System.out.println(index);
		
		
		for ( int i = 0; i < index; i++) {
			System.out.println(name.substring(i * 5,(i * 5) +3 ));
		}
	}
}
