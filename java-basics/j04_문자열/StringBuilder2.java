package j04_문자열;

public class StringBuilder2 {

	public static void main(String[] args) {
	StringBuilder stringBuilder = new StringBuilder();
	String place = "금정구,동래구,사하구,사상구,강서구";
	String place2 = "금정구,동래구,사하구,사상구,강서구";
	
	/*
	 * StringBuilder를 활용하여
	 * 금정/동래/사하사상/강서 가 출력되도록 하시오
	 */
	place = place.replaceAll(",", "/"); // 슬러쉬 처리
	System.out.println(place);
	stringBuilder.append(place);
	stringBuilder.delete(2,3);
	stringBuilder.delete(5,6);
	stringBuilder.delete(8,9);
	stringBuilder.delete(11,12);
	stringBuilder.delete(14,15);
	System.out.println(stringBuilder);	
	
	// 선생님
	int index = place.indexOf("구");
	System.out.println(index);
	
	int index2 = place.indexOf("구",3);
	System.out.println(index2);
	
	// 좀 더 쉽게 구현해보기
	System.out.println();
	StringBuilder stringBuilder2 = new StringBuilder();
	stringBuilder2.append(place);
	
	System.out.println(stringBuilder2);
//	stringBuilder2.delete("구");
//	stringBuilder2.replaceAll("구,","/"); 클래스성질이라서 안됨
	int indexnum = stringBuilder2.indexOf("구");
	System.out.println(indexnum);
	
	// 이게 맞나..?
	
	stringBuilder2 = stringBuilder2.delete(stringBuilder2.indexOf("구"),stringBuilder2.indexOf("구")+1);
	stringBuilder2 = stringBuilder2.delete(stringBuilder2.indexOf("구"),stringBuilder2.indexOf("구")+1);
	stringBuilder2 = stringBuilder2.delete(stringBuilder2.indexOf("구"),stringBuilder2.indexOf("구")+1);
	stringBuilder2 = stringBuilder2.delete(stringBuilder2.indexOf("구"),stringBuilder2.indexOf("구")+1);
	stringBuilder2 = stringBuilder2.delete(stringBuilder2.indexOf("구"),stringBuilder2.indexOf("구")+1);
	
	System.out.println(stringBuilder2);
	
	//선생님
	stringBuilder2.append(place.substring(0,index));
	stringBuilder2.append("/");
	
	index = place.indexOf("구",index+1);
	stringBuilder2.append(place.substring(index -2 , index));
	stringBuilder2.append("/"); //이걸 반복
	
	//append 사용하기 * 복
	StringBuilder stringBuilder3 = new StringBuilder();
//	stringBuilder3.append(place2);
	System.out.println(stringBuilder3);
	int index3 = 0;
	stringBuilder3.append(place2.substring(index3,index3+2));
	System.out.println(stringBuilder3);
	
	// 선생님 delete 사용하기
	
	int index4;
	stringBuilder3.append(place2);
	index4 = stringBuilder3.indexOf("구");
	stringBuilder3.delete(index4, index4+3);
	
	System.out.println(stringBuilder3);
	}
}
