package j11_상속;

public class AnimalMain {

	public static void main(String[] args) {
		// 부모생성자 먼저 호출 됨 ( extends 신경 쓸 것 )
		
		Animal animal = new Animal();	// animal 기본생성자 
		
		Human human = new Human();		// human 기본생성자
		
		
		Tiger tiger = new Tiger();		// tiger 기본생성자
		
		//상속
		animal.move();					// animal 에 있는 move  상속아님				
		System.out.println();
		human.move(); 					// animal 에 있는 상속
		System.out.println();
		tiger.move();					// 마찬가지
		
		//상속된 거 아니고 그냥 메서드 호출
		human.study();
		//재정의 하면 상속먼저가 아닌 자식 먼저 호출됨..?
		
		human.eat();				// 춤을춥니다
		

		Animal animal2 = new Human();		// 업 캐스팅 ??  
		System.out.println(animal2);
		System.out.println(" up casting");
		animal2.move();
		animal2.eat();
		
		((Human)animal2).study();
		System.out.println();
		((Human)animal2).eat();
		
//		((Tiger)animal2)animal.attack();
//		((Human)animal).study();
		
	}
}
