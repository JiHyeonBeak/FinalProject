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
<style>
	@font-face {
		font-family:'mon';
		src:url(../font/'tmon.ttf');
		}
		
	table {
	    font-family:'mon';
	    text-align: center;
    }
		
	.hide {
		display:none;
	}
	textarea {
		resize:none;
		margin-bottom: 5px;
		border: 1px solid #73a1eb;
	}
		
    

</style>
<script type="text/javascript">


function fn_addco(){
	fm.submit();
}

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
<body><center>
	<form action="${contextPath }/club/addComment" method="post" name="fm">
	<h1>오늘의 이야기...</h1>
	<table>
	<tr><td>제목 : </td><td><textarea row="1" col="5" name="articleTitle"></textarea><td><input type="button" value="입력" onclick="fn_addco()"></td></tr>
	<tr><td>내용 : </td><td><textarea row="4" col="5" name="articleContent"></textarea></tr>
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
	
	<table id="list">
	<c:forEach var="com" items="${commentList}">
	<tr><td><input type="button" value="수정"  onclick="fn_modmod(${com.articleNo})"></td><td><input type="button" value="삭제"  onclick="fn_delco(${com.articleNo})"></td></tr>
	<tr><td>제목 : ${com.articleTitle }</td><td> ${com.wdate }</td></tr>
	<tr><td>작성자 : ${com.articleId }</td></tr>
	<tr><td>내용 : ${com.articleContent }</td></tr>
	<tr><td>좋아요 : ${com.articleLike }</td></tr>
	<tr><td>싫어요 : ${com.articleHate }</td></tr>
	<tr><td><input type="button" value="좋아요"  onclick="fn_like(${com.articleNo})"></td><td><input type="button" value="싫어요"  onclick=""></td></tr>
	<tr><td>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</td><td>ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ</td></tr>
	</c:forEach>
	</table></center>
</body>
</html>