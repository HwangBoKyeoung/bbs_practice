<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}/images" var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>WELCOME HOME</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
	.bg-addr-image{
		background:url(${path}/egovframework/background/kitty2.jpg);
		background-position:center;
		background-size:cover;
	}
</style>
</head>
<body class="bg-gradient-primary">
    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-addr-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                            	<h1 class="h4 text-gray-900 mb-4">=====WELCOME=====</h1>
								<h2 class="h4 text-gray-900 mb-4">여기는 주소등록 페이지입니다.</h2>
                            </div>
                            <form class="user" action="userAddrInsert.do" method="post" id="addrFrm">
                            	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" name="postNo" id="postNo"
                                            placeholder="우편번호" readonly/>
                                    </div>
                                    <div class="col-sm-6">
                                    	<button type="button" id="postChk" value="N" class="form-control form-control-user btn btn-primary btn-icon-split btn-lg" style="align-items: center;">주소찾기</button>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                             name="addr1" id="addr1" placeholder="도로명주소" readonly />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                             name="addr2" id="addr2" placeholder="나머지 주소 입력하세요." required />
                                    </div>
                                </div>
                                <input type="submit" value="주소등록하기" class="btn btn-primary btn-user btn-block"/>
                                <hr/>
                                <input type="hidden" class="form-control form-control-user"
                                             name="oldAddr" id="oldAddr" />
                                <input type="hidden" class="form-control form-control-user"
                                             name="engAddr" id="engAddr" />
                            </form>
                            <hr/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
    	$(document).ready(function(){
    		$("#postChk").on("click", function(){
    			new daum.Postcode({
    				oncomplete: function(data){
    					console.log(data);
    					let addr1 = $("#addr1");
    					let oldAddr = $("#oldAddr");
    					let engAddr = $("#engAddr");
    					let postNo = $("#postNo");
    					
    					addr1.val(data.address);
    					oldAddr.val(data.jibunAddress);
    					engAddr.val(data.addressEnglish);
    					postNo.val(data.zonecode);
    				}
    			}).open();
    		});
    	});
    </script>
</body>
</html>