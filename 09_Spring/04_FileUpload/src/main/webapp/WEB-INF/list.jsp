<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>게시글 목록</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>List Page</h1>
		<table class="table">
			<thead>
				<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성시간</th>
				</tr>
			</thead>
									
			<tbody>
				<c:forEach items="${list}" var="board" >
				<tr>
				<td>${board.no}</td>
				<td><a href="/view?no=${board.no}">${board.title}</td>
				<td><fmt:formatDate value="${board.formatDate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			    </c:forEach>
		    </tbody>
		</table>
		
		<button type="button" class="btn btn-outline-warning" data-bs-toggle="modal" data-bs-target="#writeModal">글쓰기</button>
		
		</button>
		<!-- Modal -->
		<div class="modal fade" id="writeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">게시글 등록</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div> 
			  <form action="/write" method="post" enctype="multipart/form-data">
		      <div class="modal-body">
		       
					<div class="mb-3">
					<label class="form-label">제목</label>
					<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력해주세요">
					</div>
					
					<div class="mb-3">
					<label class="form-label">본문</label>
					<textarea class="form-control" id="content" rows="3" name="content" placeholder="내용을 입력해주세요"></textarea>
					</div>
					
					<div class="mb-3">
					<label class="form-label">첨부 파일</label>
					<input class="form-control" name="file" type="file" id="file" accept="image/*" >
					</div>
		      </div>
			  
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button>
		        <button type="submit" class="btn btn-warning">등록</button>
		      </div>
		      </form>
		    </div>
		  </div>
		</div>
	</div>
	
</body>
</html>