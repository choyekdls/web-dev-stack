<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%-- 변수지정, 초기값, 어디까지, 얼마만큼 --%>
	<C:forEach var="i" begin="1" end="6" step="1">
	<h${i}>JSTL!${i}</h${i}>
	</C:forEach>
	
	<%
	  String[] arr = {"두루치기", "닭꼬치", "김치볶음밥", "순두부찌개"};
	  request.setAttribute("arr", arr);
	%>
	<%-- for(String menu:arr) 과 같다 --%>
	<c:forEach items="${arr}" var="menu">
	<p>${menu}</p>
	</c:forEach>
</body>
</html>