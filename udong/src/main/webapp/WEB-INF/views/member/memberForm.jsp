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
   
   #subm {
		border : 0px;
		border-radius: 22px;
		background-color: #73a1eb;
		width: 100px;
		height:50px;
		font-size: 20px;
		color: #ffffff;
		position: relative;
		right:100px;
		top:10px;
		margin-bottom:70px;
	}
   
   	input {
		margin-top:5px;
		border: 3px solid #73a1eb;
		border-radius:20px;
	}
	
</style>
</head>
<body>
	<form method="post" action="${contextPath}/member/addMember">
	<h1  class="text_center">회원 가입</h1>
	<table  align="center">
	   <tr>
	      <td width="100"><p align="right">아이디</td>
	      <td width="200"><input type="text" name="id"></td>
	   </tr>
	   <tr>
	      <td width="100"><p align="right">비밀번호</td>
	      <td width="200"><input type="password" name="pwd"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="200"><p><input type="text" name="name"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">주소</td>
	       <td width="200"><p><input type="text" name="address"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">핸드폰번호</td>
	       <td width="200"><p><input type="text" name="ph"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이메일</td>
	       <td width="300"><p><input type="text" name="email"></td>
	    </tr>
	    <tr>
	       <td width ="150"><p>&nbsp;</p></td>
	       <td width="200"><input type="submit" value="가입하기" id='subm'></td>
	    </tr>
	</table>
	</form>
</body>
