package j12_다형성2;

public class FaceBookMessenger implements Messenger{ //구현

	@Override
	public void send() {
		System.out.println("페이스북 메세지를 보냅니다");
	}

	@Override
	public void receive() {
		System.out.println("페이스북 메세지를 받습니다");
	}
	
	public void call() {
		System.out.println("페이스북에서 전화를 겁니다.");
	}
	

}
