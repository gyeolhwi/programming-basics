package j12_다형성2;

public class MessengerMain {
	public static void main(String[] args) {
		
	
	//업캐스팅한 각각의 생성자 만들기
	Messenger facemessenger = new FaceBookMessenger(); // 매번 실행 할 때 마다 새로운 주소를 할당 받음
	Messenger messenger = new KakaoTalk();
	// or
	KakaoTalk kakaoTalk = new KakaoTalk();
	FaceBookMessenger facebookMessenger = new FaceBookMessenger();
	
	
	MessengerMiddleware middleware = new MessengerMiddleware(/*동작할 메신저 채널*/facemessenger);
			/*
			 * messengerMiddleware.sendMessage();
			 * -> 카카오톡에서 메세지를 보냅니다
			 * -> 페이스북에서 메세지를 보냅니다
			 * 
			 * messengerMiddleware.receiveMessage();
			 * -> 카카오톡에서 메세지를 받습니다.
			 * -> 페이스북에서 메세지를 받습니다.
			 * 
			 * messengerMiddleware.runAddOns();
			 * -> 카카오톡에서 선물을 보냅니다.
			 * -> 페이스북에서 전화를 겁니다.
			 */
	
	middleware.sendMessage();
	middleware.receiveMessage();
	middleware.renAddOns();
	
	}		
}
