package j11_상속.factory;

public class FactoryMain {
	public static void main(String[] args) {
//		SamsungFactory samsungfactory = new SamsungFactory(1);
//		SamsungFactory.start();
		
		/*
		 * 삼성공장 배열 3개를 만들고, 각각의 삼성공장을 모두 가동
		 * 각각의 삼성공장을 모두 중지
		 * 
		 * 엘지 공장 배열 3개를 만들고 가동,중지
		 */
		SamsungFactory[] sam = new SamsungFactory[4];
		LGFactory[] lgf = new LGFactory[4];
		// 생성하면 Samsung으로 감 1
		SamsungFactory samf1 = new SamsungFactory(1);	//객체를 만든 
		SamsungFactory samf2 = new SamsungFactory(2);
		SamsungFactory samf3 = new SamsungFactory(3);
		SamsungFactory samf4 = new SamsungFactory(4);
		
		LGFactory LGF1 = new LGFactory(1);
		LGFactory LGF2 = new LGFactory(2);
//		LGFactory LGF3 = new LGFactory(3);
		LGFactory LGF4 = new LGFactory(4);
		lgf[0] = LGF1;
		lgf[1] = LGF2;
//		lgf[2] = LGF3;
		lgf[3] = LGF4;
				
				
		// 인수값 1을 넣은 SamsungFactory 클래스 자료형의 samf1 생성
		
//		SamsungFactory samf2 = new SamsungFactory(2);
//		SamsungFactory samf3 = new SamsungFactory(3);
		sam[0] = samf1;
		sam[1] = samf2;
//		sam[2] = samf3;
		sam[3] = samf4;
		
		for(int i = 0; i < 4; i++) {
			if(sam[i] == null) {continue;}
			sam[i].start();
			sam[i].stop();
			
			if(lgf[i] == null) {continue;}
			lgf[i].start();
			lgf[i].stop();
			
		} //만약 출력하고자 하는 배열의 길이가 각각 다를 땐 어떻게 하나요?
//		
		
	}
}
		
