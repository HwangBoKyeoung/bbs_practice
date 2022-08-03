<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	*{
	list-style: none;
	}
	.footer{
		position: fixed;
	}
	.swal-modal {
		width: 30%;
	}
	
	.swal-button--confirm {
		background-color: #ffb236;
	}
</style>
</head>
<body>
	<input type="hidden" value="${message}" id="msg" />
	<form action="login" method="post" id="kakaoLogin">
		<input type="hidden" value="${sessionId}" name="username" />
	</form>
	
	<script>
		localStorage.clear();
		Swal.fire($("#msg").val());
		$(".swal2-confirm").on("click", function() {
			$("#kakaoLogin").submit();
		});
	</script>
</body>
</html>