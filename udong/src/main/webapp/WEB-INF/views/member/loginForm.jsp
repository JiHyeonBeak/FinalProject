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
<style>
	#login{
		padding : 15px;
		margin: 5px;
	}
	#fm {
		border: 1px solid #73a1eb;
		width:500px;
		height:500px;
	}
	table {
		padding: 30px;
	}
	tr {
		position: relative;
		top: 30px;
	}
	h1 {
		color: #73a1eb;
	}
	
	#loginbtn {
		border : 0px;
		border-radius: 12px;
		background-color: #73a1eb;
		width: 100px;
		height:50px;
		font-size: 20px;
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
<center><form name="frmLogin" method="post"  action="${contextPath}/member/login">
	<div align="center" id="fm">
	<h1> Log In </h1>
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
</form></center>
</body>
</html>
