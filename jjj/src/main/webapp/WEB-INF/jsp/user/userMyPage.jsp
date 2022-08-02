<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>WELCOME HOME</title>
<style>
	.display {
		display: inline-block;
		margin-right: 20px;
	}
	
	.table {
		text-align: center;
	}
	
	a {
		text-decoration: none;
		color: black;
	}
	
	a:hover {
		color: black;
		text-decoration: none;
	}
</style>
</head>
<body>
	<%-- <h5><sec:authentication property="principal" /></h5> --%>
	<div class="container-fluid">
		<!-- Page Heading -->
		<h1 class="h3 mb-4 text-gray-800 display">마이페이지:::</h1>
		<h1 class="h3 mb-4 text-gray-800 display"><sec:authentication property="principal.username" />님 환영합니다.</h1>
		<div align="right">
			<h1 class="h3 mb-4 text-gray-800 display"><input class="btn btn-info btn-icon-split btn-lg" type="button" value="회원정보수정" id="userUpdateForm"/></h1>
			<h1 class="h3 mb-4 text-gray-800 display"><input class="btn btn-primary btn-icon-split btn-lg" type="button" value="회원탈퇴" id="userDeleteForm"/></h1>
		</div>
		<br/>
		<hr/>
		<div align="center">
			<h2>경비 작성 글</h2>
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th>글번호</th>
						<th>작성날짜</th>
						<th>결제방법</th>
						<th>결제분류</th>
						<th>내용</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${costList}" var="cost">
						<tr>
							<td>${cost.costNo}</td>
							<td>${cost.costDate}</td>
							<td>${cost.costMethod}</td>
							<td>${cost.costCategory}</td>
							<td>${cost.costDetail}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br />
		<div id="content" align="center">
			<c:if test="${pageVO.prev }">
				<!-- 이전버튼 활성화 여부 -->
				<a href="${pageVO.startPage-1 }"> <input type="button" value="이전" />
				</a>
			</c:if>
			<!-- pageNum -->
			<c:forEach var="num" begin="${pageVO.startPage }"
				end="${pageVO.endPage }">
				<a class="${pageVO.pageNum == num ? 'active': '' }" href="${num }">
					<input type="button" value="${num }" />
				</a>
			</c:forEach>
			<!-- 다음버튼 -->
			<c:if test="${pageVO.next }">
				<a href="${pageVO.endPage+1 }"> <input type="button" value="다음" />
				</a>
			</c:if>
		</div>
		
		<form action="costSelect.do" method="post" name="frm" id="frm">
			<input type="hidden" name="pageNum" value="${pageVO.pageNum }" /> 
			<input type="hidden" name="amount" value="${pageVO.amount }" />
		</form>
		
		<!-- 회원수정양식 -->
		<form action="userUpdateForm.do" method="post" id="updateFrm">
			<input type="hidden" value="<sec:authentication property="principal.username" />" name="userId" />
		</form>
		
		<!-- 회원탈퇴양식 -->
		<form action="userDeleteForm.do" method="post" id="deleteFrm">
			<input type="hidden" value="<sec:authentication property="principal.username" />" name="userId" />
		</form>
	</div>
	
	<script>
		$(document).ready(function(){
			$("#userUpdateForm").on("click", function(){
				$("#updateFrm").submit();
			});
			
			$("#userDeleteForm").on("click", function(){
				$("#deleteFrm").submit();
			});
		});
		
	</script>
</body>
</html>