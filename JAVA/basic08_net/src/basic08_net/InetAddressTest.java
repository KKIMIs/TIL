package basic08_net;

import java.net.InetAddress;

public class InetAddressTest {

	public InetAddressTest() {
		// TODO Auto-generated constructor stub
	}
	public void start() {
		
		try {
			//ip에 관련된 객체를 생성

			//내 컴퓨터의 아이피 정보 얻어오기
			InetAddress ia = InetAddress.getLocalHost();
			String ip = ia.getHostAddress(); //내 컴퓨터 ip
			String name = ia.getHostName(); //컴퓨터 이름 또는 url주소
			
			System.out.println("ip->"+ip);
			System.out.println("name->"+name);
			
			//도메인 이용한 InetAddress를 얻어오기
			InetAddress ia2 = InetAddress.getByName("www.youtube.com");
			System.out.println("ia2.address->"+ia2.getHostAddress());
			System.out.println("ia2.name->"+ia2.getHostName());
			
			//naver:223.130.195.95
			//아이피를 이용한 InetAddress를 얻엉오기
			InetAddress ia3 = InetAddress.getByName("223.130.195.95");
			System.out.println("ia3.address->"+ia3.getHostAddress());
			System.out.println("ia3.name->"+ia3.getHostName());
			System.out.println("-------------------------------");
			
			//여러개의 inetAddress 객체 얻어오기
			InetAddress[] ia4 = InetAddress.getAllByName("www.seoul.go.kr");
			for(InetAddress i: ia4) {
				System.out.println("ia4.address->"+i.getHostAddress());
				System.out.println("ia4.name->"+i.getHostName());
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		InetAddressTest it = new InetAddressTest();
		it.start();
	}

}
