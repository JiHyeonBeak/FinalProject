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
<script type="text/javascript">


function fn_addco(){
	fm.submit();
}

</script>
</head>
<body>
	<form action="${contextPath }/club/addComment" method="post" name="fm">
	<h1>오늘의 이야기...</h1>
	<table>
	<tr><td><input type="text" name="article_title"/></td></tr>
	<tr><td><textarea rows="8" cols="50" name="article_content"></textarea></td></tr>
	<tr><td><input type="button" value="입력" onclick="fn_addco()"></td></tr>
	</table>
	</form>
	
	<form action="${contextPath }/club/listComment" method="post" name="fm2">
	<table>
	<c:forEach var="com" items="${commentList}">
	<tr><td>번호 : ${com.article_no }</td></tr>
	<tr><td>제목 : ${com.article_title }</td></tr>
	<tr><td>내용 : ${com.article_content }</td></tr>
	</c:forEach>
	</table>
	
	</form>
</body>
</html>