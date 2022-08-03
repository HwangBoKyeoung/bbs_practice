<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}/images" var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
<style>
	* {
		box-sizing: border-box;
		padding: 0;
		margin: 0;
	}
	
	@media all and (min-width: 320px) {
		.h4 {
			font-size: 1.0rem;
			white-space: nowrap;
		}
	}
	
	@media all and (min-width: 768px) {
		.h4 {
			font-size: 1.5rem;
			white-space: nowrap;
		}
	}
</style>
</head>
<body class="bg-gradient-primary" onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                    	<h1 class="h4 text-gray-900 mb-4">=====WELCOME=====</h1>
										<h2 class="h4 text-gray-900 mb-4">여기는 로그인 페이지입니다.</h2>
                                    </div>
                                    <form class="user" action="login" method="post" id="myform">
                                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="username" name="username" placeholder="Enter your Id" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="password" name="password" placeholder="Enter your Password" required>
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="remember-me" name="remember-me">
                                                <label class="custom-control-label" for="remember-me">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <input type="submit" value="LOGIN" class="btn btn-primary btn-user btn-block" />
                                        <hr />
                                    </form>
                                    <hr />
                                    	<a href="https://kauth.kakao.com/oauth/authorize?client_id=62bffd34275370b1c97b721d1595304f&redirect_uri=http://localhost:8080/jjj/kakaoLogin.do&response_type=code">
                                    		<img src="${path}/egovframework/kakao/kakao_login_large_narrow.png" style="width: 100%; margin-bottom: 20px;"/>
                                    	</a>
                                    	<a href="#">
                                    		<img src="${path}/egovframework/naver/naver.PNG" style="width: 100%;"/>
                                    	</a>
                                    <hr />
                                    
                                    <div class="text-center">
                                        <a class="small" href="findUserPasswordForm.do">비밀번호 찾기</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="userRegisterForm.do">회원가입</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <input type="hidden" value="${sessionAuth}" id="auth" />
 	
 	<script>
	 	/* 뒤로가기 막을 페이지 */
		window.history.forward();
		function noBack(){
			window.history.forward();
		}
 	</script>
</body>
</html>