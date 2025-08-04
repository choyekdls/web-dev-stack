<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	
<h1>토마토</h1>
    <div id="anonymous" style="display: none;">
    <sec:authorize access="isAnonymous()">
	<button id="login">로그인</button><br>
	<button id="register">회원가입</button><br>
	</sec:authorize>
	</div>
	
	<div id="authenticated" style="display: none;">
	<sec:authorize access="isAuthenticated()">
	<button id="logout">로그아웃</button><br>
	<button id="myPage">마이 페이지</button><br>
	</sec:authorize>
	
	<sec:authorize access="hasRole('ADMIN')">
    <button id="admin">관리자 페이지</button><br>
	</sec:authorize>
	</div>
	
<script>
	$("#register").click(() => {
		location.href="/register"
	});
	
	$("#login").click(() => {
		location.href="/login"
	});
	
	$("#logout").click(() => {
		location.href="/logout"
    });
		
	$("#admin").click(() => {
		location.href="/admin"
	});
			
	$("#myPage").click(() => {
		location.href="/myPage"
	});
	
    const token = localStorage.getItem("token");
	
	if(token !== null){
		$("#authenticated").show();
	} else {
		$("#anonymous").show();
	}
	
	
</script>

</body>
</html>