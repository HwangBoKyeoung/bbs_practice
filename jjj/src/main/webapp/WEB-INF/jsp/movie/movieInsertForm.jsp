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
		<form action="movieInsert.do" method="post" enctype="multipart/form-data">
			<table border="1">
				<tbody>
					<tr>
						<th>영화제목</th>
						<td><input type="text" name="movieName" id="movieName" required /></td>
					</tr>
					<tr>
						<th>영화내용</th>
						<td>
							<textarea rows="20" cols="15" name="movieConent" id="movieConent" required></textarea>
						</td>
					</tr>
					<tr>
						<th>영화감독</th>
						<td><input type="text" name="movieDirector" id="movieDirector" required /></td>
					</tr>
					<tr>
						<th>영화배우</th>
						<td><input type="text" name="movieActor" id="movieActor" required /></td>
					</tr>
					<tr>
						<th>금액</th>
						<td>
							<select name="moviePrice" id="moviePrice">
								<option value="9000">새벽</option>
								<option value="14000">아침</option>
								<option value="14000">저녁</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>파일</th>
						<td><input type="file" name="files" multiple id="files" onchange="setThumbNail(event)" required /></td>
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