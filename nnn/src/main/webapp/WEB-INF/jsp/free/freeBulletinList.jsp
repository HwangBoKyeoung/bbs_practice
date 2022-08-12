<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<div align="right">
			<form action="${path}/free/freeBulletinList.do" method="get">
				<select id="inputState" name="searchType">
					<option value="all"
						${pageVO.cri.searchType eq 'all' ? 'selected' : ''}>전체</option>
					<option value="title"
						${pageVO.cri.searchType eq 'title' ? 'selected' : ''}>제목</option>
					<option value="content"
						${pageVO.cri.searchType eq 'content' ? 'selected' : ''}>내용</option>
				</select> <input type="text" name="searchName" maxlength="20"
					value="${pageVO.cri.searchName}" /> <input type="submit"
					value="검색" class="btn btn-primary btn-icon-split btn-lg" /> <input type="hidden" value="1" name="pageNum" /> <input
					type="hidden" name="amount" value="${pageVO.cri.amount}" />
			</form>
		</div><br/>
		<c:choose>
			<c:when test="${empty frees}">
				<h2>게시글이 존재하지 않습니다.</h2>
			</c:when>
			<c:otherwise>
				<table style="text-align: center;" class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>순번</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
							<th>글종류</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${frees}" var="free">
							<tr onmouseover="this.style.backgroundColor='#fd7e1480'"
								onmouseout="this.style.backgroundColor='transparent'"
								onclick="freeSelect('${free.freeNo}')">
								<td>${free.freeNo}</td>
								<td>${free.freeTitle}</td>
								<td>${free.freeWriter}</td>
								<td>${free.freeDate}</td>
								<td>${free.freeHit}</td>
								<td>${free.freeNoticeYn}</td>
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
	<input type="button" value="게시글 등록" class="btn btn-info btn-icon-split"
		onclick="location.href='${path}/free/freeInsertForm.do'" />

	<form action="${path}/free/freeSelect.do" method="post" name="frm" id="frm">
		<input type="hidden" id="freeNo" name="freeNo" />
		<input type="hidden" name="pageNum" value="${pageVO.pageNum }" /> <input
			type="hidden" name="amount" value="${pageVO.amount }" /> <input
			type="hidden" name="searchType" value="${pageVO.cri.searchType }" />
		<input type="hidden" name="searchName"
			value="${pageVO.cri.searchName }" />
	</form>

	<!-- 검색할 때마다 유지되길 원하는 값 -->
	<form id="actionForm" action="${path}/free/freeBulletinList.do" method="get">
		<input type="hidden" name="pageNum" value="${pageVO.pageNum }" /> <input
			type="hidden" name="amount" value="${pageVO.amount }" /> <input
			type="hidden" name="searchType" value="${pageVO.cri.searchType }" />
		<input type="hidden" name="searchName"
			value="${pageVO.cri.searchName }" />
	</form>
	
	<div align="center">
		<button onclick="location.href='${path}/home.do'" class="btn btn-primary btn-icon-split btn-lg">홈으로</button>
	</div><br/>

	<script>
		function freeSelect(id) {
			document.forms.frm.freeNo.value = id;
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