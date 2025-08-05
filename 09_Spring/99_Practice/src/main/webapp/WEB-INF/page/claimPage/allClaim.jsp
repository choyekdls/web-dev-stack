<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	
  </head>
  <body>
	
	<div class="container">
    <h1>클레임 검색</h1>
    <form action="/allClaim" method="post">
		<select name="select">
			<option value="name">업체명</option>
			<option value="title">도서명</option>
		</select>
      <input type="text" name="keyword" value="${param.keyword}" />
      <input type="submit" value="조회" />
    </form>
	
    <h1>전체 클레임 조회</h1>
    <table border="1">
      <tr>
        <th>선택</th>
		<th>클레임 번호</th>
        <th>업체명</th>
		<th>도서명</th>
		<th>가격</th>
		<th>클레임 수량</th>
		<th>총 금액</th>
		<th>클레임 유형</th>
		<th>회수 가능 여부</th>
		<th>회수 상태</th>
		<th>상세 설명</th>
        <th>클레임 등록 날짜</th>
      </tr>

      <c:forEach items="${claimList}" var="claim">
        <tr>
          <td><input type="checkbox" name="claim" value="${claim.claimNo}"></td>
          <td>${claim.claimNo}</td>
          <td>${claim.name}</td>
          <td>${claim.title}</td>
		  <td>${claim.price}</td>
		  <td>${claim.quantity}</td>
		  <td>${claim.totalAmount}</td>
		  <td>${claim.defectType}</td>
		  <td>${claim.recall}</td>
		  <td>${claim.recallStatus}</td>
		  <td>${claim.content}</td>
		  <td>${claim.claimDate}</td>
        </tr>
      </c:forEach>
    </table>
	</div>
	
	<button id="update" type="button">수정</button>
	<button id="delete" type="button">삭제</button>
	
	<script>
		$("#update").click(() => {
			const claimNo = $("input[name='claim']:checked").val();
			location.href="/updateClaim?claimNo=" + claimNo;
		});
		$("#delete").click(()=> {
			const claimNo = $("input[name='claim']:checked").val();
			if(!claimNo) {
				alert("삭제하실 항목을 선택해주세요.")
				return;
			}
			$.ajax({
			        url: "/deleteClaim",
					type: "post",
					data: {claimNo},
					success: function () {
						alert("삭제되었습니다.");
						location.href = "/allClaim";
					},
						error: function () {
						alert("삭제에 실패했습니다.");
					},
				});
			});
	</script>

  </body>
</html>
