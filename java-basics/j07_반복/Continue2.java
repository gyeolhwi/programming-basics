package j07_반복;

//import java.util.Scanner;

public class Continue2 {
	public static void main(String[] args) {
//		String str = "홍길동";
//		System.out.println(str.equals("홍길동"));
//		System.out.println(str.equals("홍길"));
		
		/*
		 * 최창규님, 정지윤님,전수빈님/ 오재근님
		 * 
		 * 반복을 돌려서 이름만 남겨두고 출력하시오
		 * 
		 * >>> 최창규정지윤전수빈오재근
		 */
		
//		Scanner scanner = new Scanner(System.in);
		
//		String names = "최창규님, 정지윤님,전수빈님/오재근님";

////		System.out.println(names.indexOf("님",names.indexOf("님")+1));
//			int n = 1;
//		
////		String name =null;
//		for (int i = 0; i < 4; i++) {
//			int index = names.indexOf("님",n);
//			String input = null;
//			input = scanner.nextLine();
//			System.out.println(names.substring(index-3,index));
//			n += index;
//		}
		// 선생님
		
		//문자열 변수선언 , for 반복(횟수 :length) , subsString(i,i+1), .equlas("님")
		System.out.println();
		String names = "최창규님, 정지윤님,전수빈님/오재근님";
		String totalNames = null;
		for(int i = 0; i < names.length(); i++) {	// 최 부터 님 까지 반복한다
			String subNames = names.substring(i, i+1);	// subnames  = i 부터 i+1까지 한글자씩 자른다
			if(		   subNames.equals("님")
					|| subNames.equals(",")
					|| subNames.equals(" ")
					|| subNames.equals("/")){continue;
					}
			totalNames += subNames;
		}
		System.out.println(totalNames.substring(4)); // 0null이 왜 포함되어있는가?
		}
	}










