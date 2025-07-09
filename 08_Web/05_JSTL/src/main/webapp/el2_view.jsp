<%@page import="java.util.Arrays"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1. 기존 방식</h2>
	<%
	String id = request.getParameter("id");
	String[] hobbyList = request.getParameterValues("hobby");
	%>

	<ul>
		<li>아이디 : <%=id%></li>
		<%
		for (String hobby : hobbyList) {
		%>
		<li><%=hobby%></li>
		<%
		}
		%>

	</ul>

	<h2>2. EL</h2>
	<ul>
		<li>아이디 : ${param.id}</li>
		<li>취미 : ${paramValues.hobby[0]} </li> <%-- 0번째 값 불러오기 : game --%>

	</ul>

</body>
</html>