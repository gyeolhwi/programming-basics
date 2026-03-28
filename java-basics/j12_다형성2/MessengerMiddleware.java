package j12_다형성2;

public class MessengerMiddleware {//통제할곳
	
	private Messenger messenger;

	public MessengerMiddleware(Messenger messenger) { //Messenger 자료형이 messenger을 자동적으로 업캐스팅해줌
		this.messenger = messenger;
	}
	
	public void sendMessage() {
		messenger.send();
	}
	public void receiveMessage() {
		messenger.receive();
	}
	
	public void renAddOns() {
		if(messenger instanceof FaceBookMessenger) {
			((FaceBookMessenger) messenger).call();
		}
		else if(messenger instanceof KakaoTalk) {
			((KakaoTalk) messenger).sendPresent();
		}else { System.out.println("형변환 안됨");}
	}
	
	
	
	

}
