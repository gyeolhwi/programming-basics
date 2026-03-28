package j11_상속.factory;

public class Factory { 
		private int factoryNumber;

		public Factory(int factoryNumber) {
			
//			super();				// 얘는 있어야하나요? = 없어도 기본으로 호출 됨
			
			this.factoryNumber = factoryNumber;
//			System.out.println("이건 언제? Factory를 첫번째로 호출");
		}
		
		public void start() {
			System.out.println(factoryNumber+ "공장을 가동합니다");
	}
		public void stop() {
		System.out.println(factoryNumber+"공장을 중지합니다");
		}


}

