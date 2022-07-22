<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="application/octet-stream" src="<c:url value="/exRegister.do" />"></script>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>WELCOME HOME</title>
</head>
<body>
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
</body>
</html>