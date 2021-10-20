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
<title>동아리 메인</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel='stylesheet' href='../resources/font/font.css'>
<style>
	#modmod{
	    text-align: center;
	    border:1px solid #7aa5eb;
	    width:1000px;
    }
		
	#add{
		margin-bottom: 20px;
	}
	.hide {
		display:none;
	}
	textarea {
		margin-top:5px;
		resize:none;
		border: 3px solid #73a1eb;
		border-radius:20px;
	}
	
	#addbtn {
		width:70px;
		height:40px;
		font-size:20px;
		border:0px;
		border-radius: 12px;
		background-color: #73a1eb;
	}
	#line{
		border:1px solid #033894;
		margin: 30px;
	}
	#in{
		padding:10px;
	}	

</style>
<script type="text/javascript">


function fn_addco(){
	fm.submit();
}

function fn_delco(articleNo,articleId,articleTitle){
	if(confirm("'"+articleTitle+"'"+" 글을 삭제하시겠습니까?")){
	 var form = document.createElement("form");
	 form.removeAttribute("method");
	 form.setAttribute("method", "post");
	 form.setAttribute("action", "${contextPath}");
     var articleNOInput = document.createElement("input");
     articleNOInput.setAttribute("type","hidden");
     articleNOInput.setAttribute("name","articleNo");
     articleNOInput.setAttribute("value", articleNo);
     
     var articleIdInput = document.createElement("input");
     articleIdInput.setAttribute("type","hidden");
     articleIdInput.setAttribute("name","articleId");
     articleIdInput.setAttribute("value", articleId);
	 
     form.appendChild(articleNOInput);
     form.appendChild(articleIdInput);
     document.body.appendChild(form);
     form.submit();}
	}

function fn_modmod(articleNo){
	var articleNOInput = document.createElement("input");
    articleNOInput.setAttribute("type","hidden");
    articleNOInput.setAttribute("name","articleNo");
    articleNOInput.setAttribute("value", articleNo);
    fm2.appendChild(articleNOInput);
	fm2.submit();
	
	document.getElementById('list').setAttribute('class','hide');
	document.getElementById('modmod').removeAttribute('class');
}

function fn_modco(articleNo){
	document.getElementById('modmod').setAttribute('class','hide');
	document.getElementById('list').removeAttribute('class');
	var form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", "${contextPath}/club/modComment");
    var articleNOInput = document.createElement("input");
    articleNOInput.setAttribute("type","hidden");
    articleNOInput.setAttribute("name","articleNo");
    articleNOInput.setAttribute("value", articleNo);
	 
    form.appendChild(articleNOInput);
    document.body.appendChild(form);
    form.submit();
}
function fn_like(articleNo){
	var form = document.createElement("form");
	form.removeAttribute("method");
	form.setAttribute("method", "post");
	form.setAttribute("action", "${contextPath}/club/like");
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
	<center><form action="${contextPath }/club/addComment" method="post" name="fm">
	<h1>오늘의 이야기...</h1>
	<table id="add">
	<tr><td>제목 : </td><td><textarea rows="1" cols="100" name="articleTitle"></textarea><td rowspan="2"><input type="button" id="addbtn" value="입력" onclick="fn_addco()"></td></tr>
	<tr><td>내용 : </td><td><textarea rows="4" cols="100" name="articleContent"></textarea></tr>
	</table>
	</form>
	
	<form action="${contextPath}/club/modList" method="post" name="fm2">
	<c:forEach var="com" items="${modComment}">
	<table id="modmod" class="hide">
	<tr><td>제목 : <input type="text" value=${com.articleTitle }></td><td></td></tr>
	<tr><td>내용 : <input type="text" value=${com.articleContent }></td></tr>
	<tr><td><input type="button" value="확인"  onclick="fn_modco(${com.articleNo})"></td>
	</table>
	</c:forEach>
	</form>
	
	<div id="infinite">
	<tr><td id="line" width="700"> </td></tr>
	<c:forEach var="com" items="${commentList}">
	<table id="list">
	<tr><td width="300"></td><td><input type="button" value="삭제"  onclick="fn_delco(${com.articleNo},'${com.articleId }','${com.articleTitle }')"></td></tr>
	<tr><td id="in"><b>${com.articleTitle }</b></td><td> ${com.wdate }</td></tr>
	<tr><td id="in">${com.articleContent }</td><td>작성자 : <b>${com.articleId }</b></td></tr>
	<tr><td width="300"></td></tr>
	<tr><td width="300"></td><td></tr>
	<tr><td id="line" width="700"> </td></tr>
	</table>
	</c:forEach>
	</div>
	</center>
</body>
</html>