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
		max-width: 1080px;
	}
	
	html, body {
		border: 0;
	}
	
	div {
		display: inline-block;
	}
	
	#div {
		display: flex;
		justify-content: center;
        flex-wrap: wrap;
        align-items: center;
        height: 1000px;
	}
	
	#firstDiv, #thirdDiv {
		display: none;
	}
	
    @media all and (min-width: 320px) {
    	#myform {
    		overflow: hidden;
    	}
    
    	table {
    		display: inline-block;
    		float: left;
    	}
    	
    	#myform input[type=submit] {
			width: 20%;
			height: 20%;
			float: left;
			background-color: orange;
			margin-bottom: 20px;
		}
    	
		#div {
			display: flex;
			width: 100%;
			justify-content: center;
            flex-wrap: wrap;
            align-items: center;
            height: 1000px;
		}
		
		#myform>input {
			width: 45%;
			height: 100px;
			background-color: orange;
		}
	
		#myform>input:hover {
			background-color: blue;
            color: white;
		}
	}

    @media all and (min-width: 768px) {
        table {
    		display: inline-block;
    		text-align: center;
    	}
    	
    	#myform input[type=submit] {
    		width: 250px;
			height: 100px;
		}
		
		table input {
			width: 300px;
		}
		
		#myform>input:hover {
			background-color: turquoise;
		}
		
		#firstDiv, #thirdDiv {
			display: inline-block;
		}
		
		#firstDiv {
			width: 20%;
			height: 100%;
		}
		
		#firstDiv img, #thirdDiv img {
			width: 100%;
			height: 100%;
		}
		
		#secondDiv {
			width: 59%;
			text-align: center;
		}
		
		#thirdDiv{
			width: 20%;
			height: 100%;
		}
	}

	@media all and (min-width: 1080px) {
		#myform>input:hover {
			background-color: red;
		}
		
		table input {
			width: 580px;
		}
	}
</style>
</head>
<body>
<div id="div">
	<div id="firstDiv">
		<img src="${path}/egovframework/background/cat.PNG" alt="..." />
	</div>
	<div id="secondDiv" align="center">
		<h1>=====WELCOME=====</h1>
		<h2>여기는 로그인 페이지입니다.</h2>
		<br />
		<form action="login" method="post" id="myform">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="username" id="username" required /></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="password" id="password" required /></td>
					</tr>
				</tbody>
			</table><br />
			<input type="submit" value="로그인" />
			<input type="reset" value="초기화" />
		</form>
	</div>
	<div id="thirdDiv">
		<img src="${path}/egovframework/background/cat.PNG" alt="..." />
	</div>
</div>
</body>
</html>