<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<% request.setCharacterEncoding("UTF-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아리 메인</title>
</head>
<body>
	<form action="${contextPath }/club/addBoard" method="post">
	<h1>오늘의 이야기...</h1>
	<table>
	<tr><td><textarea rows="3" cols="3"></textarea></td></tr>
	
	</table>
	</form>
</body>
</html>