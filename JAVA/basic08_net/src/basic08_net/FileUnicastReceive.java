package basic08_net;

import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class FileUnicastReceive {
	DatagramPacket dp;
	DatagramSocket ds;
	FileOutputStream fos;
	public FileUnicastReceive() {
		// TODO Auto-generated constructor stub
	}
	public void receiveStart() {
		try {
			ds = new DatagramSocket(15000);
			byte[] receiveData = new byte[512];
			
			dp = new DatagramPacket(receiveData,receiveData.length);
			
			
			while(true) {
				System.out.println("...전송 받기 대기 중...");
				ds.receive(dp); //전송받기
			
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
					ds.close();
					System.out.println("...파일로 저장되었습니다...");
					break;
				
				}  else { //파일내용
					fos.write(receive, 0, byteCount);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new FileUnicastReceive().receiveStart();

	}

}
