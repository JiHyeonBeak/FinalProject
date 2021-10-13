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
<script type="text/javascript">
function fn_delco(articleNo){
	 var form = document.createElement("form");
	 form.removeAttribute("method");
	 form.setAttribute("method", "post");
	 form.setAttribute("action", "${contextPath}/club/delComment");
    var articleNOInput = document.createElement("input");
    articleNOInput.setAttribute("type","hidden");
    articleNOInput.setAttribute("name","articleNo");
    articleNOInput.setAttribute("value", articleNo);
	 
    form.appendChild(articleNOInput);
    document.body.appendChild(form);
    form.submit();
}

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
	      	<td width="400"><textarea placeholder="내용" name="group_info" required></textarea></td>
		</tr>
		<tr><td width="200"><p align="right">일정</td><td><input type="date" name="group_date"></td></tr>
		<tr>
			<td width="200"><p align="right">카테고리</td>
	      	<td width="400"><select name="group_category">
	      	<option value="culture">언어/문화</option>
	      	<option value="sports">스포츠</option>
	      	<option value="social">친목</option>
	      	<option value="trip">여행</option>
	      	<option value="game">게임</option>
	      	</select></td>
		</tr>
		<tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="만들기"></td>
	    </tr>
	</table>
	</form>
</body>
</html>