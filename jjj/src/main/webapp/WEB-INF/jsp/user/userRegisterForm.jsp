<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<h2>여기는 회원가입 페이지입니다.</h2>
	</div>
	<br />
	<div align="center">
		<form action="userRegister.do" method="post" onsubmit="return registerFnc();">
			<sec:csrfInput />
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId" id="userId" required /></td>
						<td><button type="button" id="idChk" value="N" onclick="idChkFnc();">아이디중복체크</button></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPwd" id="userPwd" required /></td>
					</tr>
					<tr>
						<th>비밀번호 확인하기</th>
						<td><input type="password" name="userPwdChk" id="userPwdChk" required /></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="userName" id="userName" required /></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
							<input type="radio" name="userGender" id="male" />
							<label for="male">남</label>
							<input type="radio" name="userGender" id="female" />
							<label for="female">여</label>
						</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="tel" maxlength="13" placeholder="-포함해서 전화번호 13자리를 작성해주세요." name="userTel" id="userTel" required /></td>
					</tr>
				</tbody>
			</table><br />
			<input type="submit" value="회원가입" />
			<input type="reset" value="초기화" />
		</form>
	</div>
	
	<script>
	
		function registerFnc() {
			if($("#idChk").val() == 'N') {
				Swal.fire('아이디 중복체크를 해주십시오.');
				$(".swal2-confirm").on("click", function() {
					$("#userId").focus();
				});
				return false;
			}
			if($("#userPwd").val() != $("#userPwdChk").val()) {
				Swal.fire('비밀번호와 비밀번호 확인하기 값이 다릅니다.');
				$(".swal2-confirm").on("click", function() {
					$("#userPwd").focus();
				});
				return false;
			}
			return true;
		}

		function idChkFnc() {
			$.ajax({
				url: "ajaxIdChk.do",
				data: {userId: $("#userId").val()},
				type: "post",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				dataType: "json",
				success: function(result) {
					if(result == 0) {
						if($("#userId").val() == '' || $("#userId").val() == null) {
							Swal.fire('아이디를 입력해주세요.');
							$(".swal2-confirm").on("click", function() {
								$("#userId").focus();
							});
						} else {
							Swal.fire('입력하신 아이디가 이미 존재합니다.');
							$(".swal2-confirm").on("click", function() {
								$("#userId").empty();
								$("#userId").focus();
							});
						}
					} else {
						Swal.fire('입력하신 아이디는 사용가능합니다.');
						$(".swal2-confirm").on("click", function() {
							$("#userPwd").focus();
							$("#idChk").val("Y");
						});
					}
				}
			});
		}
		
		
	</script>
</body>
</html>