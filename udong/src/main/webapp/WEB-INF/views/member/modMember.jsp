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

function fn_mod(id){
	fm.removeAttribute("method");
	fm.setAttribute("action", "${contextPath}/member/modMember");
    var idMod = document.createElement("input");
    idMod.setAttribute("type","hidden");
    idMod.setAttribute("name","id");
    idMod.setAttribute("value",id);
	 
    fm.appendChild(idMod);
    document.body.appendChild(fm);
    fm.submit();
}

function fn_del(id){
	fm.removeAttribute("method");
	fm.setAttribute("action", "${contextPath}/member/removeMember");
    var idDel = document.createElement("input");
    idDel.setAttribute("type","hidden");
    idDel.setAttribute("name","id");
    idDel.setAttribute("value", id);
	 
    fm.appendChild(idDel);
    document.body.appendChild(fm);
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
	<form method="post" action="${contextPath}/modInfo" name="fm">
	<h1  class="text_center">회원 정보 수정창</h1>
	<table  align="center">
		<tr>
	      <td width="200"><p align="right">아이디</td>
	      <td width="400"><p align="right">${memberVO.id}</td>
	    </tr>
	   <tr>
	      <td width="200"><p align="right">비밀번호</td>
	      <td width="400"><input type="password" name="pwd"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">주소</td>
	       <td width="400"><p><input type="text" name="address" value="${memberVO.address}"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이메일</td>
	       <td width="400"><p><input type="text" name="email" value="${memberVO.email}"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">핸드폰 번호</td>
	       <td width="400"><p><input type="text" name="ph" value="${memberVO.ph}"></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="button" onclick="fn_mod('${id}')" value="수정하기">
	       <input type="button" onclick="fn_del('${id}')" value="회원탈퇴"></td>
	    </tr>
	</table>
	</form>
</body>
</html>