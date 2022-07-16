package basic08_net;

import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class FileUnicastSend {
	DatagramPacket dp;
	DatagramSocket ds;
	InetAddress ia;
	final int PORT = 15000;
	
	public FileUnicastSend() {
		// TODO Auto-generated constructor stub
	}
	public void sendStart() {
		try {
			ds = new DatagramSocket();
			ia = InetAddress.getByName("127.0.0.1");
			
			//파일의 내용을 byte 배열로 읽어와 전송하기 위해
			//InputStream객체 생성
			File f = new File("/Users/karlakim/dev/sample1.jpeg");
			FileInputStream fis = new FileInputStream(f);
			
			
			//파일명을 전송
			String sendFileName = "[*FileName*]"+ f.getName();
			dp = new DatagramPacket(sendFileName.getBytes(), 0, 
					sendFileName.getBytes().length, ia, PORT);
			
			ds.send(dp);
			
			//파일 내용을 전송
			int cnt = 0;
			while(true) {
				byte[] b = new byte[512];
				int byteCount = fis.read(b,0,b.length);
				System.out.println(++cnt+": byte = "+byteCount);
				if (byteCount<=0) break;
				dp = new DatagramPacket(b,0,byteCount, ia, PORT);
				ds.send(dp);
				
			}
			
			//전송 완료
			String endMessage = "[*EndOfTSF*]";
			dp = new DatagramPacket(endMessage.getBytes(), 0, 
					endMessage.getBytes().length, ia, PORT);
			
			ds.send(dp);
			
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new FileUnicastSend().sendStart();

	}

}
