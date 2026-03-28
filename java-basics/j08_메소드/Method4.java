package j08_메소드;

import java.util.Scanner;
//public static 

public class Method4 {
	
	static Scanner scanner = new Scanner(System.in);
	static String pw = null;
	

	//1 저장
	public static String password () {
		boolean flag = false;
//		 String pw = null;
		System.out.print("비밀번호를 입력하시오 : ");scanner.nextLine();
		pw = scanner.nextLine();
		
		for (int i = 0 ; i < pw.length(); i ++) {
			String pwtest = pw.substring(i,i+1);
			if(		  pwtest.equals(",") 
					||pwtest.equals("/") 
					||pwtest.equals(" "))
			{
				flag = true;
			}
		}
			if (flag){
			System.out.println("비밀번호에는 콤마(,) 공백 ( ) 슬러쉬(/)가 포함될 수 없습니다.");
			return "돌아갑니다";} //switch로 계속 반복시킬 수 있을듯
			else {
			System.out.println("저장되었습니다");
			return pw;}
	}
	
	// 2 delete
	public static void delete() {
		pw = null;
	}
	
	
	// 3 수정
	public static void edit() {
		System.out.println("현재 비밀번호: "+ pw+"\n수정하시겠습니까?\n1.수정\t2.취소");
		
		int answer = scanner.nextInt();
		switch(answer) {
		case 1: password();
				break;
		case 2:	System.out.println("취소되었습니다");break;
		} 
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/*
		 * 비밀먼호 (pw)
		 * 동작을 입력하시오 : 저장
		 * 비밀번호를 입력하시오 : 1q2w3e4r!
		 * 저장되었습니다
		 * 비밀번호를 입력하시오 : 1 234
		 * 공백은 포함할 수 없습니다
		 * 동작을 입력하시오 : 삭제
		 * 비밀번호를 입력하시오 : 	1q2w3e4r!!
		 * 삭제되었습니다
		 * 동작을 입력하시오 : 확인
		 * 비밀번호를 입력하시오 : 1234/!,
		 * 비밀번호에는 / , 콤마(,) 공백 ( ) 이 포함될 수 없습니다.
		 * 
		 * 동작을 입력하시오 : 확인 
		 * 비밀번호를 입력하시오 : 1234
		 * 사용가능한 비밀번호입니다.
		 * 동작을 입력하시오 exit
		 */
		int  number = 0;
		while(number != 4) {
		System.out.println("비밀번호 입력 프로그램");
		System.out.println("1.저장\n2.삭제\n3.수정\n4.종료");
		System.out.println("동작을 입력하시오 :");
		
		
		number = scanner.nextInt();
		
		switch (number) {
		case 1: System.out.println("비밀번호: "+password());break;
		case 2: System.out.println("기존비밀번호:"+ pw +"\n삭제하시겠습니까?\n1.삭제\t2.취소");
					int input = scanner.nextInt();
					if(input == 1) { delete();System.out.println("삭제되었습니다.");}
					else if (input == 2) {System.out.println("취소합니다"); continue;}
		case 3:	edit();break;
		case 4: System.out.println("종료");break;
			}
		}
		
		
	}
}
