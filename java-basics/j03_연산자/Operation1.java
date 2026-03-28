package j03_연산자;

public class Operation1 {

	public static void main(String[] args) {
		// 증감연산자
		int num = 50;
		System.out.println(num);
		++num;
		System.out.println(num);
		num++;
		System.out.println(num);
		System.out.println();
		
		System.out.println(num); 	// 52
		System.out.println(++num); 	// 53
		System.out.println(num); 	// 53
		System.out.println(num++);  // 53
		System.out.println(num); 	// 54
		
		System.out.println();
		
		System.out.println(num); 	// 54
		System.out.println(--num); 	// 53
		System.out.println(num); 	// 53
		System.out.println(num--);  // 53
		System.out.println(num); 	// 52
	}
}
