package j01_출력;

import java.util.HashMap;
import java.util.Map;

public class PrintTest {

	public static void main(String[] args) {
		System.out.print("Hello, java\n");
		System.out.println();
		System.out.print("hong gil dong");
		System.out.println("address : Busan");
		
		// print 는 줄바꿈 X , println은 줄바꿈 O
		/*
		 * 장문주석처
		 * 변수명은 세세하게 적어준다
		 * 변수명 특수문자 & _
 
		 * 가독성을 위하여 카멜표기법애용하기 or 스네이크표기법
		 */
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("index", "12");
		map.put("count", 4);
		System.out.println(map.get("index"));
		System.out.println(map.get("count"));
		
	}

}

