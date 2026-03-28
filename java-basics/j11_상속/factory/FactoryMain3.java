package j11_상속.factory;

public class FactoryMain3 {
	public static void main(String[] args) {
		Factory[] factories = new Factory[6];
		
		factories[0] = new SamsungFactory(1);	// factory로 업캐스팅 된 상태
		factories[1] = new LGFactory(1);
		factories[2] = new SamsungFactory(2);
		factories[3] = new LGFactory(2);
		factories[4] = new SamsungFactory(3);
		factories[5] = new LGFactory(3);
				
		// 변수명 instanceof 변수
//		((SamsungFactory)factories[0]).produceSmartPhone(); //삼성 꺼
		
//		System.out.println(factories[1] instanceof SamsungFactory);
		
//		if(factories[1] instanceof SamsungFactory == true)
		/*	
		for(int i = 0; i < factories.length; i ++) {
			factories[i].start();
			if(factories[i] instanceof SamsungFactory == true) {	// true는 뺴도됨
				((SamsungFactory)factories[i]).produceSmartPhone();	// 다운캐스팅
			}else {((LGFactory)factories[i]).produceSmartTV();		// 다운캐스팅
			}
			System.out.println();
		}
		*/
		// 선생님
		for(int i = 0; i < factories.length; i++) {
			factories[i].start();
			if(factories[i] instanceof SamsungFactory) {	// 해당factories[i]의 주소가 SamsungFactory라면
				((SamsungFactory)factories[i]).produceSmartPhone();	// 다운캐스팅
			}else if(factories[i] instanceof LGFactory) {
				((LGFactory)factories[i]).produceSmartTV();
			}else {System.out.println("다운캐스팅불가");
			}
			
		}
	}
}