<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<% request.setCharacterEncoding("UTF-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<link rel='stylesheet' href='../resources/font/font.css'>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<form method="post" action="${contextPath}/club/joinClub">
	<h1  class="text_center">동아리 가입</h1>
	<table  align="center">
	   <tr>
	      <td>
	    <form action="${contextPath }/club/detailClub" method="post" name="fm">
		<table>
		<c:forEach var="club" items="${clubList}">
		<tr><td>동아리 이름 : ${club.group_name }</td><td>
		<tr><td>카테고리 : ${club.group_category }</td></tr>
		<tr><td>동아리 소개 : ${club.group_info }</td></tr>
		</c:forEach>
		</table>
		</form>
	      </td>
	       <td width="400"><input type="submit" value="신청하기"></td>
	    </tr>
	</table>
	</form>
</body>
