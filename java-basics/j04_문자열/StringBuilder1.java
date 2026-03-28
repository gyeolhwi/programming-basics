package j04_문자열;

public class StringBuilder1 {

	public static void main(String[] args) {
		
		// 값넣기
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append("이름: ");
		stringBuilder.append("홍길동");
		
		
		//값삭제
		stringBuilder.delete(1, 2); //	인덱싱으로삭제
		System.out.println(stringBuilder);
		
	}
}
