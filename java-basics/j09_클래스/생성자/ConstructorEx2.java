package j09_클래스.생성자;



public class ConstructorEx2 {
	
	String top;
	String color;
	int size;
	
	
	public ConstructorEx2(String top) { //자료형이 같은 인수는 하나밖에 쓰지못한다
		super();
		this.top = top;
	}
	
	public ConstructorEx2(String top, String color, int size) {
		super();
		this.top = top;
		this.color = color;
		this.size = size;
	}
}