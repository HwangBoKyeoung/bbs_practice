<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<h1>===================여기서부터는 이메일 유효성 검증===================</h1>
	<form action="regEmailTest.do" method="post" onsubmit="return selectChk();">
		<input type="text" name="email" id="email" /> @ 
		<input type="text" name="email2" id="email2" readonly />
		<select name="emailSelect" id="emailSelect">
			<option value="null" selected>선택하기</option>
			<option value="naver.com">naver.com</option>
			<option value="gmail.com">gmail.com</option>
		</select>
		
		<input type="submit" value="검사하기" />
	</form>
	<hr/>
	<h1>===================여기서부터는 주민번호 유효성 검증===================</h1>
	<validator:javascript formName="userVO" />
	<form:form commandName="userVO" action="regIhIdNumTest.do" method="post">
		<form:input path="ihIdNum2" size="10" maxlength="6" /> - 
		<form:input path="ihIdNum3" size="10" maxlength="7" />
		<form:errors path="ihidnum" />
		<form:hidden path="ihidnum" />
		
		<input type="submit" value="검사하기" />
	</form:form>
	
	<script>
		function selectChk(){
			let e1 = $("#email").val();
			let e2 = $("#email2").val();
			if(e1 == '' || e1 == null){
				Swal.fire('이메일이 유효하지 않습니다.');
				$(".swal2-confirm").on("click", function() {
					
				});
				return false;
			} else if (e2 == '' || e2 == null){
				Swal.fire('도메인이 유효하지 않습니다.');
				$(".swal2-confirm").on("click", function() {
					
				});
				return false;
			}
			return true;
		}
		
		$("#emailSelect").on("change", function() {
			$("#email2").val('');
			let val = $(event.target).val();
			if(val == 'null' || val == '' || val == null) {
				return;
			}
			$("#email2").val(val);
		})
	</script>
</body>
<%-- <body>
	<validator:javascript formName="userVO" staticJavascript="false" xhtml="true" cdata="false" />
	<script>
		function fncValidatorInsert(){
			let varForm = document.getElementById("userVO");
			varForm.action = "<c:url value='/exRegister.do' />"
			
			if(confirm('저장하나요?')){
				if(!validateUserVO(varForm)){
					return;
				} else{
					if(ipValidate()){
						varForm.submit();
					} else {
						return;
					}
				}
			}
		}
	</script>
	
	<form:form commandName="userVO" method="post" action="exRegister.do">
		<table>
			<tr>
				<td><input type="text" name="userId" id="userId" /></td>
			</tr>
			<tr>
				<td><input type="text" name="userPwd" id="userPwd" /></td>
			</tr>
			<tr>
				<td><input type="text" name="userName" id="userName" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="save" onclick="fncValidatorInsert(); return false;" /></td>
			</tr>
		</table>
	</form:form>
</body> --%>
</html>