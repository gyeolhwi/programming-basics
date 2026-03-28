package j11_상속.factory;

public class FactoryMain2 {
	public static void main(String[] args) {
		/*
		 *  배열 1개 만들기
		 * 	삼성1공장 가동
		 * 	엘지1공장 가동
		 * 	삼성2공장 가동
		 * 	엘지2공장 가동
		 */
		/*
		Factory[] factory = new Factory[4];
		
		SamsungFactory sm1 = new SamsungFactory(1);
		SamsungFactory sm2 = new SamsungFactory(2);
		
		LGFactory lg1 = new LGFactory(1);
		LGFactory lg2 = new LGFactory(2);
		
		factory[0] = sm1;
		factory[1] = lg1;
		factory[2] = sm2;
		factory[3] = lg2;
		
		for(int i = 0; i < factory.length; i++) {
			factory[i].start();
		}
		*/
		// 선생님
		Factory[] factories = new Factory[4];
		factories[0] = new SamsungFactory(1);
		factories[1] = new LGFactory(1);
		factories[2] = new SamsungFactory(2);
		factories[3] = new LGFactory(2);
	}
}
