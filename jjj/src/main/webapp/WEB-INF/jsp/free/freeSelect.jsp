<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<c:choose>
			<c:when test="${empty free}">
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
						<tr>
							<td>${free.freeNo}</td>
							<td>${free.freeTitle}</td>
							<td>${free.freeWriter}</td>
							<td>${free.freeDate}</td>
							<td>${free.freeHit}</td>
							<td>${free.freeNoticeYn}</td>
						</tr>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</div>

	<div align="center">
		<button onclick="location.href='home.do'" class="btn btn-primary btn-icon-split btn-lg">홈으로</button>
	</div><br/>

</body>
</html>