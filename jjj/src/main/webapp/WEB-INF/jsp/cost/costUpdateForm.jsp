<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
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
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<form action="costUpdate.do" method="post" enctype="multipart/form-data" onsubmit="return fileCheck();">
			<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
				<tbody>
					<tr>
						<th>순번</th>
						<td><input type="text" readonly value="${cost.costNo}" name="costNo" id="costNo" /></td>
					</tr>
					<tr>
						<th>결제방식</th>
						<td><select name="costMethod" id="costMethod">
								<option value="1" <c:if test="${cost.costMethod=='계좌이체'}">selected</c:if>>계좌이체</option>
								<option value="2" <c:if test="${cost.costMethod=='현금'}">selected</c:if>>현금</option>
								<option value="3" <c:if test="${cost.costMethod=='카드'}">selected</c:if>>카드</option>
							</select></td>
					</tr>
					<tr>
						<th>결제분류</th>
						<td>
							<select name="costCategory" id="costCategory">
								<option value="1" <c:if test="${cost.costCategory == '교통비' }">selected</c:if>>교통비</option>
								<option value="2" <c:if test="${cost.costCategory == '숙박비' }">selected</c:if>>숙박비</option>
								<option value="3" <c:if test="${cost.costCategory == '일비' }">selected</c:if>>일비</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>상세내용</th>
						<td><textarea maxlength="300" rows="20" cols="100" name="costDetail" id="costDetail" placeholder="상세 내용을 입력해주세요. 300자까지 입력할 수 있습니다.">${cost.costDetail}</textarea></td>
					</tr>
					<tr>
						<th>결제자</th>
						<td><input type="text" value="${cost.costBuyer}" name="costBuyer" id="costBuyer" readonly /></td>
					</tr>
					<tr>
						<th>금액</th>
						<td><input type="number" min="0" maxlength="10" oninput="maxLengthCheck(this)" value="${cost.costSum}" name="costSum" id="costSum" required /></td>
					</tr>
					<tr>
						<th>파일명</th>
						<td><input type="file" name="file" id="file" onchange="setThumbNail(event)" /></td>
					</tr>
				</tbody>
			</table><br />
			<div id="imageView">
				<c:if test="${not empty cost.fileRename}">
					<img src="/upload/${cost.fileRename}" id="imgs" />
				</c:if>
			</div>
			<input type="submit" value="수정" class="btn btn-warning btn-icon-split" />
		</form>
	</div>
	<div align="center">
		<button onclick="location.href='costSelectList.do'" class="btn btn-primary btn-icon-split btn-lg">목록으로</button>
	</div><br/>
	<input type="hidden" value="${sessionAuth}" id="auth" />
	<script>
		function setThumbNail(e){
			let reader = new FileReader();
			
			reader.onload = function(e){
				let img = document.createElement("img");
				img.setAttribute("src", e.target.result);
				document.querySelector("div#imageView").appendChild(img);
			};
			if($("#imgs") != null || $("#imgs") != ''){
				$("#imgs").remove();
			}
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
		
// 		파일을 선택하지 않으면 문구 띄워주기용 메서드
		function fileCheck(){
			let answer;
			if(!$("#file").val()){
				answer = confirm("새로운 파일을 첨부하지 않았습니다. 기존 첨부파일 그대로 전송하시겠습니까?");
				if(answer == true){
					return true;
				} else {
					return false;
				}
			}
			return true;
		}

	</script>
</body>
</html>