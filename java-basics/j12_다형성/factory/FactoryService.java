package j12_다형성.factory;

import j11_상속.factory.Factory;

public class FactoryService {
	
	private Factory factory;		// 팩토리 자료형의 변수선언 (Factory 클래스에 접근 메서드도 사용가능)

	public FactoryService(Factory factory) {	// Factory 자료형의 factory를 매개변수로 받겠다 new LG
		super();
		this.factory = factory;
	}
	public void factoryStart() {	
		factory.start();
	}
	public void factoryStop() {
		factory.stop();
	}
}
