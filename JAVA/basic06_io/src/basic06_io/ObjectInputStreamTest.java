package basic06_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Calendar;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void start() {
		try {
			//파일에 저장된 객체 입력하기
			File file = new File("/Users/karlakim/dev/object.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Calendar date = (Calendar)ois.readObject();
			MemberVO vo = (MemberVO)ois.readObject();
			
			
			//System.out.println("check");
			System.out.println(date);
			System.out.println(vo.toString());
			

			ois.close();
			fis.close();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ObjectInputStreamTest().start();

	}

}
