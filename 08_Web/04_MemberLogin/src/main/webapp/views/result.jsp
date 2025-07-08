<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Member member = (Member)request.getAttribute("member");
String id = request.getParameter("id");%>
<% if(member != null) { %>
<h1>회원정보</h1>
<table>
<tr>
<th>이름</th>
<th>아이디</th>
<th>비밀번호</th>
<th>나이</th>
</tr>
<tr>
<td><%=member.getName() %></td>
<td><%=member.getId() %></td>
<td><%=member.getPwd() %></td>
<td><%=member.getAge() %></td>
</tr>
</table>
<%} else { %>
<h2>아이디가 <%=id %>인 회원 정보가 없습니다:(</h2>
<%} %>

</body>
</html>