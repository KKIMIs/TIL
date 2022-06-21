package basic06_io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileTest {

	public FileTest() {
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		//드라이브, 폴더, 파일에 관련한 정보를 사용하기 위해서는 File객체를 생성하여야 한다. 
		
		/*
		 File(File parent, String child)
		 File(String parent, String child)
		 File(String pathname)
		 */
		
		
		File f1 = new File("/Users/karlakim");
		File f2 = new File("/Users/karlakim/dev2/student");
		File f3 = new File("/Users/karlakim/dev/filetest.rtf");
		
		File f4 = new File(f2, "filetest.rtf");
		//File f5 = new File("/Users/karlakim/dev", "filetest.rtf");

		
		//경로 또는 파일 존재 유무
		
		System.out.println(f2.exists());
		System.out.println(f3.exists());
		
		//폴더 생성
		if(!f2.exists()) {
			if(f2.mkdirs()){//mkdir() mkdirs() :	부모폴더 생성
				System.out.println("폴더가 생성되었습니다.");
				
			}else {
				System.out.println("폴더생성 실패");
			}
		}
		//파일 생성
		try {
			if(!f4.exists()) {
				if(f4.createNewFile()) { //생성 -> true, 실패 -> false
					System.out.println("파일 생성되었습니다.");
				}else {
					System.out.println("폴더생성 실패");
				}
			}
			
			//마지막 수정날짜
			long lastDate = f3.lastModified();
			Calendar date = Calendar.getInstance()
;
			date.setTimeInMillis(lastDate);
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
			String lastDateStr = fmt.format(lastDate);
;			System.out.println("마지막 수정일->"+lastDateStr);
			
			// 특정 드라이브에 있는 폴더와 파일 목록 구하기
			File[] files = f1.listFiles();
			// getName() : 파일명
			// getParent() : 드라이브명+폴더
			// getPath(),getAbsolutePath()  : 드라이브명+폴더+파일명
			
			for(File f : files) {
				if(f.isDirectory()) {  //디렉토리인지 확인
					if(f.isHidden()) {
						System.out.println(f.getPath()+"[숨김폴더]");
					}else {
						System.out.println(f.getPath()+"[폴더]");
					}
					
				}else if(f.isFile()) { //파일인지 확인
					if(f.isHidden()) {
						System.out.println(f.getPath()+"[숨김파일]");
					}else {
						System.out.println(f.getPath()+"[파일]");
					}
				}
			}

			
			System.out.println("------------------------------------");
			//드라이브 목록
			File drive[] = File.listRoots();
			for (File f : drive) {
				System.out.println(f.getPath());
			}
			
			//파일의 크기 (byte)
			long fileSize = f3.length();
			System.out.println("fileSize=>"+fileSize);
			
			//파일 삭제
			boolean boo = f3.delete();
			System.out.println(boo);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public static void main(String[] args) {
		new FileTest().start();

	}

}
