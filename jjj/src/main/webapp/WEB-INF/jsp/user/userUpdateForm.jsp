<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<form action="userUpdate.do" method="post" onsubmit="return updateSubmit();">
		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<tbody>
					<tr>
						<th>이름</th>
						<td>${user.userName}</td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="hidden" value="${user.userId}" name=""/>${user.userId}</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPwd" id="userPwd" /> </td>
					</tr>
					<tr>
						<th>비밀번호재입력</th>
						<td><input type="password" name="userRePwd" id="userRePwd" /> </td>
					</tr>
					<tr>
						<th>권한</th>
						<td>
							<c:choose>
								<c:when test="${user.role == 'ROLE_ADMIN'}">
									관리자
								</c:when>
								<c:when test="${user.role == 'ROLE_USER'}">
									일반회원
								</c:when>
								<c:otherwise>
									권한이 존재하지 않는 아이디입니다.
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
							<c:choose>
								<c:when test="${user.userGender == 'W'}">
									여자
								</c:when>
								<c:when test="${user.userGender == 'M'}">
									남자
								</c:when>
								<c:otherwise>
									성별이 없음
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" value="${user.userTel}" name="userTel" id="userTel" /></td>
					</tr>
					<tr>
						<th>메일</th>
						<td><input type="text" value="${user.userMail}" name="userMail" id="userMail" /></td>
					</tr>
					<tr>
						<th>주민등록번호</th>
						<td><input type="text" id="userIhIdNumFront" readonly />-<input type="text" id="userIhIdNumBack" readonly /></td>
					</tr>
				</tbody>
			</table>
			<br/>
			<input type="submit" value="수정하기" class="btn btn-warning btn-icon-split" />
		</form>
		<br />
		
		<input type="hidden" value="${user.ihidnum}" id="userihIdNum" />
		
		<script>
			$(document).ready(function(){
				
				let userIhId = $("#userihIdNum").val();
				
				let ihIdFront = userIhId.substr(0,6);
				let ihIdBack = userIhId.substr(7,1);
				
				$("#userIhIdNumFront").val(ihIdFront);
				$("#userIhIdNumBack").val(ihIdBack+"******");
			});
			
			function updateSubmit(){
// 				비밀번호 일치성 검사
				let userPwdVal = $("#userPwd").val();
				let userRePwdVal = $("#userRePwd").val();
				
				if((userPwdVal != '' && userRePwdVal != '') || (userPwdVal != null && userRePwdVal != null)){
					if(userPwdVal != userRePwdVal){
						Swal.fire('비밀번호와 비밀번호 재입력 부분이 다릅니다.');
						$(".swal2-confirm").on("click", function() {
							
						});
						return false;
					} else {
						return true;
					}
				}
				
				if((userPwdVal == '' && userRePwdVal == '') || (userPwdVal == null && userRePwdVal == null)){
					userPwdVal = null;
					userRePwdVal = null;
				}
				
				return true;
			}
		</script>
</body>
</html>