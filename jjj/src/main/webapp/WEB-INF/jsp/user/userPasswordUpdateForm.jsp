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
										<h2 class="h4 text-gray-900 mb-4">여기는 비밀번호 변경 페이지입니다.</h2>
                                    </div>
                                    <form class="user" action="userPasswordUpdate.do" method="post" id="myform" onsubmit="return passwordChk();">
                                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="tempPwd" name="tempPwd" placeholder="현재 임시비밀번호" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="updatePwd" name="updatePwd" placeholder="신규 비밀번호" required>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="updatePwd2" name="updatePwd2" placeholder="변경할 비밀번호를 다시 입력" required>
                                        </div>
                                        <input type="submit" value="수정하기" class="btn btn-primary btn-user btn-block" />
                                        <hr>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
    	function passwordChk(){
    		if($("#updatePwd").val() != $("#updatePwd2").val()){
    			return false;
    		}
    		
    		if(!comparePwd()){
    			return false;
    		}
    		return true;
    	}
    	
    	function comparePwd(){
    		$.ajax({
    			url: "",
    			dataType: "text",
    			type: "post",
    			data: {},
    			success: function(result){
    				if(result == 'success'){
    					return true;
    				}) else{
    					return false;
    				}
    			}
    		});
    	}
    </script>
</body>
</html>