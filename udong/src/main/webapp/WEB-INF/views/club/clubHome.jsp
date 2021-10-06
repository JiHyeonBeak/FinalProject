<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<% request.setCharacterEncoding("UTF-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동아리 활동</title>
<script type="text/javascript">
function fn_join(url,group_name){
	fm.method = "post";
	fm.action = url;
	var number = document.createElement("input");
	number.setAttribute("name","group_name");
	number.setAttribute("type","hidden");
	number.setAttribute("group_name",group_name);
	fm.appendChild(number);
	fm.submit();
}
</script>
</head>
<body>
<h2>가입 가능 동아리</h2>
	<form action="${contextPath }/club/listClub" method="post" name="fm">
	<table>
	<c:forEach var="club" items="${clubList}">
	<tr><td>동아리 이름 : </td><td><a onclick="fn_join('${contextPath}/club/join',${club.group_name})">${club.group_name }</a></td></tr>	
	<tr><td>카테고리 : ${club.group_category }</td></tr>
	<tr><td>동아리 소개 : ${club.group_info }</td></tr>
	</c:forEach>
	</table>
	</form>
<h2>가입 동아리</h2>
</body>
</html>