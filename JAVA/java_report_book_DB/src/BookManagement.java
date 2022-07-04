

import java.util.List;
import java.util.Scanner;

public class BookManagement {
	Scanner sc = new Scanner(System.in);
	String menus[] = {"1:목록 보기", "2:정보 등록", "3:정보 수정", "4:정보삭제",
					"5:정보 검색","6:종료"};
	String infos[] = {"도서코드", "도서명", "저자명",  "출판사", "분류", "장르", "옮긴이"};
	BookDAO dao = new BookDAO();
	
	public BookManagement() {
	}
	
	
	
	////////////////////////////////  실행  ////////////////////////////////
	public void run() {
		/*
		 기능
	1)목록 보기 
		# 등록되어 있는 도서 목록 출력
		# 도서 코드 순으로 정렬되어 출력
	2)정보 등록
		# 도서코드/ 도서명/ 저자명/ 출판사/ 분류 코드/ 장르 코드/ 옮긴이 정보 입력
		# 입력된 정보를 도서 목록에 추가
		# 중복된 도서코드로는 정보 등록 불가
	3)정보 수정
		# 도서 코드를 입력받아
		# 도서명/ 저자명/ 출판사/ 분류 코드/ 장르 코드/ 옮긴이 정보 중 하나를 수정
		# 수정된 결과를 목록에서 업데이트
	4)정보 삭제
		# 도서 코드를 입력받아
		# 해당하는 도서 정보를 목록에서 삭제
	5)정보 검색
		5-1) 도서명 검색
			# 도서명을 입력받아
			# 해당하는 도서 목록을 출력
		5-2) 국/내외 검색
			# 국내외 분류 코드를 입력받아
			# 국내 또는 해외 도서 목록을 출력
		5-3) 장르 검색
			# 장르 분류 코드를 입력받아
			# 해당 장르의 도서 목록을 출력
	6)종료
		# 도서 목록 파일을 저장하고 프로그램 종료
		 */
	
		
		start();
		while(true) {
			try {
				printSpace();
				int menu = selectMenu();
				if (menu == 1) {
					System.out.println(">> 1: 목록 보기");
					showBook();
				} else if(menu ==2) {
					System.out.println(">> 2: 정보 등록");
					insertBook();
				} else if(menu == 3) {
					System.out.println(">> 3: 정보 수정");
					editBook();
				} else if(menu == 4) {
					System.out.println(">> 4: 정보 삭제");
					deleteBook();
				} else if(menu == 5) {
					System.out.println(">> 5: 정보 검색");
					searchBook();
				} else if(menu == 6) { //종료
					//종료 전 체크 
					int menu2 = askTerminating();
					if (menu2 == 1) {
						terminate();
					} else if (menu2 == 2) {
					} else {
						throw new Exception();
					}					
					
				}else {
					throw new Exception();
				}
				
			} catch (Exception e) {
				printWithStar("메뉴 입력 중 문제 발생");
				//e.printStackTrace();
			}	
		}
	}
	
	/////////////////////////////// 본 기능 구현 //////////////////////////////////
	
	
	//1. 목록 보기
	public void showBook() {
		String searchWord = null;
		List<BookVO> curList = dao.bookSelect(0, searchWord);
		printListTitle();
		for(BookVO bvo: curList) {
			printList(bvo.getDatas());
		}
	}
	
