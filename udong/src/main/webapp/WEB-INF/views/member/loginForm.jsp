<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%>     
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
<title>로그인창</title>
<link rel='stylesheet' href='../resources/font/font.css'>
<style>
	#fm{
		position: relative;
		top:140px;
	}
	#login{
		padding : 15px;
		margin: 5px;
	}
	table {
		padding: 20px;
	}
	tr {
		position: relative;
	}
	td{
		font-size: 20px;
	}
	h1{
		color:#73a1eb;
		font-size:50px;
		font-weight: 5000;
	}
	h4{
		color:#73a1eb;
		font-size:30px;
		font-weight: 5000;
		animation-name: h4;
  		animation-duration:5s;
	}
	#loginbtn {
		border : 0px;
		border-radius: 12px;
		background-color: #73a1eb;
		width: 180px;
		height:40px;
		font-size: 20px;
		font-weight:300;
		margin-top: 20px;
		margin-bottom:100px;
		color: #ffffff;
	}
	
	input {
		margin-top:5px;
		width:150px;
		height:20px;
		resize:none;
		border: 3px solid #73a1eb;
		border-radius:20px;
	}
	@keyframes h4 {
	0%{
		opacity:0%;
	}
	50% {
		opacity:50%;
		color: #a0d5f2;
	}
	100%{
		opacity:100%;
	}
	}

</style>
<c:choose>
	<c:when test="${result=='loginFailed' }">
	  <script>
	    window.onload=function(){
	      alert("아이디나 비밀번호가 틀립니다.다시 로그인 하세요!");
	    }
	  </script>
	</c:when>
</c:choose>  
</head>

<body>
<form name="frmLogin" method="post"  action="${contextPath}/member/login">
	<div align="center" id="fm">
	<h4>우 리 동 네 동 아 리</h4>
	<h1> 로그인 </h1>
   <table id="login" align="center" >
      <tr align="center">
         <td>아이디</td><td><input type="text" name="id" value="" size="20"></td>
      </tr>
      <tr align="center">
         <td>비밀번호</td><td><input type="password" name="pwd" value="" size="20"></td>
      </tr>
      <tr align="center">
         <td colspan="2"><input type="submit" value="로그인" id='loginbtn'></td> 
      </tr>
   </table>
   </div>
</form>
</body>
</html>
