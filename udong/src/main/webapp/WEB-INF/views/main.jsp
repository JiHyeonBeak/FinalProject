<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>메인 페이지</title>
  <link rel='stylesheet' href='./resources/font/font.css'>
  <style type="text/css">
	* {
		background-color: #90d0f0;
	}
	#intro{
		width:500px;
		height:500px;
		border:4px solid #ffffff;
		position: relative;
		top:100px;
		left:500px;
		animation-name: pp;
  		animation-duration:3s;
	}
	p{
		color:#ffffff;
		position: relative;
		top:50px;
		font-size: 20px;
	}
	h1{
		color:#ffffff;
		position: relative;
		top:70px;
		font-size: 50px;
	}
	input {
		position: relative;
		top:150px;
		width:150px;
		height:80px;
		color:white;
		font-size:30px;
		border:7px solid #ffffff;
		border-radius: 30px;
		margin: 15px
	}
	
	@keyframes pp {
		from {opacity:0;}
		to {opacity:1;}
	}
}

  </style>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
 function fn_start(){
	 fm.removeAttribute("action");
	 fm.setAttribute("action", "${contextPath}/udong/login");
     fm.submit(); 
 }
 function fn_join(){
	 fm.removeAttribute("action");
	 fm.setAttribute("action", "${contextPath}/udong/join");
     fm.submit();
 }
</script>
</head>
<body>
	<div id="intro">
	<p>이웃사촌 네트워크 만들기 프로젝트</p>
    <h1>우리동네 동아리</h1>
    <form method="get" name="fm">
    <input type="button" value="로그인" onclick="fn_start()"><input type="button" onclick="fn_join()" value="함께하기">
    </form>
   </div>
</body>
</html>