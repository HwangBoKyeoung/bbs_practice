<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>
<%-- <c:set value="<%=sf.format(nowTime)%>" var="d1" />
<c:set value="<sec:authentication property="principal" />" var="r1" /> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<form action="freeInsert.do" method="post">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" maxlength="30" required
							name="freeTitle" /></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><input type="text" maxlength="10" required
							name="freeWriter" /></td>
					</tr>
					<tr>
						<th>작성일</th>
						<%-- <td><input type="date" min="${d1}" max="${d1}" required
							name="freeDate" /></td> --%>
					</tr>
					<tr>
						<th>글종류</th>
						<td>
							<select name="freeNoticeYn" id="freeNoticeYn" class="form-control form-control-user" style="padding: 0; text-align: center;">
								<option value="1" selected>공지글</option>
								<option value="2">자유글</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>회원여부</th>
						<td>
							
							<select name="freeRegYn" id="freeRegYn" class="form-control form-control-user" style="padding: 0; text-align: center;">
								<option value="1">회원</option>
								<c:if test="${not empty r1}">
									<option value="2">비회원</option>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea cols="100" rows="10" maxlength="500"
								name="freeContent" required>${free.freeContent}</textarea></td>
					</tr>
				</tbody>
			</table>
			<br /> <input type="submit" value="수정" />
		</form>
	</div>
</body>
</html>