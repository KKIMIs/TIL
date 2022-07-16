package basic08_net;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class FileMulticastSend {
	MulticastSocket ms;
	DatagramPacket dp;
	InetAddress ia;
	final int PORT = 12222;
	
	public FileMulticastSend() {
		
		try {
			//보낼내용 
			//파일의 내용을 byte 배열로 읽어와 전송하기 위해
			//InputStream객체 생성
			File f = new File("/Users/karlakim/dev/sample3.jpeg");
			FileInputStream fis = new FileInputStream(f);
			
			ms = new MulticastSocket(); 
			ia = InetAddress.getByName("224.123.125.222");
			
			//파일명 전송
			String sendFileName = "[*FileName*]"+ f.getName();
			dp = new DatagramPacket(sendFileName.getBytes(), 0, 
					sendFileName.getBytes().length, ia, PORT);
			ms.send(dp);
			
			//파일내용 전송
			int cnt = 0;
			while(true) {
				byte[] b = new byte[512];
				int byteCount = fis.read(b,0,b.length);
				System.out.println(++cnt+": byte = "+byteCount);
				if (byteCount<=0) break;
				dp = new DatagramPacket(b,0,byteCount, ia, PORT);
				ms.send(dp);
				
			}
			
			//전송 완료
			String endMessage = "[*EndOfTSF*]";
			dp = new DatagramPacket(endMessage.getBytes(), 0, 
					endMessage.getBytes().length, ia, PORT);
			
			ms.send(dp);
			
			fis.close();
			System.out.println("전송완료...send");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FileMulticastSend();

	}

}
