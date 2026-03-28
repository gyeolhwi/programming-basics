package j12_다형성2;

public class KakaoTalk implements Messenger{//구현

	@Override
	public void send() {
		System.out.println("카카오톡에서 메세지를 보냅니다");
	}

	@Override
	public void receive() {
		System.out.println("카카오톡에서 메세지를 받습니다");
		
	}
	public void sendPresent() {
		System.out.println("카카오톡에서 선물을 보냅니다");
	}

}
