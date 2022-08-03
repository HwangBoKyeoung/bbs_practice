<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type = "text/javascript" src = "https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<spring:eval expression="@naver['url']" var="url"/>
 	<input type="hidden" value="${url}" id="n1" name="n1" />
 	<spring:eval expression="@naver['clientId']" var="clientId"/>
 	<input type="hidden" value="${clientId}" id="n2" name="n2" />
 	<spring:eval expression="@naver['clientSecret']" var="clientSecret"/>
 	<input type="hidden" value="${clientSecret}" id="n3" name="n3" />
 	<spring:eval expression="@naver['callbackUrl']" var="callbackUrl"/>
 	<input type="hidden" value="${callbackUrl}" id="n4" name="n4" />
	
	<div id="show">
		<form action="naverLogin.do" method="post" id="frmSubmit">
			<input type="hidden" id="userMail" name="userMail"/>
			<input type="hidden" id="userId" name="userId"/>
			<input type="hidden" id="userName" name="userName"/>
			<input type="hidden" id="userTel" name="userTel"/>
			<input type="hidden" id="userGender" name="userGender"/>
		</form>
	</div>
	
	<script>
		naver_id_login = new naver_id_login($("#n2").val(), $("#n4").val());
// 		접근 토큰 값 출력
		alert(naver_id_login.oauthParams.access_token);
		
// 		네이버 사용자 프로필 조회
		naver_id_login.get_naver_userprofile("naverSignInCallback()");
		
// 		네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
		function naverSignInCallback(){
			let mail = naver_id_login.getProfileData("email");
			let nick = naver_id_login.getProfileData("nickname");
			let name = naver_id_login.getProfileData("name");
			let gend = naver_id_login.getProfileData("gender");
			let phon = naver_id_login.getProfileData("mobile");
			
			$("#userMail").val(mail);
			$("#userId").val(mail);
			$("#userName").val(name);
			$("#userTel").val(phon);
			$("#userGender").val(gend);
			
			$("#frmSubmit").submit();
		}
	</script>
</body>
</html>