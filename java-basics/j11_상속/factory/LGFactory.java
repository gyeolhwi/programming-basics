 package j11_상속.factory;


public class LGFactory extends Factory{

	public LGFactory(int factoryNumber) {
		super(factoryNumber);
	}
	
	//오버라이딩
	public void start() {
		System.out.print("LG "); // 얘만추가...
		super.start();	//Factory에 있는 start를 그대로 쓴다
	}
	public void stop() {
		System.out.print("LG ");

		super.stop();
	}
	public void produceSmartTV() {
		System.out.println("LG 스마트TV 를 만듭니다.");
	}
		
}
