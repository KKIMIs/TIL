<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


<c:redirect url="/jsp02_response/login.jsp">
	<c:param name="username">홍길동</c:param>
	<c:param name="tel" value="010-1123-3244"></c:param>
</c:redirect>