package j09_클래스.접근지정자.student;

public class StudentMain {
	public static void main(String[] args) {
		/*
		 *  Student 생성 , name에 홍길동 값 주입
		 *  
		 *  전체생성자 만들기
		 *  홍길동 / 3 / 18 / 부산 동래구 / 010-1234-5678
		 */
		Student student = new Student("홍길동",3,18,"부산 동래구","010-1234-5678"); //객체 생성
		/*
		 * 기본생성자는 생략이 가능하다 , but 생성자오버로딩(생성자선언) 이 됐을 시 기본생성자를 사용하려면 꼭 명시를 해줘야 한다 
		 */
		
		Student student2 = new Student();
		
		student.showInfo();
		
		System.out.println();
		
		System.out.println(student.getName());
		
		System.out.println(student.getAge());
		

		// 기본생성자 특징 : 이름이 클래스명과 같다. 생략 가능하다. 주소값을 반환한다
		
//		student. 프라이빗이라 나오지 않음 생성자는 접근지정자(public)
//		System.out.println(student.); 변수가 프라이빗이라 출력 안됨
		
//		public Student(String name, int studentyear, int age, String address, String phone) {
		
	}
}
