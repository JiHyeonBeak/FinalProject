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

function fn_delco(url,articleNo){
	fm2.method = "post";
	fm2.action = url;
	var number = document.createElement("input");
	number.setAttribute("name","articleNo");
	number.setAttribute("type","hidden");
	number.setAttribute("articleNo",articleNo);
	fm2.appendChild(number);
	fm2.submit();
}

</script>
</head>
<body>
	<form action="${contextPath }/club/addComment" method="post" name="fm">
	<h1>오늘의 이야기...</h1>
	<table>
	<tr><td><textarea row="2" col="3" name="articleTitle"></textarea></tr>
	<tr><td><textarea row="2" col="3" name="articleContent"></textarea></tr>
	<tr><td><input type="button" value="입력" onclick="fn_addco()"></td></tr>
	</table>
	</form>
	
	<form action="${contextPath }/club/listComment" method="post" name="fm2">
	<table>
	<c:forEach var="com" items="${commentList}">
	<tr><td>번호 : ${com.articleNo }</td><td><input type="button" value="삭제"  onclick="fn_delco('${contextPath}/club/delComment',${com.articleNo})"></td></tr>
	<tr><td>제목 : ${com.articleTitle }</td></tr>
	<tr><td>내용 : ${com.articleContent }</td></tr>
	</c:forEach>
	</table>
	
	</form>
</body>
</html>