package j11_상속;

public class Human extends Animal{
	
	public Human() { // 2번 진행
		super(); // 없어도 부모클래스 생성자가 있다고 봐야함 (부모클래스로이동) 3번
		System.out.println("human 기본생성자 호출");
		System.out.println();
	}
	private int jjk;
	
	public void study () {
		System.out.println("인간이 공부를 합니다.");
	}
	// 오버라이딩 : 재정의
	@Override
	public void eat() {
		System.out.println("human에 있는 eat");
		System.out.println("춤을 춥니다");
//		super.eat(); 
	}
	
	
	public Human(int jjk) {
		super();
		this.jjk = jjk;
	}
	
	
	
}
