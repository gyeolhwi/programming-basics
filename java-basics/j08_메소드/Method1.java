package j08_메소드;

public class Method1 {
	public static void main(String[] args) {
	
		int num1 = 15;
		int num2 = 20;
				// result값-
					//인수
		int sum = add(15,25); //호출 
		
		System.out.println(num1 + " + " + num2 + " = " +sum);
		
		
	}
	// 인수와 매개변수의 이름은 같지않아도 된다
							//매개변수
	public static int add(int num1, int num2) { //public 접근지정자 , static 내부변수,권역변수
		int result = num1 + num2;
		return result;
	}
}