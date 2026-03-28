package j04_문자열;

public class String4 {

	public static void main(String[] args) {
		String userinfo = "홍길동-010/1234/5678-18, 가나다-010/1111/2222-24,심청이-010/9999/8888-12";
		
		/*	홍길동-010/1234/5678-18, 가나다-010/1111/2222-24,심청이-010/9999/8888-12
		 * 	홍길동_010-1234-5678_18/가나다_010-1111-2222_24/심청이_010-9999-8888_12
		 *  콤마를 기준으로 설정이 바꾸기
		 */
		// 여기선 겹치는 게 없으므로, 괜찮으나 다른기준이면?
		System.out.println(userinfo);
		
		// 선생님
		String reUserinfo = userinfo.replaceAll("-", "_")  
									.replaceAll("/", "-")
									.replaceAll(",", "/");
		System.out.println(reUserinfo);
		
	}
}
