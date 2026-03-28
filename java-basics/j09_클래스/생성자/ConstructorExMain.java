
package j09_클래스.생성자;

public class ConstructorExMain {
	public static void main(String[] args) {
		
		ConstructorEx1 constructorEx1 = new ConstructorEx1(); //기본생성자
		ConstructorEx1 constructorEx12 = new ConstructorEx1("홍길동"); // 인수를 받는 매개변수
		
		System.out.println();
		System.out.println(constructorEx12.name);
		
	}
}
