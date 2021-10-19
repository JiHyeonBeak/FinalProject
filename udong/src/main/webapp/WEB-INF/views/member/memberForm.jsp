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
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
var id = document.getElementById("id").value;
var pwd = document.getElementById("pwd").value;
var email = document.getElementById("email").value;
var ph = document.getElementById("ph").value;
var address = document.getElementById("address").value;
var name = document.getElementById("name").value;

function fn_join(){
	
	if(id == null || id === ''){
		alert(id);
		alert("아이디를 입력해주세요.");
	}else if(pwd == null || pwd ===''){
		alert("비밀번호를 입력해주세요.");
		pwd.focus();
	}else if(name == null || name ===''){
		alert("이름을 입력해주세요.");
		name.focus();
	}else if(address == null || address ===''){
		alert("주소를 입력해주세요.");
		address.focus();	
	}else if(ph == null || ph ===''){
		alert("핸드폰 번호를 입력해주세요.");
		ph.focus();
	}else if(email == null || email ===''){
		alert("이메일을 입력해주세요.");
		email.focus();
	}else{
		fm.submit();
	}
}
</script>
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
	      <td width="200"><input type="text" name="id" id="id"></td>
	   </tr>
	   <tr>
	      <td width="100"><p align="right">비밀번호</td>
	      <td width="200"><input type="password" name="pwd" id="pwd"></td>
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
	       <td width="200"><input type="button" onclick="fn_join()" value="가입하기" id='subm'></td>
	    </tr>
	</table>
	</form>
</body>
