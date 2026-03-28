package j08_메소드;

import java.util.Scanner;

public class teacher {
	public static void savePw(String str) {
		boolean flag = false;
		for(int i = 0; i < str.length(); i ++) {
			String spaceConfirm = str.substring(i,i+1);
			if(spaceConfirm.equals(" ")) {
			 flag = true;}
			}
			if(flag) {
				System.out.println("비밀번호에 포함 할 수 없는 문자가 있습니다");
			}
			else {System.out.println("사용가능한 비밀번호입니다");
			}

	}
	public static void deletePw(String str) {
		System.out.println("삭제되었습니다.");
	}
	public static void confirmPw(String str) {
		boolean flag = false;
		for(int i = 0; i < str.length(); i++) {
			String confirmPassword = str.substring(i,i+1);
			if(confirmPassword.equals("/")
				|| confirmPassword.equals(",")
				||	confirmPassword.equals(" ")) {
				flag = true;
			}
		}
			if (flag) {
				System.out.println("포함할 수 없는 문자가 있습니다");
			}else { System.out.println("사용가능한 비밀번호입니다");
			}
	}
	public static void main(String[] args) {
		/*
			# 메인에서 조건문 반
			#2 메소드(저장,삭제,확인)
			#3 메소드 1, 2, 3			
			저장 save 
			조건 ( 공백이 있는지)
			출력
			삭제 delete 
			삭제출력
			확인 confirm
			조건문 (/ , 콤마, 공백)
			출력
			#4 오버로딩은 안됨
 */
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String action = null;
			String password = null;
			
			System.out.println("동작을 입력하시오: ");
			action = scanner.nextLine();
			System.out.println("비밀번호를 입력하시오: ");
			password = scanner.nextLine();
			
			if (action.equals("저장")) {
				savePw(password);
				continue;
			}else if(action.equals("삭제")){
				deletePw(password);
				continue;
			}else if(action.equals("확인")) {
				confirmPw(password);
				continue;
			}else if(action.equals("exit")) {
				break;
			}
			break;
			
			/*
			 * savePw
			 * deletePw
			 * confirmPw
			 */
//			if(action.equals("exit")) {break;}
		}
	}
}
