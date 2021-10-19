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
<link rel='stylesheet' href='../resources/font/font.css'>
<style>
	textarea{
		resize: none;
		border: 2px solid #17c2e8;
		border-radius: 12px;
	}
	#add {
		margin-bottom: 50px;
	}
	#line{
		border:1px solid #033894;
		margin: 30px;
	}
	#addbtn{
		color:#000000;
		font-size:30px;
		width:100px;
		height:100px;
		background-color: #ffffff;
		border: 5px solid #17c2e8;
		border-radius: 12px;
	}
	#intp{
		font-size:20px;
	}
	#in{
		padding:10px;
	}
	
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<center><h1>${groupName} 모임의 장</h1></center>
	<center><form action="${contextPath }/club/addBoard" method="post" name="fm">
	<table id="add">
	<input type="hidden" value=${groupId} name="groupId">
	<tr><td id="intp"><b>제목 &nbsp;</b></td>&nbsp;<td><textarea rows="1" cols="100" name="articleTitle"></textarea><td rowspan="2"><input type="submit" value="입력" id="addbtn"></td></tr>
	<tr><td id="intp"><b>내용 &nbsp;</td>&nbsp;<td><textarea rows="4" cols="100" name="articleContent"></textarea></tr>
	</table>
	</form>
	
	<table>
	<tr><td id="line"> </td></tr>
	<c:forEach var="board" items="${boardList }">
	<tr><td width="300" id="in"><b>${board.articleTitle }</b></td><td>작성자 :<b>${board.articleId }</b>&nbsp;</td><td> ${board.articleDate }</td></tr>
	<tr><td width="500" id="in">${board.articleContent }</td></tr>
	<tr><td width="700" id="line"> </td></tr>
	</c:forEach>
	</table></center>
	
</body>
</html>