	//2. 정보 등록
	public void insertBook() {
		BookVO bvo = new BookVO();

		printSlash();
		printInputMessage("도서 코드 입력");
		int inCode = Integer.parseInt(sc.nextLine());
		if(!bookExist(inCode)) {

			bvo.setBookCode(inCode);

			printInputMessage("도서명 입력");
			bvo.setBookName(sc.nextLine());

			printInputMessage("저자명 입력");
			bvo.setWriterName(sc.nextLine());

			printInputMessage("출판사 입력");
			bvo.setPublisherName(sc.nextLine());


			printSort();
			printInputMessage("국내외 분류 입력");
			int sCode = Integer.parseInt(sc.nextLine());
			if (checkSortCode(sCode)) {
				bvo.setSortCode(sCode);
				printGenre();

				printInputMessage("장르코드 입력");
				int gCode = Integer.parseInt(sc.nextLine());
				if(checkGenreCode(gCode)) {
					bvo.setGenreCode(gCode);

					if (bvo.getSortCode() == 2 ) { //해외 도서 -> 옮긴이 정보 입력
						printInputMessage("옮긴이 입력");
						bvo.setTranslaterName(sc.nextLine());
					} 

					int result = dao.bookInsert(bvo);
					if (result>0) {
						printWithStar(bvo.getBookName()+" 등록 완료");
					} else {
						printWithStar("도서 등록 실패");
					}


				} 
			} 
		}else {
			printWithStar("도서 코드 중복");
		}




		
		
	}
	
	//3. 정보 수정
	public void editBook() {
		BookVO bvo = new BookVO();
		
		
		System.out.print(">> 수정할 도서 코드\t -----> ");
		int editCode = Integer.parseInt(sc.nextLine());
		if (bookExist(editCode)) {
			bvo.setBookCode(editCode);

			System.out.println("[1:도서명 | 2:저자명 | 3:출판사 | 4:국내외 분류 | 5:장르코드 | 6:옮긴이]");
			String type = "str"; 

			printInputMessage("수정할 항목");
			int editInfo = Integer.parseInt(sc.nextLine());

			if(editInfo == 1) {
				bvo.setCurField("bookName");
				printInputMessage("수정 도서명 입력");
				bvo.setBookName(sc.nextLine());

			} else if (editInfo == 2){
				bvo.setCurField("writerName");
				printInputMessage("수정 저자명 입력");
				//bvo.setWriterName(sc.nextLine());
				bvo.setBookName(sc.nextLine());

			} else if (editInfo == 3){
				bvo.setCurField("publisherName");
				printInputMessage("수정 출판사명 입력");
				//			bvo.setPublisherName(sc.nextLine());
				bvo.setBookName(sc.nextLine());


			} else if (editInfo == 4){
				printSort();
				bvo.setCurField("sortCode");
				printInputMessage("수정 국내외 분류 입력");
				int sCode = Integer.parseInt(sc.nextLine());
				if (checkSortCode(sCode)) {
					//				bvo.setSortCode(sCode);
					bvo.setGenreCode(sCode);
					type = "int";
				} 

			} else if (editInfo == 5){
				printGenre();
				bvo.setCurField("genreCode");
				printInputMessage("수정 장르 분류 입력");
				int gCode = Integer.parseInt(sc.nextLine());
				if(checkGenreCode(gCode)) {
					bvo.setGenreCode(gCode);
					type = "int";
				} 

			} else if (editInfo == 6){
				//국내도서는 옮긴이 데이터 변경 불가
				if (bvo.getSortCode()==2) {
					bvo.setCurField("translaterName");
					printInputMessage("수정 옮긴이 입력");
					//				bvo.setTranslaterName(sc.nextLine());
					bvo.setBookName(sc.nextLine());
				}else {
					printWithStar("해당 항목 변경 불가");

				}
			} else {
				printWithStar("존재하지 않는 수정항목");

			}

			int cnt = dao.bookUpdate(bvo, type); 
			if(cnt>0) {
				printWithStar(editCode+"번 도서 수정 완료!");
			} else {
				printWithStar("도서 정보 수정 실패");
			}
		} else {
			printWithStar("존재하지 않는 도서코드");
		}

}
	
	//4. 정보 삭제 
	public void deleteBook() {
		printInputMessage("삭제할 도서 코드");
		int delCode = Integer.parseInt(sc.nextLine());
		if (bookExist(delCode)) {
			int result = dao.bookDelete(delCode);

			if (result>0) {
				printWithStar(delCode + " 도서 삭제 완료");
			} else {
				printWithStar(delCode + " 도서 삭제 실패");
			}
		} else {
			printWithStar("존재하지 않는 도서코드");
		}
	}
	
