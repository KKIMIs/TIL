<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container{
		width:80%;
		margin: 0 auto; 
	}

	.container>img{
		width:100%;
	}
	#top{
		height:50px;
		background-color: olive;
		border-radius: 5px;
		text-align: center;
		color:#ededed;
	}
	#buttom{
		height: 40px; 
		background-color: #dacd8d;
		text-align: center;
		border-radius: 5px;
		color:#ededed;
	}
</style>
</head>
<body>
	<!-- top.jsp include -->
	<jsp:include page="top.jsp"></jsp:include>
	<div class="container">
		<img src="../img/tc4.jpg" alt="" />
		<%
			// jsp의 include는 변수를 호환하지 않는다.
			//out.print(name);
		
		%>
	</div>
	<!-- buttom.jsp include -->
	<jsp:include page="buttom.jsp"></jsp:include>
</body>
</html>