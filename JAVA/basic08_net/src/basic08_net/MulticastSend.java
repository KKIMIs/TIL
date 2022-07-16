package basic08_net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSend {
	//멀티캐스트 아이피 224.0.0.0 ~ 239.255.255.255
	//224.123.125.153
	
	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT = 11111;
	
	public MulticastSend() {
		//보낼내용 
		String str = "멀티캐스트를 이용한 통신 연습 중...";
		try {
			ms = new MulticastSocket(); 
			ia = InetAddress.getByName("224.123.125.153");
			dp = new DatagramPacket(str.getBytes(), 0 , str.getBytes().length,ia,PORT);
			
			
			ms.send(dp);
			
			System.out.println("전송완료...send");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MulticastSend();
	}

}
