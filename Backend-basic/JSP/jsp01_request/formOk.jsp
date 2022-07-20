<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>
<%
	//post 방식의 전송일 때 post 데이터 encoding 처리 
	//out.print(request.getCharacterEncoding()+"<br/>");
	request.setCharacterEncoding("UTF-8");
	
	String userid = request.getParameter("userid");
	String userpwd = request.getParameter("userpwd");
	String username = request.getParameter("username");
	String state = request.getParameter("state");
	//하나의 변수에 값이 여러 개일 때
	String[] hobby = request.getParameterValues("hobby");
	
	//전화번호
	String tel1[] = request.getParameterValues("tel1");
	String tel2 =  request.getParameter("tel2");
	String tel3 =  request.getParameter("tel3");
	
	
	String num =  request.getParameter("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
아이디 : <%=userid %> <br />
비밀번호 : <%=userpwd %> <br />
이름 : <%=username %> <br />
동의여부 : <%=state %> <br />
취미 : <%=Arrays.toString(hobby)%> <br />
연락처 : <%=Arrays.toString(tel1) + '-' +tel2 +'-' +tel3%><br />
번호 : <%=num %> <br />
<%
	System.out.println(username);
	//System.out.println(Arrays.toString(hobby);
%>
<hr />
<ul>
<%
	//폼의 name 들을 구한다.
	Enumeration<String> nameList = request.getParameterNames();
	while(nameList.hasMoreElements()){
		%>
		<li><%=nameList.nextElement() %></li>
		<% 
	}

%>

</ul>
<ol>
	<li>접속자 컴퓨터 ip : <%=request.getRemoteAddr() %> </li>
	<li>접속자 컴퓨터 ip : <%=request.getCharacterEncoding() %></li>
	<li>contentType : <%=request.getContentType() %></li>
	<li>전송방식  : <%=request.getMethod() %></li>
	<li>protocol  : <%=request.getProtocol() %></li>
	<li>URI  : <%=request.getRequestURI() %></li>
	<li>ContextPath  : <%=request.getContextPath() %></li>
	<li>서버  :<%=request.getServerName() %></li>
	<li>포트  :<%=request.getServerPort() %></li>
	<li>절대주소  :<%=request.getServletContext().getRealPath("/") %></li>

</ol>
</body>
</html>