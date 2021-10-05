<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정창</title>
<script type="text/javascript">
function fn_ok(){
	fm.submit();
}

function fn_del(){
	fm.action = "${contextPath}/member/removeMember";
	fm.submit();
}

</script>
<style>
   .text_center{
     text-align:center;
   }
</style>
</head>
<body>
	<form method="post" action="${contextPath}/member/modMember" name="fm">
	<h1  class="text_center">회원 정보 수정창</h1>
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">아이디</td>
	      <td width="400"><input type="text" name="id"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">비밀번호</td>
	      <td width="400"><input type="password" name="pwd"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">주소</td>
	       <td width="400"><p><input type="text" name="address"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이메일</td>
	       <td width="400"><p><input type="text" name="email"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">핸드폰 번호</td>
	       <td width="400"><p><input type="text" name="ph"></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="button" onclick="fn_ok()" value="수정하기"><input type="button" onclick="fn_del()" value="회원탈퇴"></td>
	    </tr>
	</table>
	</form>
</body>
</html>