<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</head>
<body>
	
	<!-- a링크를 통해 해당 정보만 나올 수 있도록! -->
	<div class="container">
	<h1>${board.title}</h1>
	<p>${board.content}</p>
	<img src="http://192.168.0.35:8081/0115b622-e34a-4959-bd73-ca3f1bb11e6e_%EC%95%A0%EB%AA%BD%EA%B0%80.gif" >
	</div>
		
	<button id="update">수정</button><br>
	<button id="delete">삭제</button>
	
	<script>
	   $("#update").click(() => {
		<div class="modal">
			<form>
				제목<br>
				<input type="text" id="title" name="title" value="${board.title}">
			</form>
	    </div>
	   })
	</script>
</body>
</html>