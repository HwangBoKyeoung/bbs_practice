<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<form action="costInsert.do" method="post" enctype="multipart/form-data">
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<tbody>
					<tr>
						<th>날짜</th>
						<td><input type="date" name="costDate" id="costDate" required /></td>
					</tr>
					<tr>
						<th>결제방식</th>
						<td><select name="costMethod" id="costMethod">
								<option value="1" selected>계좌이체</option>
								<option value="2">현금</option>
								<option value="3">카드</option>
							</select></td>
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
						<td><textarea maxlength="300" rows="20" cols="100" name="costDetail" id="costDetail" placeholder="상세 내용을 입력해주세요. 300자 까지 입력가능합니다."></textarea></td>
					</tr>
					<tr>
						<th>결제자</th>
						<td><input type="text" value="${userName}" name="costBuyer" id="costBuyer"  readonly /></td>
					</tr>
					<tr>
						<th>금액</th>
						<td><input type="number" min="0" maxlength="10" oninput="maxLengthCheck(this)" value="${cost.costSum}" name="costSum" id="costSum" required /></td>
					</tr>
					<tr>
						<th>파일</th>
						<td><input type="file" name="files" id="files" onchange="setThumbNail(event)" required /></td>
					</tr>
				</tbody>
			</table><br />
			<div id="imageView"></div>
			<input type="submit" value="등록" class="btn btn-danger btn-icon-split" />
		</form>
	</div>
	<div align="center">
		<button onclick="location.href='costSelectList.do'" class="btn btn-primary btn-icon-split btn-lg">목록으로</button>
	</div><br/>
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
		
// 		input type=number => maxlength가 제대로 동작하지 않는 브라우저 존재
//		oninput 이벤트속성을 이용하여 maxlength 및 minlength 제한 처리
		function maxLengthCheck(obj){
			if(obj.value.length > obj.maxLength){
				obj.value = obj.value.slice(0, obj.maxLength);
				console.log(obj.value);
			}
		}
	</script>
</body>
</html>