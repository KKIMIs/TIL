<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션에 데이터 기록하기</h1>
	<a href="/webJSP/index.jsp">홈</a>
	
	<%
		session.setAttribute("logId", "goguma");
		session.setAttribute("logStatus", "Y");
		session.setAttribute("logName", "고구마");
	%>
</body>
</html>