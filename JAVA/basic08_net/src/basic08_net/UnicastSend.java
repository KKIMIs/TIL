package basic08_net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicastSend {
	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia;
	
	public UnicastSend() {
		String str = "Spring Framework, 스프링 프레임워크";
		try {
			// 정보 보내는 곳
			ds = new DatagramSocket();
			
			
			// udp방식의 정보를 보낼 경우 DatagramSocket을 생성 후 전송
			byte[] data = str.getBytes();
			ia = InetAddress.getByName("127.0.0.1");
			//						보낼데이터
			dp = new DatagramPacket(data, 0, data.length,ia,11000);
			//전송하기
			ds.send(dp);
			System.out.println("전송완료 --------- 보내기");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicastSend();

	}

}
