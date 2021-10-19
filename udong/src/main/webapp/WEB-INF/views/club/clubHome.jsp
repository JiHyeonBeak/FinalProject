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
	body {
		width:900px;
		height:900px;
	}
	#grp2,#grp {
		border:1px solid #57bff2;
		width:200px;
		height:200px;
		display: inline;
		margin: 100px;
	}
	h2{
		animation-name: h2;
  		animation-duration:5s;
  		animation-iteration-count: infinite;
	}
	@keyframes h2 {
		from {
			opacity:40%;
		}
		to {opacity:1;
			color:#1d9ede;
		}
	}
</style>

<script type="text/javascript">
function fn_join(group_name,group_id){
	if(confirm(group_name+"에 참여하시겠습니까?")){
		fm.removeAttribute("action");
		fm.setAttribute("action", "${contextPath}/club/joinClub");
		var gid = document.createElement("input");
		gid.setAttribute("name","groupId");
		gid.setAttribute("type","hidden");
		gid.setAttribute("value",group_id);
		fm.appendChild(gid);
		fm.submit();
	}else{
		
	}
}
function fn_eachClub(group_id,group_name){
	fm.removeAttribute("action");
	fm.setAttribute("action", "${contextPath}/club/eachClubBoard");
	var gid = document.createElement("input");
	gid.setAttribute("name","groupId");
	gid.setAttribute("type","hidden");
	gid.setAttribute("value",group_id);
	
	var gname = document.createElement("input");
	gname.setAttribute("name","groupName");
	gname.setAttribute("type","hidden");
	gname.setAttribute("value",group_name);
	fm.appendChild(gid);
	fm.appendChild(gname);
	fm.submit();
}
</script>
</head>
<body>
<h2>개설된 모임</h2>
	<form action="${contextPath }/club/listClub" method="post" name="fm">
	<c:forEach var="club" items="${clubList}">
	<table id="grp">
	<tr><td colspan="2"><b>${club.group_name }</b></td><td><input type="button" onclick="fn_join('${club.group_name}','${club.group_id}')" value="참여신청"></td></tr>	
	<tr><td colspan="2">모임 일정 </td><td colspan="2"><b>${club.group_date }</b></td></tr>
	<tr><td colspan="4">카테고리 <b>${club.group_category }</b></td></tr>
	<tr><td colspan="4">모임 소개 <b>${club.group_info }</b></td></tr>
	<tr><td></td></tr>
	</table>
	</c:forEach>
<h2>참여한 모임</h2>
	<c:forEach var="join" items="${joinList}">
	<table id="grp2">
	<tr><td colspan="2"><b>${join.group_name }</b></td><td><input type="button" onclick="fn_eachClub('${join.group_id}','${join.group_name}')" value="모임으로"></td></tr>	
	<tr><td colspan="2">모임 일정 </td><td colspan="2">${join.group_date }</td></tr>
	<tr><td colspan="4">카테고리 <b>${join.group_category }</b></td></tr>
	<tr><td colspan="4">모임 소개 <b>${join.group_info }</b></td></tr>
	<tr><td></td></tr>
	</table>
	</c:forEach>
	</form>
</body>
</html>