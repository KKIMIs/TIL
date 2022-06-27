package java_report_book;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class BookDataset {
	//도서 정보 -> ArrayList (순서유지, 중복허용) 
	//=> 중복 제거 프로세스 추가
	public static ArrayList<BookVO> bookList = new ArrayList<BookVO>();
	
	
	public BookDataset() {
		
	}

	public static void setBookList() { //도서리스트 파일 세팅
		try {
			File f = new File("/Users/karlakim/dev/testfolder","bookList.txt");
			
			if(f.exists()) { //파일 존재 시 -> 불러오기
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				bookList = (ArrayList<BookVO>)ois.readObject();
				
				fis.close();
				ois.close();
			}
			
		} catch (Exception e) {
			System.out.println(" ".repeat(3)+"*".repeat(31)+" ".repeat(3)+"도서 리스트 로딩 실패"+" ".repeat(3)+"*".repeat(31));
			e.printStackTrace();
		
		}	
	}
	
}


//도서코드를 이용한 정렬을 하는 Comparator 클래스

class BookCodeComparator implements Comparator<BookVO> {    
	@Override
	public int compare(BookVO o1, BookVO o2) {
		
		if (o1.getBookCode() > o2.getBookCode()) {            
			return 1;        
		} else if (o1.getBookCode() < o2.getBookCode()) {            
			return -1;        
			}  
		return 0;
	}
}







