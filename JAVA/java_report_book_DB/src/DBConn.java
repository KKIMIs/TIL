
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {

	// 드라이버 로딩
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 변수
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = null;
	final String URL = "jdbc:mysql://@127.0.0.1/multi";
	final String DB_ID = "root";
	final String DB_PWD = "root1234";
	
	
	// DB 연결
	protected void getConn() {
		try {
			conn = DriverManager.getConnection(URL,DB_ID, DB_PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// DB 닫기
	protected void getClose() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
