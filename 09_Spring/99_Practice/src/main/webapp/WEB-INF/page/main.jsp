<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bk.project.member.vo.Member" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>메인 화면</title>
    <link rel="stylesheet" href="../resources/css/reset.css" />
    <link rel="stylesheet" href="../resources/css/layout.css" />
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  </head>
  <body>
	<div class="side">
	      <img src="logo.png" width="90px" class="logo" />
	      <h1><a href="/main">전체 메뉴 조회</a></h1>
	      <nav>
	        <div class="menu-group">
	          <div class="menu-title">인적자원 관리</div>
	          <div class="submenu">
	            <a href="/allMember">직원 정보 조회</a>
				<a href="/insertSalary">급여 등록</a>
	            <a href="/attendance">출/퇴근 관리</a>
	            <a href="/vacation">휴가 신청</a>
				<a href="/allVacation">휴가 신청 관리</a>
				<div class="submenu-item">
				  <a href="#" class="toggle-submenu">인사 평가 관리</a>
				  <div class="submenu-2">
				    <a href="/newEvaluation">ㆍ인사 평가 등록</a>
				    <a href="/promoCandi">ㆍ진급 대상자 조회</a>
				  </div>
				</div>
	            <a href="#">퇴사 관리</a>
	          </div>
	        </div>

	        <div class="menu-group">
	          <div class="menu-title">도서 관리</div>
	          <div class="submenu">
	            <a href="/allBook">도서 목록 조회/수정</a>
	          </div>
	        </div>

			<div class="menu-group">
				  <div class="menu-title">작가 계약 관리</div>
				  <div class="submenu">
				  <a href="/newContract">신규 계약 등록</a>
				  <a href="/allContract">계약 작가 조회/수정</a>
				  <a href="#">만료/해지 계약 조회</a>
		      </div>
			 </div>

	        <div class="menu-group">
	          <div class="menu-title">재고 관리</div>
	          <div class="submenu">
	            <a href="/allInven">재고 현황 조회</a>
				<a href="/newOutInven">출고 등록</a>
				<a href="/allShipment">출고 현황 조회</a>
	          </div>
	        </div>

	        <div class="menu-group">
	          <div class="menu-title">구매/판매 관리</div>
	          <div class="submenu">
	            <a href="/newPrintOrder">신규 도서 발주서 등록</a>
	            <a href="/allPrintOrder">발주서 조회/수정</a>
	            <a href="/delivery">출고 일정</a>
	          </div>
	        </div>

	        <div class="menu-group">
	          <div class="menu-title">거래처 관리</div>
	          <div class="submenu">
	            <a href="/newPartner">신규 거래처 등록</a>
	            <a href="/allPartner">거래처 조회/수정</a>
	          </div>
	        </div>

	        <div class="menu-group">
	          <div class="menu-title">운송사 관리</div>
	          <div class="submenu">
	            <a href="/newDelivery">신규 운송사 등록</a>
	            <a href="/allDelivery">운송사 정보 조회/수정</a>
	          </div>
	        </div>

	        <div class="menu-group">
	          <div class="menu-title">마케팅 관리</div>
	          <div class="submenu">
	            <a href="/newMarketing">신규 프로젝트 등록</a>
	            <a href="/allMarketing">프로젝트 조회/수정</a>
	            <a href="#">완료 프로모션 조회</a>
	          </div>
	        </div>

	        <div class="menu-group">
	          <div class="menu-title">재무 관리</div>
	          <div class="submenu">
	            <a href="/insertPayroll">급여 지급</a>
	            <a href="/revenue">수입 내역</a>
	            <a href="/expense">지출 내역</a>
	          </div>
	        </div>

	        <div class="menu-group">
	          <div class="menu-title">품질보증 관리</div>
	          <div class="submenu">
	            <a href="/newDefect">품질 검수 보고 등록</a>
	            <a href="/allDefect">품질 검수 기록 조회</a>
	            <a href="/newClaim">클레임 등록</a>
	            <a href="/allClaim">클레임 조회</a>
	            
	          </div>
	        </div>
	      </nav>
	    </div>

	    <div class="main">
	      <header class="greet">
	        <div class="Welcome">
				
				<%
				    Member member = (Member) session.getAttribute("member");
				%>
	          <h2>Welcome,<%=member.getName()%> :)</h2>
			  <p><span id="time"></span>(<span id="date"> </span>)</p>
			  <p>출근 시간: <span id="checkInDisplay"></span></p>
			  <p>퇴근 시간: <span id="checkOutDisplay"></span></p>
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
	      <section class="dashboard">
	        <div class="center-box">
	          <img src="logo.png" class="main-logo" />
	          <h3 id="today-date">2025-07-17 (목)</h3>
	          <div id="clock">08:48:27</div>
			  
	          <button type="button" id="checkIn">출근체크</button>
	          <button type="button" id="checkOut">퇴근체크</button>
	        </div>
	      </section>
	    </div>
		
	    <script>
			
			$(document).ready(function () {
				
				
			   // 메뉴 토글
			   $(".menu-title").click(function () {
			     $(this).next(".submenu").toggleClass("show");
			   });

			   // 2차 서브메뉴 (인사 평가 관리)
			   $(".toggle-submenu").click(function (e) {
			     e.preventDefault();
			     $(this).next(".submenu-2").slideToggle();
			   });
				
			   
			   	  // 브라우저 로드 시 서버에서 오늘 날짜 받아오기
			      $.ajax({
			        url: '/getTodayDate', 
			        type: 'GET',
			        success: function (serverToday) {
					  //날짜 받기
			          const localToday = localStorage.getItem("attendanceDate");
			   		  $("#time").text(localToday);
					  const today = new Date(); // 오늘 날짜 객체 만들기
					  const dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
					  const dayOfWeek = dayNames[today.getDay()];
					  console.log(dayOfWeek); // 👉 오늘 요일 출력 (예: "수요일")
					  $("#date").text(dayOfWeek);
					  
					  // 날짜가 다르면 localStorage 초기화
					  if (localToday !== serverToday) {
								
					     localStorage.removeItem("attendanceDate");
					     localStorage.setItem("checkedIn", "false");
						 localStorage.setItem("checkedOut", "false");
					     localStorage.removeItem("checkInTime");
					     localStorage.removeItem("checkOutTime");
					  }
							
					  if (localStorage.getItem("checkedIn") === "true") {
						$("#checkIn").prop("disabled", true).text("출근 완료");
					  }
					  const checkInTime = localStorage.getItem("checkInTime");
					  if (checkInTime) {
						$("#checkInDisplay").text(checkInTime);
					  }
					  const checkOutTime = localStorage.getItem("checkOutTime");
					  if (checkOutTime) {
						$("#checkOutDisplay").text(checkOutTime);
					  }			   
								   
			        },
			        error: function () {
			          console.error("🚫 서버 날짜 요청 실패");
			        }
			      });
			   
			   
			   
			   
				  
		   	$('#checkIn').click(function () {
				<!--오늘 날짜와 Controller날짜와 비교-->
				localStorage.setItem("checkedIn", "true");
				//출석을 찍은 당시의 날짜 저장
				const today = new Date().toISOString().split("T")[0];
				localStorage.setItem("attendanceDate", today);
				const now = new Date();
				const timeString = now.toTimeString().split(" ")[0]; // "HH:mm:ss"
				localStorage.setItem("checkInTime", timeString);
				$("#checkInDisplay").text(timeString);
					  $.ajax({
		   		          url: '/checkIn',
		   		          type: 'POST',
		   		          success: function (result) {
							if(parseInt(result) > 0)
							{
		   		            	alert('출근 체크 완료');
								location.href="/main";
							}
							else if(parseInt(result) == -1)
							{
								alert('이미 출근하였습니다.');
							}
							
							
		   		          },
		   		          error: function () {
		   		            alert('출근 체크 실패');
		   		          }
		   		        });
		   		      });
					  

		 $('#checkOut').click(function () {
			if (localStorage.getItem("checkedIn") === "false") 
			{
				alert("아직 출근하지 않았습니다.");
				return;
			}
			
			const now = new Date();
			const timeString = now.toTimeString().split(" ")[0]; // "HH:mm:ss"
			localStorage.setItem("checkOutTime", timeString);
			$("#checkOutDisplay").text(timeString);
					$.ajax({
					url: '/checkOut',
					type: 'POST',
					success: function (result) {
						if(parseInt(result) > 0)
							{
								alert('퇴근 체크 완료');
								location.href="/main";
								
							}
						else if(parseInt(result) == -1)
							{
								alert('출근 상태가 아닙니다.');
							}
							  						
						},
					error: function () {
							alert('퇴근 체크 실패');
					  	}
					  });
					 });					  					  
					});
	    </script>

		
  </body>
</html>
