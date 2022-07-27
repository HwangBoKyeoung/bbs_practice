<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set value="${pageContext.request.contextPath}/images" var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- bootstrap5 사용 -->
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
	
	.input-number-password {
    	-webkit-text-security: disc;
	}
	
	.valid-id {
		font-weight: bold;
		text-align: center;
		color: green;
	}
	
	.invalid-id {
		font-weight: bold;
		text-align: center;
		color: red;
	}
	
	.valid-pwd {
		font-weight: bold;
		text-align: center;
		color: green;
	}
	
	.invalid-pwd {
		font-weight: bold;
		text-align: center;
		color: red;
	}
	
	/* Chrome, Safari, Edge, Opera */
	input::-webkit-outer-spin-button,
	input::-webkit-inner-spin-button {
	  -webkit-appearance: none;
	  margin: 0;
	}
	
	/* Firefox  */
	input[type='number'] {
	  -moz-appearance: textfield;
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
                                            placeholder="아이디" maxlength="20" required/>
                                           <div class="valid-id"></div>
                                           <div class="invalid-id"></div>
                                    </div>
                                    <div class="col-sm-6">
                                    	<button type="button" id="idChk" value="N" onclick="idChkFnc();" class="form-control form-control-user btn btn-primary btn-icon-split btn-lg" style="align-items: center;">아이디중복체크</button>
                                    </div>
                                </div>
                                <div class="form-group">
                                	<div class="form-group row">
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                        <input type="text" class="form-control form-control-user" name="userName" id="userName"
	                                            placeholder="이름" maxlength="10" required/>
	                                    </div>
	                                    <div class="col-sm-6">
	                                    	<input type="number" class="form-control form-control-user" name="userTel" 
	                                    			id="userTel" oninput="maxLengthCheck(this)" onkeyup="keyUpTel(this.value);"
	                                            placeholder="연락처('-' 제외)" required maxlength="11"/>
	                                    </div>
	                                </div>
                                </div>
                                <div class="form-group">
                                	<div class="col-sm-4 mb-3 mb-sm-0 padding-none">
                                		<input type="text" class="form-control form-control-user" id="email1"
                                        	   name="email1" placeholder="이메일 주소 입력" maxlength="15"
                                        	   onkeypress="isAlphaNumeric(this);" ondrop="return false;" />
                                	</div>@
                                	<div class="col-sm-4 mb-3 mb-sm-0 padding-none">
                                		<input type="text" class="form-control form-control-user" id="email2"
                                        	   name="email2" readonly/>
                                	</div>
                                	<div class="col-sm-3 mb-3 mb-sm-0 padding-none">
                                		<select name="emailSelect" id="emailSelect" class="form-control form-control-user" style="padding: 0; text-align: center;">
                                			<option value="null" selected>선택하세요</option>
                                			<option value="naver.com">naver.com</option>
                                			<option value="gmail.com">gmail.com</option>
                                		</select>
                                	</div>
                                </div>
                                <div class="form-group">
                                	<div class="col-sm-12 padding-none">
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
                                             name="userPwd" id="userPwd" maxlength="20" required placeholder="비밀번호 입력" />
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            name="userPwdChk" id="userPwdChk" maxlength="20" required placeholder="비밀번호 재입력"/>
                                           <div class="valid-pwd"></div>
                                           <div class="invalid-pwd"></div>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="number" oninput="maxLengthCheck(this)" class="form-control form-control-user"
                                             name="ihIdNum2" id="ihIdNum2" maxlength="6" required placeholder="주민번호 앞자리" />
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="number" oninput="maxLengthCheck(this)" inputmode="numeric" class="form-control form-control-user input-number-password"
                                            name="ihIdNum3" id="ihIdNum3" maxlength="7" required placeholder="주민번호 뒷자리" />
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
			
			let e1 = $("#email1").val();
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
					} else if(result == -1){
						Swal.fire('아이디는 시작은 영문으로만, 언더바를 제외한 특수문자 안되며 영문, 숫자, 언더바로만 이루어진 5 ~ 12자 이하 문자열을 사용하십시오.');
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
								let validatedId = $("#userId").next();
								validatedId.text("아이디 사용가능합니다.");
								if(validatedId.text() != null || validatedId.text() != ""){
									let invalidatedId = $("#userId").next().next();
									invalidatedId.text("");
								}
							});
						}
					}
				}
			});
		};
		
		$("#userPwdChk").on("change", function(){
			let pwd = $("#userPwd").val();
			let pwdChk = $("#userPwdChk").val();
			let validatedPwd = $("#userPwdChk").next();
			let invalidatedPwd = $("#userPwdChk").next().next();
			if(pwd == pwdChk){
				if(invalidatedPwd != "" || invalidatedPwd != null){
					invalidatedPwd.text("");
				}
				validatedPwd.text("비밀번호와 일치합니다.");
			} else{
				if(validatedPwd != "" || validatedPwd != null){
					validatedPwd.text("");
				}
				invalidatedPwd.text("비밀번호와 일치하지 않습니다.");
			}
		});
		
		$("#userId").on("change", function(){
			let validatedId = $("#userId").next();
			validatedId.text("");
			if(validatedId.text() == "" || validatedId() == null){
				let invalidatedId = $("#userId").next().next();
				invalidatedId.text("중복체크를 진행해주세요.");
			}
			$("#idChk").val("N");
		});
		
		function isAlphaNumeric(ev){
			const keyCode = ev.keyCode;
			const isValidKey = (
			    (keyCode >= 48 && keyCode <= 57) || // Numbers
			    (keyCode >= 97 && keyCode <= 122) || // Numbers, Keypad
			    (keyCode >= 65 && keyCode <= 90) || // Alphabet
			    (keyCode === 32) || // Space
			    (keyCode === 8) || // BackSpace
			    (keyCode === 189) // Dash
			  );
			  if (!isValidKey) {
				ev.preventDefault();
			    $("#email1").val('');
			    return false;
			  }
		}
		
		$("#emailSelect").on("change", function() {
			$("#email2").val('');
			let val = $(event.target).val();
			if(val == 'null' || val == '' || val == null) {
				return;
			}
			$("#email2").val(val);
		});
		
		function keyUpTel(val){
			console.log(val);
			val = val.replace('-', '');
			$("#userTel").val(val);
		};
		
// 		input type=number => maxlength가 제대로 동작하지 않는 브라우저 존재
//		oninput 이벤트속성을 이용하여 maxlength 및 minlength 제한 처리
		function maxLengthCheck(obj){
			if(obj.value.length > obj.maxLength){
				obj.value = obj.value.slice(0, obj.maxLength);
				console.log(obj.value);
			}
		};
	</script>
</body>
</html>