<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	
<h1>토마토 페이지</h1>
<!-- get, /myPage : 인증된 사람만 즉! 로그인된 사람만 -->
<p>아이디 : <sec:authentication property="principal.id"/></p>
<p><sec:authentication property="principal.name"/> 님의 페이지입니다.</p>	
</body>
</html>