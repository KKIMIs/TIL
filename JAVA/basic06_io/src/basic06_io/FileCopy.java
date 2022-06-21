package basic06_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public FileCopy() {
		
	}
	public void start() {
		///Users/karlakim/eclipse-workspace/Assignment/src/GuGuDan.java
		///Users/karlakim/dev
		
		File orgFile = new File("/Users/karlakim/eclipse-workspace/Assignment/src/GuGuDan.java");
		File tarFile = new File("/Users/karlakim/dev/GuGuDan.java");
		
		//바이트 수만큼 한번에 orgFile파일의 내용을 읽고 tarFile로 쓰기를 함
		try {
			FileInputStream fis = new FileInputStream(orgFile);
			FileOutputStream fos = new FileOutputStream(tarFile);
			
			//파일의 내용을 읽어서 저장할 배열ㄹ
			
			byte[] sourceCode = new byte[(int)orgFile.length()];
			
			//읽어온 바이트 수를 리턴해준다
			int cnt = fis.read(sourceCode);
			
			//쓰기
			fos.write(sourceCode, 0, cnt);
			
			fis.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다 ->"+e.getMessage());
		} catch (IOException e) {
			System.out.println("입출력 예외 발생 ->"+e.getMessage());
		}
		System.out.println(orgFile.getPath()+"의 내용을 "+tarFile.getPath()+"의 경로로 복사하였습니다.");
		
		
	}
	
	public static void main(String[] args) {
		new FileCopy().start();

	}

}
