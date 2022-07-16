package basic08_net;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class FileMulticasstReceive {
	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT = 12222;
	FileOutputStream fos;
	
	public FileMulticasstReceive() {
		try {
			ms = new MulticastSocket(PORT);
			ia = InetAddress.getByName("224.123.125.222");
			
			InetSocketAddress isa = new InetSocketAddress(ia,PORT);
			NetworkInterface ni = NetworkInterface.getByName("ggm");
			ms.joinGroup(isa, ni);
			
			while(true) {
				byte data[] = new byte[512];
				dp = new DatagramPacket(data, 0,data.length);
				System.out.println("...전송 받기 대기 중...");
				ms.receive(dp); //전송받기
			
				byte[] receive = dp.getData();
				int byteCount = dp.getLength(); //전송받은 byte수
				
				String receiveStr = new String(receive, 0, byteCount);
				if(byteCount>=12 
						&& receiveStr.substring(0,12).equals("[*FileName*]")) {
					//파일명이 전송됨
					fos = new FileOutputStream(new File("/Users/karlakim/dev2/",receiveStr.substring(12)));
					System.out.println("파일 생성됨 ---> "+receiveStr);
				} else if(byteCount>=12 
						&& receiveStr.equals("[*EndOfTSF*]")) {
					fos.close();
					ms.close();
					System.out.println("...파일로 저장되었습니다...");
					break;
				
				}  else { //파일내용
					fos.write(receive, 0, byteCount);
				}
			}
			
			//System.out.println(new String(dp.getData(),0, dp.getLength()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileMulticasstReceive();
		
		
	}

}
