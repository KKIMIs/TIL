package basic06_io;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public RandomAccessFileTest() {
		// TODO Auto-generated constructor stub
	}
	public void start() {
		try {
			//RandomAccessFiles: 비순차적 입출력
			//mode : w-> 쓰기전용, r-> 읽기 전용, rw-> 둘 다
			File f = new File("/Users/karlakim/dev/random.txt");
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			
			String str = "Java Random Access File Test...";
			raf.writeChars(str);
			
			int dataInt = 123;
			raf.writeInt(dataInt);
			
			double dataDouble = 89.22;
			raf.writeDouble(dataDouble);
			
			
			/////////////////////////////
			String txt = "자바프로그래밍";
			//위치를 쓸 곳으로 이동
			raf.seek(5);
			raf.writeChars(txt);
			
			//읽기
			
			raf.seek(10);
			byte[] data = new byte[10];
			int cnt = raf.read(data,0,data.length);
			System.out.println("->"+new String(data));
			
			
			
			
			
			raf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	}
	public static void main(String[] args) {
		new RandomAccessFileTest().start();
	}

}
