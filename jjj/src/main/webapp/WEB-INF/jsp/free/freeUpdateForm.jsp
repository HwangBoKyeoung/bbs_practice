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
		<form action="freeUpdate.do" method="post">
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<tbody>
					<tr>
						<th>순번</th>
						<td><input type="hidden" value="${free.freeNo}" name="freeNo" />${free.freeNo}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" maxlength="30" value="${free.freeTitle}" required name="freeTitle" /></td>
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
						<td>${free.freeHit}</td>
					</tr>
					<tr>
					<th>글종류</th>
					<td>
						<select name="freeNoticeYn" id="freeNoticeYn" class="form-control form-control-user" style="padding: 0; text-align: center;">
							<option value="1" <c:if test="${free.freeNoticeYn == '공지'}">selected</c:if>>공지글</option>
							<option value="2" <c:if test="${free.freeNoticeYn == '자유글'}">selected</c:if>>자유글</option>
						</select>
					</td>
				</tr>
					<tr>
						<th>내용</th>
						<td><textarea cols="100" rows="10" maxlength="500" name="freeContent" required>${free.freeContent}</textarea></td>
					</tr>
				</tbody>
			</table>
			<br/>
			<input type="submit" value="수정" />
		</form>
	</div>
</body>
</html>