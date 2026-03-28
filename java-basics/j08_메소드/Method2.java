package j08_메소드;

public class Method2 {
	
	// 메소드의 종류
	
	// 반환이 없고, 매개변수도 없는 메소드
	public static void test1() { //	return값이 없을 땐 void 
		System.out.println("test1 메소드 호출");
	}
	// 반환이 없고 매개변수가 하나인 메소드
	public static void test2(int num) {
		System.out.println("test2 메소드 호출");
		System.out.println("num = " +num);
	}
	public static void test3(String name, int weight, int height) {
		System.out.println("test3 메소드 호출");
		System.out.println("name = " + name);
		System.out.println("weight X height = "+(weight * height));
	}
	// 반환이 있고, 매개변수가 하나인 메소드
	public static String test4(String name) {
		System.out.println("test4 메소드 호출");
		return name;
	}
	// 반환이 있고 매개변수가 없는 메소드
	public static int test5() {
		return 100;
	}
	
	public static void main(String[] args) {
		test1();
		test2(10);		// 인수를 넣지 않았을 때 기본값에 대해서
		test3("김결휘",65,173);
		System.out.println(test4("김결휘"));	// 이렇게 적어주어야 출력값("김결휘")이 나옴
		test4("gyeori");
		System.out.println(test4("gyoeri"));
		
		test5(); // 주의
		System.out.println(test5());
	}
}
