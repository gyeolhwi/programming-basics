package j02_상수와변수의형변환;

public class Cast {

	public static void main(String[] args) {
		
		// 업캐스팅(묵시적 형변환)
		char a = 'A';
		int b = a; // >>> 65
		double c = b;
		
		System.out.println(c);
		
		c = a;
		System.out.println(c);
		
		// 다운캐스팅 (명시적형변환)
		// 표기법 변환할자료형 변수명 = (변환자료형) 변수명;
		int d = (int) c;
		char e = (char) d;
		
		System.out.println(d);
		System.out.println(e);	
	}
}