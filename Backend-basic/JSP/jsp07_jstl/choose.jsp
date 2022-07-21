<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<c:set var="name" value="${param.name }" />
<c:set var="age" value="${param.age }" />

<c:choose>
	<c:when test="${name=='hong' }">
		당신의 이름은 ${name }입니다.
	</c:when>
	<c:when test="${age>20 }">
		당신은 20세 이상입니다.
	</c:when>
	<c:otherwise>
		당신의 이름은 hong도 아니고 나이가 20세 이상도 아닙니다.
	</c:otherwise>
</c:choose>