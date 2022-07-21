<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<h1>if 	태그 : 조건문</h1>
<c:set var="n" value="${10}" />
<c:set var="x" value="${5}" />


<!-- >,<,>=,<=,!=,== -->

<c:if test="${n>x}">
	참일 때 실행된다.....
</c:if>

<c:if test="${n<x}">
	참일 때 실행된다~~~~
</c:if>

<c:if test="${true}">
	무조건 참이다...
	<img src ="../img/tc8.jpg" width="100"/><br />
</c:if>

<h1>jstl에서 request 하기, request.geParameter("name")  ->param.name</h1>

<c:set var="name" value="${param.name }"/>
<c:set var="age" value="${param.age }"/>
<c:set var="tel" value="${param.tel}"/>
<!-- ?????????  -->
이름 : ${name} <br />
나이 : ${age} <br />
연락처 : ${tel} <br />
