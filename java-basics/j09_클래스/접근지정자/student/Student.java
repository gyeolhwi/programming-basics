package j09_클래스.접근지정자.student;

public class Student {
	
	private String name;
	private int studentyear;
	private int age;
	private String address;
	private String phone;
	// pravate 접근지정자 선언으로 다른 곳에서 사용불가
	
	// public 접근지정자 사용으로 , 이 메서드만 다른곳에서 호출 및 초기화 가능
	public Student(String name, int studentyear, int age, String address, String phone) {
//		super();
		this.name = name;
		this.studentyear = studentyear;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}
	
	public Student() {} // 기본생성자 명시
	
// 	public 접근지정자 사용으로 출력가능하나 하나씩은 불가함 무조건 뭉텅이로만 출력 가능
	public void showInfo() {
		System.out.println(name);
		System.out.println(studentyear);
		System.out.println(age);
		System.out.println(address);
		System.out.println(phone);
	}
	
//	해당 메서드를 사용으로 name만 출력가능하게 만듬 age 를 출력하고싶다면? 메서드를 하나 더 만들면 됨 아래에서 계속
	public String getName() {
		return name;
	}
	
	public int getAge() { // age까지 따로 출력가능
		return age;
	}

	public int getStudentyear() {
		return studentyear;
	}

	public void setStudentyear(int studentyear) {
		this.studentyear = studentyear;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
