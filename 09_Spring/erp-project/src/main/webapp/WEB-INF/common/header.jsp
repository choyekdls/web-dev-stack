<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="greet">
	        <div class="Welcome">
	        <h2>Welcome,다인:)</h2>
			<h5>오늘 하루도 맑음입니다.</h5>
	        </div>
			
	        <div class="status">
	          <div class="icon"></div>
	          <div class="icon"></div>
	          <div class="icon"></div>
	          <div class="icon"></div>
	        </div>
			
			<form action="/myPage" method="get">
			        <button type="submit" value="정보수정">개인정보수정</button>
			</form>
	      </header>