package j09_클래스;

public class teacherCarmain {

	public static void main(String[] args) {
		
		teacherCar car1 = new teacherCar();
		teacherCar car2 = new teacherCar();
		
		car1.company = "현대자동차";
		car1.model = "소나타";
		car1.color = "화이트";
		car1.km = 30000;
		
		car2.company ="기아";
		car2.model = "K5";
		car2.color = "블랙";
		car2.km = 100000;
		
		car1.colorChange(3);
		car1.kmCheck("여행");
		car1.kmCheck("여행");
		
		car1.showInfo();
		System.out.println();
		car2.showInfo();
	}
}
