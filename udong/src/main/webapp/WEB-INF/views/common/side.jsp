<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>

<html>
<head>
 <style>
   .no-underline{
      text-decoration:none;
   }
   body{
   display:inline;
   margin-right: 200px;
   }
 </style>
  <meta charset="UTF-8">
  <title>사이드 메뉴</title>
<script type="text/javascript">
	


</script>
</head>
<body>	
	<h1>
		<a href="${contextPath}/club/add"  class="no-underline">동아리 개설</a>
		<a href="${contextPath}/club/listComment"  class="no-underline">동아리 활동</a>
	</h1>
	
</body>
</html>