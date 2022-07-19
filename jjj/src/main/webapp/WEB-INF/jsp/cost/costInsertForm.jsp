<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<form action="costInsert.do" method="post" enctype="multipart/form-data">
			<table border="1">
				<tbody>
					<tr>
						<th>날짜</th>
						<td><input type="date" name="costDate" id="costDate" required /></td>
					</tr>
					<tr>
						<th>결제방식</th>
						<td><input type="text" name="costMethod" id="costMethod" required /></td>
					</tr>
					<tr>
						<th>결제분류</th>
						<td>
							<select name="costCategory" id="costCategory">
								<option value="1" selected>교통비</option>
								<option value="2">숙박비</option>
								<option value="3">일비</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>상세내용</th>
						<td><textarea rows="20" cols="30" name="costDetail" id="costDetail" placeholder="상세 내용을 입력해주세요."></textarea></td>
					</tr>
					<tr>
						<th>결제자</th>
						<td><input type="text" name="costBuyer" id="costBuyer" required /></td>
					</tr>
					<tr>
						<th>금액</th>
						<td><input type="text" name="costSum" id="costSum" required /></td>
					</tr>
					<tr>
						<th>파일</th>
						<td><input type="file" name="files" id="files" onchange="setThumbNail(event)" required /></td>
					</tr>
				</tbody>
			</table><br />
			<div id="imageView"></div>
			<input type="submit" value="등록" />
		</form>
	</div>
	
	<script>
		function setThumbNail(e){
			let reader = new FileReader();
			
			reader.onload = function(e){
				let img = document.createElement("img");
				img.setAttribute("src", e.target.result);
				document.querySelector("div#imageView").appendChild(img);
			};
			if($("#imageView").children() != null || $("#imageView").children() == ''){
				$("#imageView").children().remove();
			}
			reader.readAsDataURL(e.target.files[0]);
		}
	</script>
</body>
</html>