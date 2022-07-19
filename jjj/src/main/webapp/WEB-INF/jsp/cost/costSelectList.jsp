<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<div align="right">
			<form action="costSelectList.do" method="get">
				<select id="inputState" name="searchType">
					<option value="all"
						${pageVO.cri.searchType eq 'all' ? 'selected' : ''}>전체</option>
					<option value="date"
						${pageVO.cri.searchType eq 'date' ? 'selected' : ''}>날짜</option>
					<option value="category"
						${pageVO.cri.searchType eq 'category' ? 'selected' : ''}>분류</option>
				</select> <input type="text" name="searchName"
					value="${pageVO.cri.searchName}" /> <input type="submit"
					value="검색" /> <input type="hidden" value="1" name="pageNum" /> <input
					type="hidden" name="amount" value="${pageVO.cri.amount}" />
			</form>
		</div>
		<c:choose>
			<c:when test="${empty costs}">
				<h2>게시글이 존재하지 않습니다.</h2>
			</c:when>
			<c:otherwise>
				<table border="1">
					<thead>
						<tr>
							<th>순번</th>
							<th>날짜</th>
							<th>결제방식</th>
							<th>결제분류</th>
							<th>상세내용</th>
							<th>결제자</th>
							<th>금액</th>
							<th>파일명</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${costs}" var="cost">
							<tr onmouseover="this.style.backgroundColor='gray'"
								onmouseout="this.style.backgroundColor='transparent'"
								onclick="costSelect('${cost.costNo}')">
								<td>${cost.costNo}</td>
								<td><fmt:formatDate value="${cost.costDate}"
										pattern="yyyy-MM-dd" /></td>
								<td>${cost.costMethod}</td>
								<td>${cost.costCategory}</td>
								<td>${cost.costDetail}</td>
								<td>${cost.costBuyer}</td>
								<td><fmt:formatNumber value="${cost.costSum}" pattern="#,###" /></td>
								<td>${cost.fileName}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
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
	<input type="button" value="경비등록"
		onclick="location.href='costInsertForm.do'" />

	<form action="costSelect.do" method="post" name="frm" id="frm">
		<input type="hidden" id="costNo" name="costNo" />
		<input type="hidden" name="pageNum" value="${pageVO.pageNum }" /> <input
			type="hidden" name="amount" value="${pageVO.amount }" /> <input
			type="hidden" name="searchType" value="${pageVO.cri.searchType }" />
		<input type="hidden" name="searchName"
			value="${pageVO.cri.searchName }" />
	</form>

	<!-- 검색할 때마다 유지되길 원하는 값 -->
	<form id="actionForm" action="costSelectList.do" method="get">
		<input type="hidden" name="pageNum" value="${pageVO.pageNum }" /> <input
			type="hidden" name="amount" value="${pageVO.amount }" /> <input
			type="hidden" name="searchType" value="${pageVO.cri.searchType }" />
		<input type="hidden" name="searchName"
			value="${pageVO.cri.searchName }" />
	</form>
	
	<div align="center">
		<button onclick="location.href='home.do'" style="background-color: red; width: 800px; height: 100px;">홈으로</button>
	</div>

	<script>
		console.log(typeof (parseInt($("#pageNum").val())));
		console.log(typeof ($("#amount").val()));
		function costSelect(id) {
			document.forms.frm.costNo.value = id;
			document.forms.frm.submit();
		}
		
		let actionForm = $("#actionForm");
		$("#content a").on("click", function(e) {
			e.preventDefault();
			console.log("click");
			console.log($(this).attr("href"));
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));

			actionForm.submit();
		});
	</script>
</body>
</html>