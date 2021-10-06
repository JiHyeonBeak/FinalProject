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
<title>동아리 개설</title>
</head>
<body>
	<form method="post" action="${contextPath}/club/addClub">
	<h1>동아리 개설</h1>
	<table align="center">
		<tr>
			<td width="200"><p align="right">동아리 이름</td>
	      	<td width="400"><input type="text" name="group_name"></td>
		</tr>
			<tr>
			<td width="200"><p align="right">동아리 소개</td>
	      	<td width="400"><textarea placeholder="내용" name="group_info" required></textarea></td>
		</tr>
		<tr>
			<td width="200"><p align="right">카테고리</td>
	      	<td width="400"><select name="group_category">
	      	<option value="culture">언어/문화</option>
	      	<option value="sports">스포츠</option>
	      	<option value="social">친목</option>
	      	<option value="trip">여행</option>
	      	<option value="game">게임</option>
	      	</select></td>
		</tr>
		<tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="만들기"><input type="button" value="홈으로"></td>
	    </tr>
	</table>
	</form>
</body>
</html>