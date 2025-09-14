<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="side">
	<h1><a href="/">ERP</a></h1>
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