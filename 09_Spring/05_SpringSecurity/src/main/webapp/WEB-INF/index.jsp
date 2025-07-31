<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	
<h1>토마토</h1>


	<button id="login">로그인</button><br>
	<button id="register">회원가입</button>


<script>
	$("#register").click(() => {
		location.href="/register"
	});
	
	$("#login").click(() => {
			location.href="/login"
	});
</script>

</body>
</html>