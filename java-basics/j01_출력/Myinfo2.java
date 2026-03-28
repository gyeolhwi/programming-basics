package j01_출력;

public class Myinfo2 {

	public static void main(String[] args) {
		boolean flag; //선언
		flag = true;
		flag = false;
//		flag = 1;  		boolean은 0,1 인식 안됨
		System.out.println(flag);
		char name1 = '홍';
		char name2 = '길';
		char name3 = '동';
		
		System.out.print(name1);
		System.out.print(name2);
		System.out.print(name3);
		System.out.println();
		
		
		System.out.println(name1 + name2 + name3); // >>> ascii로 인식됨 
		System.out.println(""+name1 + name2 + name3); // >>> 홍길동 "" 문자열로인식
		
	}
}