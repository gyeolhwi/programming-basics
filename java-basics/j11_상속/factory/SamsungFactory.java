
package j11_상속.factory;

public class SamsungFactory extends Factory{	//삼성은 기본팩토리를 상속한다고함2.
	
	public SamsungFactory(int factoryNumber) {		// 여기서 생성 발생 인수는 factoryNumber3.
		super(factoryNumber);				// 얘를 쓰기위해서는 부모 메서드에 생성이 되어야함 //super 부모의 (factoryNumber)
	}
		public void start() {
			System.out.print("Samsung ");
			super.start();		// 감을 못 잡겠음
	}	
		public void stop() {
			System.out.print("Samsung ");
			super.stop();
			System.out.println();
		}
		
		public void produceSmartPhone() {
			System.out.println("삼성 스마트폰을 만듭니다.");
		}

}			                                 