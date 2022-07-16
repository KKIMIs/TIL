package basic08_net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicastReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	
	
	
	public UnicastReceive() {
		try {
			//정보 받는 곳
			ds = new DatagramSocket(11000);
			
			//512byte (권장)
			byte data[] = new byte[512];
			dp = new DatagramPacket(data, data.length);
			System.out.println("받기 대기 중....");
			ds.receive(dp);
			
			//전송받은 데이터 출력하기
			byte[] receiveData = dp.getData(); 				//전송받은 바이트 수
			System.out.println(new String(receiveData,0,dp.getLength()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UnicastReceive();

	}

}
