<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
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
</style>
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<form action="movieInsert.do" method="post"
			enctype="multipart/form-data">
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<tbody>
					<tr>
						<th>영화제목</th>
						<td><input type="text" name="movieName" id="movieName" placeholder="영화제목을 입력해주세요. 300자까지 입력할 수 있습니다." maxlength="300" style="width: 850px;"
							required /></td>
					</tr>
					<tr>
						<th>영화내용</th>
						<td><textarea rows="20" cols="100" name="movieConent"
								id="movieConent" maxlength="1000" placeholder="영화내용을 입력해주세요. 1000자까지 입력할 수 있습니다." required></textarea></td>
					</tr>
					<tr>
						<th>영화감독</th>
						<td><input type="text" name="movieDirector" maxlength="30"
							id="movieDirector" required /></td>
					</tr>
					<tr>
						<th>영화배우</th>
						<td><input type="text" name="movieActor" maxlength="300" id="movieActor" style="width: 850px;"
							required /></td>
					</tr>
					<tr>
						<th>금액</th>
						<td>
						<input type="number" value="14000" name="moviePrice" style="width: 200px; text-align:right;"
							id="moviePrice" min="9000" max="16000" required />원</td>
					</tr>
					<tr>
						<th>파일</th>
						<td><input type="file" name="files" multiple id="files"
							onchange="setThumbNail(event)" required /></td>
					</tr>
				</tbody>
			</table>
			<br />
			<div id="imageView"></div>
			<input type="submit" value="등록" class="btn btn-danger btn-icon-split" />
		</form>
	</div>
	<div align="center">
		<button onclick="location.href='movieSelectList.do'" class="btn btn-primary btn-icon-split btn-lg">목록으로</button>
	</div><br/>
	<script>
		/* 업로드 파일이 여러개일 때 처리 방법 */
		function setThumbNail(e) {
			let filesArr = $("#files")[0].files;
			$.each(filesArr, function(idx, item) {
				let reader = new FileReader();
				reader.onload = function(e) {
					let img = document.createElement("img");
					img.setAttribute("src", e.target.result);
					document.querySelector("div#imageView").appendChild(img);
				};
				if ($("#imageView").children() != null || $("#imageView").children() != '') {
					$("#imageView").children().remove();
				}
				console.log(e.target.files[idx]);
 				reader.readAsDataURL(e.target.files[idx]);
			});
		}
	</script>
</body>
</html>