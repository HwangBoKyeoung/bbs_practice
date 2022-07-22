<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set value="${pageContext.request.contextPath}/images" var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<style>
	* {
		box-sizing: border-box;
		padding: 0;
		margin: 0;
	}
	
	html, body {
		border: 0;
	}
	
	.padding-none {
		padding: 0;
		display: inline-block;
	}

    @media all and (min-width: 320px) {
		body{
			background: url(${path}/egovframework/background/cat.PNG) no-repeat;
			background-size: cover;
    	}
	}

    @media all and (min-width: 768px) {
    	body{
			background: url(${path}/egovframework/background/lion.PNG) no-repeat;
			background-size: cover;
    	}
	}

	@media all and (min-width: 1080px) {
		body{
			background: url(${path}/egovframework/background/fly.PNG) no-repeat;
			background-size: cover;
    	}
	}
</style>
<title>WELCOME HOME</title>
</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                            	<h1 class="h4 text-gray-900 mb-4">=====WELCOME=====</h1>
								<h2 class="h4 text-gray-900 mb-4">여기는 회원가입 페이지입니다.</h2>
                            </div>
                            <form class="user" action="userRegister.do" method="post" onsubmit="return registerFnc();">
                            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="userId" id="userId"
                                            placeholder="아이디" required/>
                                    </div>
                                    <div class="col-sm-6">
                                    	<button type="button" id="idChk" value="N" onclick="idChkFnc();" class="form-control form-control-user btn btn-primary btn-icon-split btn-lg" style="align-items: center;">아이디중복체크</button>
                                    </div>
                                </div>
                                <div class="form-group">
                                	<div class="form-group row">
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                        <input type="text" class="form-control form-control-user" name="userName" id="userName"
	                                            placeholder="이름" required/>
	                                    </div>
	                                    <div class="col-sm-6">
	                                    	<input type="text" class="form-control form-control-user" name="userTel" id="userTel"
	                                            placeholder="연락처" required maxlength="11"/>
	                                    </div>
	                                </div>
                                </div>
                                <div class="form-group">
                                	<div class="col-sm-8 mb-3 mb-sm-0 padding-none">
                                		<input type="email" class="form-control form-control-user" id="userMail"
                                        	   name="userMail" placeholder="이메일 주소 입력"/>
                                	</div>&nbsp;
                                    <div class="col-sm-3 padding-none">
                                    	&nbsp;&nbsp;<strong>성별</strong>&nbsp;
                                    	<input type="radio" name="userGender" id="male" value="M" />
										<label for="male">남</label>
										<input type="radio" name="userGender" id="female" value="W" />
										<label for="female">여</label>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                             name="userPwd" id="userPwd" required placeholder="비밀번호 입력" />
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            name="userPwdChk" id="userPwdChk" required placeholder="비밀번호 재입력"/>
                                    </div>
                                </div>
                                <input type="submit" value="회원가입" class="btn btn-primary btn-user btn-block"/>
                                <hr/>
                            </form>
                            <hr/>
                            <div class="text-center">
                                <a class="small" href="findUserPasswordForm.do">비밀번호를 잊어버리셨나요?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="userLoginForm.do">로그인페이지로</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
	
		function registerFnc() {
			if($("#idChk").val() == 'N') {
				Swal.fire('아이디 중복체크를 해주십시오.');
				$(".swal2-confirm").on("click", function() {
					setTimeout(function(){
						$("#userId").focus();
					}, 800);
				});
				return false;
			}
			if($("#userPwd").val() != $("#userPwdChk").val()) {
				Swal.fire('비밀번호와 비밀번호 확인하기 값이 다릅니다.');
				$(".swal2-confirm").on("click", function() {
					setTimeout(function(){
						$("#userPwd").focus();
					}, 800);
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
						Swal.fire('입력하신 아이디가 이미 존재합니다.');
						$(".swal2-confirm").on("click", function() {
							setTimeout(function(){
								$("#userId").val('');
								$("#userId").focus();
							}, 800);
						});
					} else {
						if($("#userId").val() == "" || $("#userId").val() == null) {
							Swal.fire('아이디를 입력해주세요.');
							$(".swal2-confirm").on("click", function() {
								setTimeout(function(){
									$("#userId").focus();
								}, 800);
							});
						} else {
							Swal.fire('입력하신 아이디는 사용가능합니다.');
							$(".swal2-confirm").on("click", function() {
								setTimeout(function(){
									$("#userName").focus();
								}, 800);
								
								$("#idChk").val("Y");
							});
						}
					}
				}
			});
		}
	</script>
</body>
</html>