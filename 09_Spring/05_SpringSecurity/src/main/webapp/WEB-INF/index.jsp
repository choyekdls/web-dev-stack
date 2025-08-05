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
<sec:authorize access="isAnonymous()"></sec:authorize>
<sec:authorize access="isAuthenticated()"></sec:authorize>
<sec:authorize access="hasRole('ADMIN')"></sec:authorize>

    <div id="anonymous" style="display: none;">
	<button id="login">로그인</button><br>
	<button id="register">회원가입</button><br>
	</div>
	
	<div id="authenticated" style="display: none;">
	<button id="logout">로그아웃</button><br>
	<button id="myPage">마이 페이지</button><br>
	</div>
	
    <button id="admin">관리자 페이지</button><br>

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
		$("#authenticated").show(); //show/hide
		$("#anonymous").hide();
		$("#admin").hide();
		
		$.ajax ({
			url:'/check',
			type: 'get',
			data: {token : token},
			
			success : function(data){
				if(data.role === "ROLE_ADMIN") {
					$("#admin").show();
		
	            } 	     
	       }
	  });
	  
	   } else {
		       $("#anonymous").show();
		       $("#authenticated").hide();
		       $("#admin").hide();} 
	
	$("#logout").click((e) => {
		e.preventDefault(); // 기존 거를 막아버리는ㄴ..
		localStorage.removeItem("token");
		location.reload();// reload 자기 페이지에서 새로고침
		 
	});
	
	$("#myPage").click((e) => {
		e.preventDefault();
		
		$.ajax({
			url: '/myPage',
			type: 'get',
			beforeSend : function(xhr) {
				xhr.setRequestHeader('Authorization', 'Bearer '  + token);
			},
			success : function(data) {
				$('body').html(data); //SinglePageApplication(SPA) -> React, Vue
			}
		});
		
		});
		
	$("#admin").click((e) => {
		e.preventDefault();
				
		$.ajax({
			url: '/admin',
			type: 'get',
			beforeSend : function(xhr) {
			    xhr.setRequestHeader('Authorization', 'Bearer '  + token);
			},
			success : function(data) {
				$('body').html(data); //SinglePageApplication(SPA) -> React, Vue
			}
		});
	});
	
</script>

</body>
</html>