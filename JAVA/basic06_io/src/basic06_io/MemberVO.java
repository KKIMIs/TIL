package basic06_io;

import java.io.Serializable;

//파일로 객체를 저장하기 위해서는 저장할 클래스를 직렬화해야한다.
//interface Seraliziable


public class MemberVO implements Serializable { //MemberDTO
	//사원번호 사원명 부서명 연락처
	private int num;		//0
	private	String username;//null
	private	String department;
	private	String tel;
	
	
	public MemberVO() {
		
	}
	
	public MemberVO(int num, String username, String department, String tel) {
		this.num = num;
		this.username = username;
		this.department = department;
		this.tel  = tel;  
	}
	
	
	//Getter, Setter
	//외부클래스에서 접근을 허용하는 메소드 생성하기
	
	@Override
	public String toString() {
		return num + "\t" + username + "\t" + department + "\t" + tel;
	}

	//Setter
	public void setNum(int num) {
		this.num = num;
	}
	
	//Getter
	public int getNum () {
		return num;
	}
	
	public void setUsername(String username) {
		this.username = username;		
	}
	
	public String getUsername() {
		return username;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	
	

}
