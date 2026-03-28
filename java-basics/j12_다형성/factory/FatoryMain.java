package j12_다형성.factory;

import j11_상속.factory.Factory;
import j11_상속.factory.LGFactory;
import j11_상속.factory.SamsungFactory;

public class FatoryMain {
	public static void main(String[] args) {
		
		//각각의 생성자 호출
		Factory factory = new Factory(1);
		SamsungFactory samsungFactory = new SamsungFactory(1);	
		LGFactory lgFactory = new LGFactory(1);
		// 상속관계로 응집도를 높임
		
		// Factory Service 클래스 생성자 호출 ( Factory 자료형을 인수로 받음 )  Factory자료형에 삼성엘지가 포함되는거?
		FactoryService factoryService = new FactoryService(lgFactory); 
		
		/*
		 * factoryService.factoryStart();
		 * -> 삼성 1공장을 가동합니다
		 * 
		 * factoryService.factoryStop();
		 * -> 삼성 1공장을 중지합니다
		 */
			
		factoryService.factoryStart();
		factoryService.factoryStop();
	}
}
