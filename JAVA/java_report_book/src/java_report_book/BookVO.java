package java_report_book;

import java.io.Serializable;

public class BookVO extends Object implements Serializable  {
	/*
	 도서 정보 항목
	 1)도서코드/ 2)도서명/ 3)저자명/ 4)출판사/ 5)분류/ 6)장르 /7)옮긴이
	 # 도서코드: 1-10000 사이
	 # 분류: [1.국내/ 2.해외]
	 # 장르: [1.인문/ 2.역사/ 3.종교/ 4.예술/ 5.과학/ 6.공학ㄴ] 
	 # 옮긴이는 5)분류가 "해외" 일 경우에만 값 존재 
	 */
	
	private int bookCode;
	private String bookName;
	private String writerName;
	private String publisherName;
	private int sortCode;
	private int genreCode;
	private String translaterName = "_";
	
	//데이터를 출력 형식으로 넘겨주기
	public String[] getDatas() {
		String datas[] = {Integer.toString(bookCode), bookName, writerName, publisherName, 
				printSortCode(sortCode), printGenreCode(genreCode), printTranslater(translaterName)};
		return datas;
	}
	
	//코드-장르 
	public String printGenreCode(int genreCode) {
		//[1.인문/ 2.역사/ 3.종교/ 4.예술/ 5.과학/ 6.공학] 
		if(genreCode == 1) {
			return "인문";
		} else if (genreCode ==2){
			return "역사";
		} else if (genreCode ==3){
			return "종교";
		} else if (genreCode ==4){
			return "예술";
		} else if (genreCode ==5){
			return "과학";
		} else{
			return "공학";
		}
	}
	
	//코드-국내외 분류
	public String printSortCode(int sortCode) {
		if(sortCode == 1) {
			return "국내";
		} else{
			return "해외";
		}
	}
	
	public String printTranslater(String translaterName) {
		if(!translaterName.equals("_")) {
			return translaterName;
		} else{
			return " ";
		}
	}
	
	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getSortCode() {
		return sortCode;
	}

	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}

	public int getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}

	public String getTranslaterName() {
		return translaterName;
	}

	public void setTranslaterName(String translaterName) {
		this.translaterName = translaterName;
	}

	public BookVO() {
		// TODO Auto-generated constructor stub
	}

}
