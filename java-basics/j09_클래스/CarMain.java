
package j09_클래스;
public class CarMain {
	public static void main(String[] args) {
		/*
		 * 실습
		 * Car 클래스 생성
		 * 변수 : company,model,color,km
		 * 
		 * 메소드 : showInfo - 변수 값들은 전부 출력하는 메소드
		 * 			colorChange - 1. 레드 2. 블루 3. 그린
		 * 			kmCheck - 출퇴근 → 10 여행 → 100
		 * 
		 *  차 2대 만들기
		 *  현대자동차 , 쏘나타 , 화이트 , 30000
		 *  기아 , K5 , 블랙, 100000
		 * 
		 */
//		자료형 이름 = 주소
		Car car1 = new Car(); // 뭘 호출 했을까? 
		Car car2 = new Car();
		
		car1.company = "현대자동차";
		car1.model = "쏘나타";
		car1.color = "화이트";
		car1.km = 30000;
		
		
		car2.company = "기아";
		car2.model = "K5";
		car2.color = "블랙";
		car2.km = 100000;
		for(int i = 0; i < 5; i++) {
		car1.showInfo();
		System.out.println();
		car2.showInfo();
		car2.colorChange();
		System.out.println();
		car2.kmcheck();
		car2.showInfo();
		}
		
	}
}