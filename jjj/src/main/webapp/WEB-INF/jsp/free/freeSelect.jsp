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
		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
			<tbody>
				<tr>
					<th>순번</th>
					<td>${free.freeNo}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${free.freeTitle}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${free.freeWriter}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${free.freeDate}</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${free.freeNoticeYn}</td>
				</tr>
				<tr>
					<th>글종류</th>
					<td>${free.freeHit}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${free.freeContent}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<form action="freeUpdateForm.do" method="post">
		<input type="hidden" value="${free.freeNo}" name="freeNo" id="freeNo" />
		<input type="hidden" value="${free.freeTitle}" name="freeTitle" id="freeTitle" />
		<input type="hidden" value="${free.freeContent}" name="freeContent" id="freeContent" />
		
		<input type="hidden" value="${free.freeNoticeYn}" name="freeNoticeYn" id="freeNoticeYn" />
		<input type="hidden" value="${free.freeHit}" name="freeHit" id="freeHit" />
		<input type="hidden" value="${free.freeDate}" name="freeDate" id="freeDate" />
		<input type="hidden" value="${free.freeWriter}" name="freeWriter" id="freeWriter" />
		
		<input type="submit" value="수정하기" />
	</form>
</body>
</html>