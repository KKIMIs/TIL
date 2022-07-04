import java.util.ArrayList;
import java.util.List;


public class BookDAO extends DBConn {
	
	public BookDAO() {
		
	}
	
	public static BookDAO getInstance() {
		
		return new BookDAO(); 
		
	}
	
//	1)목록 보기 + 검색하기 
//	5-1) 도서명 검색
//5-2) 국/내외 검색
//5-3) 장르 검색

	public List<BookVO> bookSelect(int mn, String searchWord) {
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			getConn();
			
			sql = "select bookCode, bookName, writerName, publisherName, sortCode, "
					+ "genreCode, translaterName from books";
			
			//검색
			if (mn == 1) {
				sql += " where bookName like ?";
			} else if (mn == 2) {
				sql += " where sortCode like ?";
			} else if (mn == 3) {
				sql += " where genreCode like ?";
			}
		
			sql += " order by bookCode";
			pstmt  = conn.prepareStatement(sql);
			
			//검색 워드 찾기
			if (searchWord != null) {
				pstmt.setString(1,"%"+searchWord +"%");
			}
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//VO에 담기
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getInt(1));
				vo.setBookName(rs.getString(2));
				vo.setWriterName(rs.getString(3));
				vo.setPublisherName(rs.getString(4));
				vo.setSortCode(rs.getInt(5));
				vo.setGenreCode(rs.getInt(6));
				vo.setTranslaterName(rs.getString(7));
				
				//VO를 Arraylist에 담기 
				list.add(vo);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return list;	
	}
	
//	2)정보 등록 
	
	public int bookInsert(BookVO vo) {
		int result =0;
		try {
			getConn();
			sql = "insert into books(bookCode, bookName, writerName, publisherName, sortCode, genreCode, translaterName) "
					+ "values (?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBookCode());
			pstmt.setString(2, vo.getBookName());
			pstmt.setString(3, vo.getWriterName());
			pstmt.setString(4, vo.getPublisherName());
			pstmt.setInt(5, vo.getSortCode());
			pstmt.setInt(6, vo.getGenreCode());
			pstmt.setString(7, vo.getTranslaterName());
			

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
		
	}
	
//	3. 정보 수정
	public int bookUpdate(BookVO vo, String type) {
		int result = 0;
		try {
			getConn();
			sql = "update books set " + vo.getCurField() 
			+ " = ? where bookCode = ? ";
			
			pstmt = conn.prepareStatement(sql);
			if (type.equals("str")) {
				pstmt.setString(1, vo.getBookName());
			} else {
				pstmt.setInt(1, vo.getGenreCode());
			}
			
			pstmt.setInt(2,  vo.getBookCode());
			result = pstmt.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		return result;
	}

//	4. 정보 삭제
	public int bookDelete(int delCode) {
		int result = 0; 
		try {
			getConn();
			sql = "delete from books where bookCode = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, delCode);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;
	}
	
	//인덱스 호출
	public List<BookVO> getIndex(){
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			getConn();
			sql = "select bookCode from books";
			pstmt  = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getInt(1));
				list.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list; 
	}	
	
}
