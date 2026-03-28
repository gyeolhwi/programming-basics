package j11_상속;

public class Animal {
	public Animal() { // 4번 진행human으로 돌아감
		System.out.println("Animal 기본생성자 호출");
		System.out.println();
	}
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
	
	public void eat() {
		System.out.println("밥을 먹습니다");
	}

}
