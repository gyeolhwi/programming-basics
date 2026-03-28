package j09_클래스.접근지정자.a;

public class TestA_2 {
	int ta2;
	
	public void testA2() {
		System.out.println("TestA-2메소드 호출");
		TestA1 testA = new TestA1();
		
		testA.ta1 = "테스트 A-2에서 값 주입";
		testA.Test1A1(); //같은 패키지에 있어서 접근이 가능함
		
		System.out.println(testA.ta1);
	}
}
