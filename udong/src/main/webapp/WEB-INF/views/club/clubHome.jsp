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
<link rel='stylesheet' href='../resources/font/font.css'>
<style>
	#grp {
		display: inline;
	}
</style>

<script type="text/javascript">
function fn_join(group_name,group_id){
	if(confirm(group_name+"에 참여하시겠습니까?")){
		fm.removeAttribute("action");
		fm.setAttribute("action", "${contextPath}/club/joinClub");
		var gid = document.createElement("input");
		gid.setAttribute("name","group_id");
		gid.setAttribute("type","hidden");
		gid.setAttribute("value",group_id);
		fm.appendChild(gid);
		fm.submit();
	}else{
		
	}
}
</script>
</head>
<body>
<h2>참여 가능 모임</h2>
	<form action="${contextPath }/club/listClub" method="post" name="fm">
	<table id="grp">
	<c:forEach var="club" items="${clubList}">
	<tr><td>모임 이름 : </td><td>${club.group_name }</td><td><input type="button" onclick="fn_join('${club.group_name}','${club.group_id}')" value="참여신청"></td></tr>	
	<tr><td>모임 일정 : </td><td>${club.group_date }</td></tr>
	<tr><td>카테고리 : ${club.group_category }</td></tr>
	<tr><td>모임 소개 : ${club.group_info }</td></tr>
	<tr><td>--------------------------</td></tr>
	</c:forEach>
	</table>
<h2>참여한 모임</h2>
	<table id="grp2">
	<c:forEach var="join" items="${joinList}">
	<tr><td>모임 이름 : </td><td>${join.group_name }</td><td><input type="button" onclick="fn_join('${club.group_name}','${club.group_id}')" value="모임으로"></td></tr>	
	<tr><td>모임 일정 : </td><td>${join.group_date }</td></tr>
	<tr><td>카테고리 : ${join.group_category }</td></tr>
	<tr><td>모임 소개 : ${join.group_info }</td></tr>
	<tr><td>--------------------------</td></tr>
	</c:forEach>
	</table>
	</form>
</body>
</html>