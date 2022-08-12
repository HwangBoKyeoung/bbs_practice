<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${users}" var="users" />
<c:set value="${pageContext.request.contextPath}" var="path" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>WELCOME</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div align="center">
		<table border="1" style="text-align: center;">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>성별</th>
					<th>메일주소</th>
					<th>연락처</th>
					<th>주민등록번호 앞자리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user" varStatus="status">
					<tr onmouseover="this.style.backgroundColor= 'greenyellow';"
					    onmouseout="this.style.backgroundColor='transparent';"
					    onclick="userSelect('${user.userId}');">
						<td>${user.userId}</td>
						<td>${user.userName}</td>
						<c:choose>
							<c:when test="${user.userGender eq 'M'}">
								<td>남자</td>
							</c:when>
							<c:when test="${user.userGender eq 'W'}">
								<td>여자</td>
							</c:when>
							<c:otherwise>
								<td>-</td>
							</c:otherwise>
						</c:choose>
						<td>${user.userMail}</td>
						<td id="telTd">
							${user.userTel}
							<input type="hidden" value="${user.userTel}" id="userTel" />
						</td>
						<td>${user.ihIdNum2}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<button onclick="history.go(-1);">뒤로가기</button>
	<button onclick="location.href='${path}/home.do'">홈으로</button>
	
	<!-- 1건 조회 : form태그 -->
	<form id="selectFrm" action="${path}/user/userSelect.do" method="post">
		<input type="hidden" id="userId" name="userId" />
	</form>
	
	<script>
		function userSelect(id){
			document.forms.selectFrm.userId.value = id;
			document.forms.selectFrm.submit();
		}
	</script>
</body>
</html>