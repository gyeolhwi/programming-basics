package j07_반복;

public class DoubleWhile1 {
	public static void main(String[] args) {
		// 중첩반복
		// 쓰임새 시계,
		int i = 0;
		while(i < 5) {
			System.out.println("i= "+i);
			
			int j = 0;	// j 초기화 
			while ( j< 3 ) {
				System.out.println("\tj = " + j);
				j++;
			}
			i++;
		}
	}
}
