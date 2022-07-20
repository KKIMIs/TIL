<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>에러 발생 시 실행될 페이지</h1>
	<h2>에러메세지 : 
		<%
			out.print(exception.getMessage());    
		%>
	</h2>
	<a href="/webJSP/index.jsp">
		<img src="../img/error-page.png" alt="에러" />
	</a>
</body>
</html>