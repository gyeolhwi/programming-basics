package j03_연산자;

public class Operation4 {

	public static void main(String[] args) {
	
	 //윤년 : 해당 년도가 4의 배수이고, 100의 배수가 아니거나 400의 배수일 
	int year = 2023;
	String result = year % 4 == 0 
			&& (year % 100 != 0 || year % 400 == 0) ? "윤년" 
					: "!윤년";
			
	System.out.println(result);
	
	int num = 500;
	String result2 = num > 4000 ? "4000보다 큼"
			: num > 3000 ? "3000보다 큼"
			: num > 2000 ? "2000보다 큼"
			: "2000이하";
	System.out.println(result2);
	}
}




