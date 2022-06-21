package basic06_io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamTest {

	public DataInputOutputStreamTest() {
		// TODO Auto-generated constructor stub
	}
	public void start() {
		//원래 데이터형으로 파일로 읽고 쓰기
		try {
			int dataInt = 234353;
			double dataDouble = 1231.23;
			boolean dataBoolean = true;
			char dataChar = 'z'; 
			
			File f = new File("/Users/karlakim/dev/data.txt");
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
			dos.writeInt(dataInt); // 4byte 
			dos.writeDouble(dataDouble); //8
			dos.writeBoolean(dataBoolean); //1
			dos.writeChar(dataChar); // 1(eng), 2(kor)
			System.out.println("데이터 형으로 파일쓰기가 완료되었습니다.");
			
			
			//데이터형으로 저장된 데이터 읽어오기
			DataInputStream dis = new DataInputStream(new FileInputStream(f));
			int readInt = dis.readInt();
			double readDouble = dis.readDouble();
			boolean readBoolean = dis.readBoolean();
			char readChar = dis.readChar();
				
			System.out.println("int->"+readInt);
			System.out.println("double->"+readDouble);
			System.out.println("boolean->"+readBoolean);
			System.out.println("char->"+readChar);
			
			dis.close();
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) {
		new DataInputOutputStreamTest().start();
	}

}
