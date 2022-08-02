<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}/images" var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
</head>
<body class="bg-gradient-primary">
	<c:if test="${userId eq null}">
		<a href="https://kauth.kakao.com/oauth/authorize
            ?client_id=62bffd34275370b1c97b721d1595304f
            &redirect_uri=http://localhost:8080
            &response_type=code" />
	</c:if>
	<c:if test="${userId ne null}">
		<h1>로그인 성공입니다.</h1>
	</c:if>
</body>
</html>