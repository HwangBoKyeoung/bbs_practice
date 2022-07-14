<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<h2>여기는 로그인 페이지입니다.</h2>
	</div>
	<br />
	<div align="center">
		<form action="login.do" method="post">
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="userId" id="userId" placeholder="ex. 홍길동" required /></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="userPwd" id="userPwd" required /></td>
					</tr>
				</tbody>
			</table><br />
			<input type="submit" value="로그인" />
			<input type="reset" value="초기화" />
		</form>
	</div>
</body>
</html>