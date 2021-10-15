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
<link rel='stylesheet' href='../resources/font/font.css'>
<style>

   #subm {
		border : 0px;
		border-radius: 22px;
		background-color: #73a1eb;
		width: 100px;
		height:50px;
		font-size: 20px;
		color: #ffffff;
		position: relative;
		right:130px;
		top:10px;
		margin-bottom:70px;
	}
	
	textarea{
		resize:none;
		border: 3px solid #73a1eb;
		border-radius:12px;
	}
   
   	input,select {
		margin-top:5px;
		border: 3px solid #73a1eb;
		border-radius:12px;
	}
	
</style>
<script type="text/javascript">
</script>
</head>
<body>
	<form method="post" action="${contextPath}/club/addClub">
	<h1>모임 개설</h1>
	<table align="center">
		<tr>
			<td width="200"><p align="right">모임 이름</td>
	      	<td width="400"><input type="text" name="group_name"></td>
		</tr>
		<tr>
			<td width="200"><p align="right">모임장</td>
	      	<td width="400">${member.id}</td>
		</tr>
		<tr>
			<td width="200"><p align="right">모임 소개</td>
	      	<td width="400"><textarea cols="18" rows="4" name="group_info" required></textarea></td>
		</tr>
		<tr><td width="200"><p align="right">일정</td><td><input type="date" name="group_date"></td></tr>
		<tr>
			<td width="200"><p align="right">카테고리</td>
	      	<td width="400"><select name="group_category">
	      	<option value="언어/문화">언어/문화</option>
	      	<option value="스포츠">스포츠</option>
	      	<option value="친목">친목</option>
	      	<option value="여행">여행</option>
	      	<option value="게임">게임</option>
	      	</select></td>
		</tr>
		<tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="만들기" id="subm"></td>
	    </tr>
	</table>
	</form>
</body>
</html>