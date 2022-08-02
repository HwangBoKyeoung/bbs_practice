<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<form action="userDelete.do" method="post" onsubmit="return deleteSubmit();">
	<input type="hidden" value="${user.userName}" name="userName" />
	<input type="hidden" value="<sec:authentication property="principal.username" />" name="userId" />
		<table class="table table-bordered" id="dataTable" width="100%"
			cellspacing="0">
			<tbody>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="userPwd" id="userPwd" /></td>
				</tr>
				<tr>
					<th>비밀번호재입력</th>
					<td><input type="password" name="userRePwd" id="userRePwd" />
					</td>
				</tr>
			</tbody>
		</table>
		<br /> 
		<input type="submit" value="삭제하기" class="btn btn-warning btn-icon-split" />
	</form>
	<br />

	<script>
			$(document).ready(function(){
				
			});
			
			function deleteSubmit(){
				let userPwd = $("#userPwd").val();
				let userRePwd = $("#userRePwd").val();
				
				if(userPwd != userRePwd){
					Swal.fire("비밀번호, 재입력 부분이 일치하지 않습니다.");
    				$(".swal2-confirm").on("click", function() {
    					history.go(0);
    				});
					return false;
				}
				
				let result = confirm("정말 회원탈퇴를 진행하시겠습니까?");
				if(result){
					return true;
				} else{
					return false;
				}
				
			}
		</script>
</body>
</html>