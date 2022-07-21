<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>url 태그: url주소를 가지는 태그</h1>
	<c:url var="home" value="/index.jsp"/>
	<c:url var="login" value="/jsp02_response/login.jsp">
		<c:param name="userid" value="goguma777"/>
		<c:param name="userpwd" value="1234"  />
	</c:url>
	
	<a href="/webJSP/index.jsp">HOME</a>
	<a href="/webJSP/jsp02_response/login.jsp">LOGIN</a> <br />
	
	<a href="${home }">HOME</a>
	<a href="${login }">Login</a>
</body>
</html>