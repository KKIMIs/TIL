package basic08_net;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class MulticastReceive {
	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT = 11111;
	
	public MulticastReceive() {
		try {
			ms = new MulticastSocket(PORT);
			ia = InetAddress.getByName("224.123.125.153");
			
			InetSocketAddress isa = new InetSocketAddress(ia,PORT);
			NetworkInterface ni = NetworkInterface.getByName("ggm");
			ms.joinGroup(isa, ni);
			
			byte data[] = new byte[512];
			dp = new DatagramPacket(data, 0,data.length);
			ms.receive(dp); // 받기 대기 중
			
			System.out.println(new String(dp.getData(),0, dp.getLength()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MulticastReceive();

	}

}