	//5. 정보 검색 
	public void searchBook() {
		System.out.println("\t\t\t\t[ 1:도서명 검색| 2:국내/해외 도서 검색 | 3:장르별 검색 ]");
		printInputMessage("다음으로 검색");
		try {
			int searchMenu = Integer.parseInt(sc.nextLine());
			
			if (searchMenu ==1 ) {
				searchByName();
			} else if(searchMenu ==2) {
				searchBySortCode();
			} else if(searchMenu ==3) {
				searchByGenreCode();
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			printWithStar("유효하지 않은 입력");
		}
		
		

	}
	
	////////////////////////////////// 헬퍼 기능 ///////////////////////////////////



//	//2-1. 도서코드 중복 체크
	public boolean bookExist(int inCode) {
		//중복체크 
		List<BookVO> idx = dao.getIndex();
		for(BookVO v : idx) {
			if (v.getBookCode()==inCode) {
				return true;
			}
		} 
		return false;
	}

	//2-2. 국내외 분류코드 유효성 체크
	public boolean checkSortCode(int code) {
		try {
			if (code!=1 && code!=2) {
				throw new Exception();
			}
		} catch (Exception e) {
			printWithStar("유효하지 않은 코드");
			return false;
		}
		return true;
	}
	
	//2-3. 장르 코드 유효성 체크
	public boolean checkGenreCode(int code) {
		try {
			if (code!=1 && code!=2 && code!=3 && code!=4 && code!=5 && code!=6) {
				throw new Exception();
			}
		} catch (Exception e) {
			printWithStar("유효하지 않은 코드");
			return false;
		}
		return true;
	}

	//5-1. 도서명 검색
	public void searchByName() {
		printInputMessage("도서명 입력");
		String searchWord = sc.nextLine();
		List<BookVO> curList = dao.bookSelect(1, searchWord);
		
		if (curList.size()>0) {
			printListTitle();
			for(BookVO bvo: curList) {
				printList(bvo.getDatas());
			}
		} else {
			printWithStar("존재하지 않는 도서명!");
		}
		
	}
	
	//5-2. 국내외 분류 검색
	public void searchBySortCode() {
		printSort();
		printInputMessage("분류 코드 입력");
		String searchWord = sc.nextLine();
		if (checkSortCode(Integer.parseInt(searchWord))) {
			List<BookVO> curList = dao.bookSelect(2, searchWord);
			if (curList.size()>0) {
				printListTitle();
				for(BookVO bvo: curList) {
					printList(bvo.getDatas());
				}
			} else {
				printWithStar("해당 도서 없음!");
			}
		}
		 
		
	}	

	//5-3. 장르별 검색
	public void searchByGenreCode() {
		printGenre();
		printInputMessage("장르 코드 입력");
		String searchWord = sc.nextLine();
		
		if (checkGenreCode(Integer.parseInt(searchWord))) {
			List<BookVO> curList = dao.bookSelect(3, searchWord);
			if (curList.size()>0) {
				printListTitle();
				for(BookVO bvo: curList) {
					printList(bvo.getDatas());
				}
			} else {
				printWithStar("해당 도서 없음!");
			}
		}
	}
	////////////////////////////////// 기본 동작 ///////////////////////////////////
	
	// 프로그램 시작
	public void start() {
		printWithStar("START PROGRAM");
	}
	
	// 메뉴 선택 
	public int selectMenu() {
		System.out.println("\n>> 메뉴를 입력해주세요 ");
		printSlash();
		printMenu();
		int inMenu =Integer.parseInt(sc.nextLine());
		printSlash();
		printSpace();
		return inMenu;
	}
	
	// 종료 전 확인
	public int askTerminating() {
		System.out.println(">> 6: 종료하시겠습니까?"); 
		System.out.print("| 1: 종료   | 2:종료 취소 | >> ");
		int inMenu =Integer.parseInt(sc.nextLine());
		return inMenu;
	}
	
	// 프로그램 종료 
	public void terminate() {
		printWithStar("TERMINATE PROGRAM");
		System.exit(0);
	}
	
	
	////////////////////////////////////  출력  형식 /////////////////////////////////
	
	//입력값 받는 메세지 출력
	public void printInputMessage(String m) {
		System.out.print(">> ");
		System.out.printf(formatChar(m,25));
		System.out.print("  ---->> ");
	}
	
	//메뉴 출력
	public void printMenu() {
		System.out.print("|");
		for (String m: menus) {
			System.out.printf(" %-9s |",  m);
		}
		System.out.print("  ---->> ");
	}
	
	//도서목록명 출력
	public void printListTitle() {
		printSlash_long();
		
		System.out.print("|");
		for (int i =0; i<infos.length; i++) {
			switch (i) {
			case 0:
				System.out.printf(" "+formatChar(infos[i],8)+" |");
				break;
			case 1:	 //도서명
				System.out.printf(" "+formatChar(infos[i],25)+" |");
				break;
			case 2:	//작가명
			case 3:	//출판사명
				System.out.printf(" "+formatChar(infos[i],20)+" |");
				break;
			case 6:
				System.out.printf(" "+formatChar(infos[i],10)+" |");
				break;
			default:
				System.out.printf(" "+formatChar(infos[i],4)+" |");
				break;
			}
			
		}
		System.out.println();
		
		printSlash_long();
	}
	
	//도서목록 출력 
	public void printList(String[] datas) {
		System.out.print("|");
		for (int i =0; i<datas.length; i++) {
			switch (i) {
			case 0:
				System.out.printf(" "+formatChar(datas[i],8)+" |");
				break;
			case 1:	 //도서명
				System.out.printf(" "+formatChar(datas[i],25)+" |");
				break;
			case 2:	//작가명
			case 3:	//출판사명
				System.out.printf(" "+formatChar(datas[i],20)+" |");
				break;
			case 6:
				System.out.printf(" "+formatChar(datas[i],10)+" |");
				break;
			default:
				System.out.printf(" "+formatChar(datas[i],4)+" |");
				break;
			}
			
		}
		System.out.println();
		printSlash_long();
	}
	
	
	// 한글-공백 포메팅  
	//공백간격*2 = 한글 1자 
	public String formatChar(String input, int totalSpace) {
		//System.out.println(input);
		if(input  == null) {
			return " ".repeat(totalSpace);
		} else {
			String result ="";
			int countKor  = 0;
			int countInsideSpace = 0;
			for (int i = 0; i < input.length(); i++) {
				char check = input.charAt(i);
				// 영어, 숫자, '.' 는 공백과 동일 간격  
				if (String.valueOf(check).equals(" ") || String.valueOf(check).equals(".")) {
					countInsideSpace++;
				} else if(check >='A' && check <= 'Z' || check >= 'a' && check <= 'z' ){
					countInsideSpace++;
				} else if(Character.isDigit(check)) {
					countInsideSpace++;
				} else {
					countKor++;
				}
			}
			int repeatNum = ((totalSpace-countKor*2-countInsideSpace)>0)? totalSpace-countKor*2-countInsideSpace:0;
			result = input + " ".repeat(repeatNum);
			return result;
		}
	}
	
	
	public void printSlash() {
		System.out.println(" "+"-".repeat(93));
	}
	public void printSlash_long() {
		System.out.println(" "+"-".repeat(111));
	}
	public void printSpace() {
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	//옵션 출력
	public void printGenre() {
		System.out.println("\t\t\t\t[ 1:인문 | 2:역사 | 3:종교 | 4:예술 | 5:과학 | 6:공학 ]");
	}
	public void printSort() {
		System.out.println("\t\t\t\t[ 1:국내 | 2:해외 ]");
	}
	
	//오류&완료 메세지 출력
	public void printWithStar(String message) {
		System.out.printf("\n"+" ".repeat(3)+"*".repeat(31)+" ".repeat(3)+formatChar(message,16)+" ".repeat(3)+"*".repeat(31)+"\n");
		printSlash();
	}
	

	//////////////////////////////////  메인  ////////////////////////////////////
	public static void main(String[] args) {
		new BookManagement().run();
		

	}

}
