<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set value="${pageContext.request.contextPath}/images" var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
			<tbody>
				<tr>
					<th>순번</th>
					<td>${cost.costNo}</td>
				</tr>
				<tr>
					<th>날짜</th>
					<td>${cost.costDate}</td>
				</tr>
				<tr>
					<th>결제방식</th>
					<td>${cost.costMethod}</td>
				</tr>
				<tr>
					<th>결제분류</th>
					<td>${cost.costCategory}</td>
				</tr>
				<tr>
					<th>상세내용</th>
					<td>${cost.costDetail}</td>
				</tr>
				<tr>
					<th>결제자</th>
					<td>${cost.costBuyer}</td>
				</tr>
				<tr>
					<th>금액</th>
					<td><fmt:formatNumber value="${cost.costSum}" pattern="#,###" /></td>
				</tr>
				<tr>
					<th>파일명</th>
					<td><a href="/upload/${cost.fileRename}"
						download="${cost.fileName}">${cost.fileName}</a></td>
				</tr>
			</tbody>
		</table>
		<br />
		<div>
			<c:choose>
				<c:when test="${not empty cost.fileRename}">
					<img src="/upload/${cost.fileRename}" />
				</c:when>
				<c:otherwise>
					<img src="${path}/egovframework/none/none.png" alt="없음.." />
				</c:otherwise>
			</c:choose>
			<c:if test="cost.fileRename">
				<h2>위의 파일을 다운받아서 봐주세요.</h2>
			</c:if>
		</div>
		
		<br />
		<form action="costSelectList.do" method="post">
			<input type="hidden" value="${pageNum}" name="pageNum" />
			<input type="hidden" value="${amount}" name="amount" />
			<input type="hidden" value="${searchType}" name="searchType" />
			<input type="hidden" value="${searchName}" name="searchName" />
			<input type="submit" class="btn btn-primary btn-icon-split btn-lg" value="목록으로" />
		</form>
		
	</div>

	<form action="costUpdateForm.do" method="post">
		<input type="hidden" value="${cost.costNo}" name="costNo" id="costNo" />
		<fmt:formatDate value="${cost.costDate}" pattern="yyyy-MM-dd" var="costDt" />
		<input type="hidden" value="${costDt}" name="costDate" id="costDate" />
		<input type="hidden" value="${cost.costMethod}" name="costMethod"
			id="costMethod" /> <input type="hidden" value="${cost.costCategory}"
			name="costCategory" id="costCategory" /> <input type="hidden"
			value="${cost.costDetail}" name="costDetail" id="costDetail" /> <input
			type="hidden" value="${cost.costBuyer}" name="costBuyer"
			id="costBuyer" /> <input type="hidden" value="${cost.costSum}"
			name="costSum" id="costSum" /> <input type="hidden"
			value="${cost.fileName}" name="fileName" id="fileName" /> <input
			type="submit" value="수정하기" class="btn btn-warning btn-icon-split" />
	</form>

	<form action="costDelete.do" method="post">
		<input type="hidden" value="${cost.costNo}" name="costNo" id="costNo" />
		<input type="submit" value="삭제하기" class="btn btn-secondary btn-icon-split" />
	</form>
		<div align="center">
			<hr />
			<h2>=============댓글=============</h2>
			<div>
				<textarea rows="30" cols="50" placeholder="댓글작성해주세요"
					name="replyContent" id="replyContent"></textarea>
				<input type="submit" value="입력" onclick="insertReply();" class="btn btn-success btn-circle btn-lg" />
			</div>
			<hr />
			<c:choose>
			<c:when test="${empty replys}">
				<h2>아직 입력된 댓글이 없습니다.</h2>
			</c:when>
			
			<c:otherwise>
				<div id="replyShow">
					<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
						<tbody id="replyTbody" style="text-align:center;">
							<tr>
								<td>작성자&nbsp;&nbsp;</td>
								<td>작성일자&nbsp;&nbsp;</td>
								<td>댓글내용&nbsp;&nbsp;</td>
								<td>삭제&nbsp;</td>
							</tr>
							<c:forEach items="${replys}" var="reply">
								<tr>
									<td>${reply.replyWriter}&nbsp;&nbsp;</td>
									<td>${reply.replyDate}&nbsp;&nbsp;</td>
									<td>${reply.replyContent}&nbsp;</td>
									<c:if test="${user.userId eq reply.replyWriter}">
										<td>
											<input type="button" value="삭제" class="btn btn-danger btn-circle btn-lg" onclick="deleteReply('${reply.replyNo}');" />
										</td>
									</c:if>
									<c:if test="${user.userId ne reply.replyWriter}">
										<td>
											<input type="button" value="삭제" class="btn btn-danger btn-circle btn-lg" onclick="noneDeleteReply()" />
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:otherwise>
			</c:choose>
		</div>
		<input type="hidden" value="${user.userId}" id="userName" />
	<script>
		console.log($("#costMethod").val())
		function insertReply() {
			$.ajax({
				url : "ajaxInsertReply.do",
				dataType : "json",
				type : "post",
				data : {
					"costNo" : $("#costNo").val(),
					"replyWriter" : $("#userName").val(),
					"replyContent" : $("#replyContent").val()
				},
				success : function(result) {
					console.log(result);
					ajaxReplyView(result);
				},
				error : function(err) {
					console.log(err);
				}
			});

			function ajaxReplyView(data) {
				Swal.fire('댓글 등록이 완료되었습니다.');
				$(".swal2-confirm").on("click", function() {
					location.reload();
				});
			}
		}
		
		function deleteReply(id) {
			$.ajax({
				url: "ajaxDeleteReply.do",
				dataType: "text",
				type: "post",
				data: {"replyNo":id},
				success: function(data){
					if(data=='success'){
						console.log(data);
						Swal.fire('댓글 삭제가 완료되었습니다.');
						$(".swal2-confirm").on("click", function() {
							location.reload();
						});
					}
				}
			});
		}
		
		function noneDeleteReply() {
			Swal.fire('타인의 댓글은 지울 수 없습니다.');
			$(".swal2-confirm").on("click", function() {
				/* 
				location.reload(); */
			});
		}
	</script>
</body>
</html>