package j07_반복;

public class Continue1 {

	public static void main(String[] args) {
		for(int i = 0; i <10; i++) {
			
			if(i % 2 == 0) {
				System.out.println("continue 전");
				continue;		// 해당 반복문으로 돌아감
			}
			System.out.println("i = " + i );
		}
		/*
		 *  for 와 continue를 사용하여 1부터 100까지 홀수를 더한 수의 합을 구하시오
		 */
		int number = 0;
		for (int i = 0; i < 100; i++) {
			if ( i % 2 == 0) continue;
			number+=i;
		}
		System.out.println(number);
		
		// 선생님
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			int num = i +1;
			if(num % 2 ==0) {
				continue;
			}
			sum += num;
		}
		System.out.println(sum);
	}
}
