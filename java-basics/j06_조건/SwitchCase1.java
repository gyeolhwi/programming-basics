package j06_조건;

public class SwitchCase1 {
	public static void main(String[] args) {
		
		switch(30) {
		case 10:
			System.out.println("10");
		case 20:
			System.out.println("20");
		case 30:
			System.out.println("30");
		case 40:
			System.out.println("40");
		case 50:
			System.out.println("50");
		}
		System.out.println();
		
		String num = "10";
		switch(num) {
		case "10":
			System.out.println("10");
		case "20":
			System.out.println("20");
			break;	// 멈추고 빠져나오는 기능
		case "30":
			System.out.println("30");
		case "40":
			System.out.println("40");
		case "50":
			System.out.println("50");
		default : System.out.println("끝");
		}
		System.out.println("switchCase 밖");
		num = "10";
		switch(num) {
		case "15":
			System.out.println("15");
		case "10":
			System.out.println(1);
		case "5":
			System.out.println(2);
		}
	}
}
