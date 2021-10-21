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
     color: white;
   }
   body {
   	background-color: #90d0f0;
   }
   	#memfm {
		width:550px;
		height:550px;
		border:4px solid #ffffff;
		position: relative;
		top:100px;
		left:500px;
	}
   
   #subm {
		border : 0px;
		border-radius: 22px;
		background-color: #ffffff;
		width: 80px;
		height:40px;
		font-size: 12px;
		font-weight:800;
		color: #5a8de6;
		position: relative;
		right:60px;
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
	<form method="post" action="${contextPath}/member/addMember" name="fm">
	<h1  class="text_center">회원 가입</h1>
	<table  align="center">
	   <tr>
	      <td width="100"><p align="right">아이디</td>
	      <td width="200"><input type="text" name="id" id="user_id"></td>
	   </tr>
	   <tr>
	      <td width="100"><p align="right">비밀번호</td>
	      <td width="200"><input type="password" name="pwd" id="user_pwd"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="200"><p><input type="text" name="name" id="name"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">주소</td>
	       <td width="200"><p><input type="text" name="address" id="address"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">핸드폰번호</td>
	       <td width="200"><p><input type="text" name="ph" id="ph"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이메일</td>
	       <td width="300"><p><input type="text" name="email" id="email"></td>
	    </tr>
	    <tr>
	       <td width ="150"><p>&nbsp;</p></td>
	       <td width="200"><input type="submit" value="가입하기" id='subm'></td>
	    </tr>
	</table>
	</form>
</body>


