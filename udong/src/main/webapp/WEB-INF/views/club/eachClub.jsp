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
<title>각 클럽 게시판</title>
</head>
<body>
	
	<table>
	<c:forEach var="board" items="${boardList }">
	<tr><td><input type="button" value="삭제"  onclick="#"></td></tr>
	<tr><td>제목 : ${board.articleTitle }</td><td> ${board.articeDate }</td></tr>
	<tr><td>작성자 : ${board.articleId }</td></tr>
	<tr><td>내용 : ${board.articleContent }</td></tr>
	</c:forEach>
	</table>
	
</body>
</html>