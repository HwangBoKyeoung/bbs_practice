<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}/images" var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
<body class="bg-gradient-primary">

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
										<h2 class="h4 text-gray-900 mb-4">비밀번호찾기</h2>
                                    </div>
<!--                                     <form class="user" action="findUserPassword.do" method="post" id="myform"> -->
                                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="userId" name="userId" placeholder="Enter your Id" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="userMail" name="userMail" placeholder="Enter your Email" required>
                            
                                        <input type="button" value="비밀번호 찾기" id="findPwd" class="btn btn-primary btn-user btn-block" />
                                        <hr>
<!--                                     </form> -->
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" onclick="history.go(-1);">이전페이지로</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    
    <script>
    	$("#findPwd").on("click", function(){
    		$.ajax({
        		url: "findUserPassword.do",
        		type: "post",
        		data: {"userId":$("#userId").val(), "userMail":$("#userMail").val()},
        		dataType: "json",
        		success: function(result){
        			if(result=='success'){
        				Swal.fire("임시비밀번호가 메일로 발송되었습니다.");
        				$(".swal2-confirm").on("click", function() {
        					location.href="userLoginForm.do";
        				});
        			} else {
        				console.log("실패!");
        			}
        		},
        		error: function(error){
        			console.log(error);
        		}
        	});
    	});
    	
    </script>
</body>
</html>