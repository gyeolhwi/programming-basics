package j10_배열;

import j09_클래스.접근지정자.student.Student;

public class Array5 {
	public static void main(String[] args) {
		/*
		 * 홍길동 3 18 부산 동래구 010-3300-4698     - 0
		 * 오재근 2 17 부산 금정구 010-1234-5678     - 1
		 * 성시원 1 16 부산 진구   010-1111-2222     - 3
		 * 
		 * student 라는 배열(방 5개)
		 * 반복문 돌려서 다 출력
		 */
		// 정적 메모리할당
		Student[] students = new Student[5]; //배열만들기 Student 클래스에 접근한다
		
		Student st1 = new Student("홍길동",3,18,"부산 동래구","010-3300-4698"); // 객체만들기
		Student st2 = new Student("오재근",2,17,"부산 금정구","010-1234-5678");
		Student st3 = new Student("성시원",1,16,"부산 진구","010-1111-2222");
		
		students[0] = st1;
		students[1] = st2;
		students[3] = st3;
		
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {continue;}		// 해당 배열에 null이 껴있기 떄문에 오류가 뜸
			
			System.out.println(students[i].getName() +" "
					+students[i].getStudentyear()+" "
					+students[i].getAge()+" "
					+students[i].getAddress()+" "
					+students[i].getPhone());
		}
		
		
		
	
		
		
	}
}
