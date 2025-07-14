<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:choose>
	<c:when test="${member != null}">
		<h1>${member.name}님 로그인 하셨습니다:)</h1>
		
	<!-- 로그인한 사람의 정보 수정 -->
	<form action="/update" method="post">
		비밀번호 : <input type="password" name="pwd" value="${member.pwd}"><br>
		이름 : <input type="text" name="name" value="${member.name}"><br>
		나이 : <input type="text" name="age" value="${member.age}"><br>
		<input type="submit" value="회원수정">
	</form>
	</c:when>
	<c:otherwise>
	<h1>회원관리</h1>	
	<a href="/register">회원가입</a><br>
	<a href="/login">로그인</a>
	</c:otherwise>
	</c:choose>
	
	<!-- 회원 전체 목록이 나오고 -->
	<h1>전체 회원 보기</h1>

		<table border="1">
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>나이</th>
			</tr>

		<c:forEach items="${list}" var="member">	

				<tr>
					<td>${member.name}</td>
					<td>${member.id}</td>
					<td>${member.pwd}</td>
					<td>${member.age}</td>
				</tr>

		</c:forEach>	
		</table>
</body>
</html>