<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<h2>여기는 메인페이지입니다.</h2>
	</div>
	<c:choose>
		<c:when test="${empty sessionId}">
			<input type="button" value="로그인" onclick="location.href='userLoginForm.do'" />
			<input type="button" value="회원가입" onclick="location.href='userRegisterForm.do'" />
		</c:when>
		<c:otherwise>
			<c:if test="${sessionAuth eq admin }">
				<input type="button" value="경비전체리스트보기" onclick="location.href='costSelectList.do'" />
			</c:if>
			<c:if test="${sessionAuth eq user || sessionAuth eq admin }">
				<input type="button" value="일정보기" onclick="location.href='costCalendar.do'" />
				<input type="button" value="로그아웃" onclick="location.href='/logout'" />
			</c:if>
		</c:otherwise>
	</c:choose>
</body>
</html>