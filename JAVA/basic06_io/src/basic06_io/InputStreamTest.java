package basic06_io;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {
		// TODO Auto-generated constructor stub
	}
	public void start() {
		//input, output
		//input(byte), reader(문자)단위로 읽어온다
		
		//byte단위로 문자를 입력받는다
		try {
			InputStream in = System.in;
			
			
			/*read()
			while(true) {
				int inData = in.read(); //-1: 읽은 값이 없을 때
				if(inData==-1) break;
				System.out.println((char)inData);
			}
			*/
			
			
			/*read(byte[])*/
			
			byte data[] = new byte[10];
			int cnt = in.read(data);
			System.out.println("cnt->"+cnt);
			System.out.println("text->"+new String(data, 0,cnt));
			
		} catch(IOException e) {
			System.out.println("입력에러 발생함");
		}
		
	}
	public static void main(String[] args) {
		new InputStreamTest().start();

	}

}
