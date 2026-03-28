package j09_클래스;

public class teacherCar {
	String company;
	String model;
	String color;
	int km;
	
	void showInfo() {
		System.out.println("제조사:"+company);
		System.out.println("모델:"+model);
		System.out.println("색상:"+color);
		System.out.println("주행거리':"+km);
	}
	void colorChange(int num) {
		color = num == 1 ? "레드"
		:num == 2 ?  "블루"
		:num == 3 ?  "그린"
		: color;}
	
	void kmCheck(String str) {
		if(str.equals("출퇴근")) {
			km += 10;
		}else if (str.equals("여행")) {
			km += 100;
		}else {System.out.println("입력이 올바르지 않습니다");
		}
	}
		
		
}
