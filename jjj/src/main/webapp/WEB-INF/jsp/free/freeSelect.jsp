<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
	#dataTable2 {
		border: 1px grey solid;
		height: 190px;
	}
	
	#dataTable2 th {
/* 		text-align: center; */
		font-weight: bold;
		font-size: 25px;
	}
	
	#dataTable2 tr {
		border-bottom: 1px grey solid;
	}
</style>
</head>
<body>
	<input type="hidden" value="${userId}" id="userId" />
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
			<tbody>
				<tr>
					<th>순번</th>
					<td><input type="hidden" value="${free.freeNo}" id="freeNo1"/>${free.freeNo}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${free.freeTitle}</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${free.freeWriter}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>${free.freeDate}</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${free.freeNoticeYn}</td>
				</tr>
				<tr>
					<th>글종류</th>
					<td>${free.freeHit}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${free.freeContent}</td>
				</tr>
			</tbody>
		</table>
		<br />
		<c:if test="${free.freeWriter eq userId}">
			<form action="freeUpdateForm.do" method="post">
				<input type="hidden" value="${free.freeNo}" name="freeNo" id="freeNo" />
				<input type="hidden" value="${free.freeTitle}" name="freeTitle" id="freeTitle" />
				<input type="hidden" value="${free.freeContent}" name="freeContent" id="freeContent" />
				
				<input type="hidden" value="${free.freeNoticeYn}" name="freeNoticeYn" id="freeNoticeYn" />
				<input type="hidden" value="${free.freeHit}" name="freeHit" id="freeHit" />
				<input type="hidden" value="${free.freeDate}" name="freeDate" id="freeDate" />
				<input type="hidden" value="${free.freeWriter}" name="freeWriter" id="freeWriter" />
				
				<input type="submit" value="수정하기" />
			</form>
		</c:if>
		<div align="center">
		<hr />
		<h2>=============댓글=============</h2>
		<div>
			<textarea rows="30" cols="50" placeholder="댓글작성해주세요" name="replyContent" id="replyContent"></textarea>
			<input type="submit" value="입력" onclick="insertReply();" class="btn btn-success btn-circle btn-lg" />
		</div>
		<input type="hidden" value="N" id="nVal" />
		
		<hr />
		<c:choose>
			<c:when test="${empty replys}">
				<h2>아직 입력된 댓글이 없습니다.</h2>
			</c:when>
			<c:otherwise>
				<div id="replyShow">
					<table id="dataTable2" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>내용</th>
								<th>작성자</th>
								<th>작성날짜</th>
								<th>수정날짜</th>
								<th>삭제날짜</th>
								<th>입력/수정/삭제버튼</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${replys}" var="reply">
								<c:if test="${reply.commentLevel ne 1}">
									<tr>
										<td>
											<c:forEach begin="4" end="${reply.commentLevel*4}">
												&nbsp;
											</c:forEach>
											${reply.replyContent}
										</td>
										<td>${reply.replyWriter}</td>
										<td>${reply.replyDate}</td>
										<td>${reply.replyUpdateDate}</td>
										<td>${reply.replyDeleteDate}</td>
										<c:if test="${reply.replyDeleteAt eq 'N'}">
											<td>
												<input type="button" value="댓글입력" onclick="insertReReply(${reply.replyNo});" />
												<c:if test="${reply.replyWriter eq userId}">
													<input type="button" value="댓글수정" onclick="updateReReply(${reply.replyNo});" />
													<input type="button" value="댓글삭제" onclick="deleteReReply(${reply.replyNo});" />
												</c:if>
											</td>
										</c:if>
									</tr>
									<tr id="showTr2" style="display: none;">
										<td colspan="6">
											<textarea rows="5" cols="100" id="contents">입력</textarea>
										</td>
									</tr>
								</c:if>
								<c:if test="${reply.commentLevel eq 1}">
									<tr>
										<td>${reply.replyContent}</td>
										<td>${reply.replyWriter}</td>
										<td>${reply.replyDate}</td>
										<td>${reply.replyUpdateDate}</td>
										<td>${reply.replyDeleteDate}</td>
										<c:if test="${reply.replyDeleteAt eq 'N'}">
											<td>
												<input type="button" value="댓글입력" onclick="insertReReply(${reply.replyNo});" />
												<c:if test="${reply.replyWriter eq userId}">
													<input type="button" value="댓글수정" onclick="updateReReply(${reply.replyNo});" />
													<input type="button" value="댓글삭제" onclick="deleteReReply(${reply.replyNo});" />
												</c:if>
											</td>
										</c:if>
									</tr>
									<tr id="showTr" style="display: none;">
										<td colspan="6">
											<textarea rows="5" cols="100" id="contents">입력</textarea>
										</td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
		
	</div>
	<br/>
	<br/>
	
	<form action="insertReReply.do" method="post" id="inserReplyFrm" style="display: none;">
		<input type="hidden" name="freeNo" value="${free.freeNo}" />
		<textarea rows="5" cols="120" name="replyContent" id="cont"></textarea>
		<input type="hidden" value="${userId}" name="replyWriter" />
		<input type="hidden" name="replyParentNo" id="parentNo" />
		<input type="submit" value="댓글등록" />
	</form>
	
	<form action="updateReReply.do" method="post" id="updateReplyFrm" style="display: none;">
		<input type="hidden" name="freeNo" value="${free.freeNo}" />
		<textarea rows="5" cols="120" name="replyContent" id="cont2"></textarea>
		<input type="hidden" name="replyNo" id="reno" />
		<input type="submit" value="댓글수정" />
	</form>
	
	<script>
		function noneDeleteReply() {
			Swal.fire('타인의 댓글은 지울 수 없습니다.');
			$(".swal2-confirm").on("click", function() {
				/* location.reload(); */
			});
		}
		
		function insertReply(){
			$.ajax({
				url : "ajaxInsertBulletinReply.do",
				dataType : "json",
				type : "post",
				data : {
					"freeNo" : $("#freeNo1").val(),
					"replyParentNo" : 0,
					"replyContent" : $("#replyContent").val(),
					"replyWriter" : $("#userId").val()
				},
				success : function(result) {
					console.log(result);
					if(result=="success"){
						ajaxReplyView(result);
					}
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
		
		function insertReReply(no){
			if($("#updateReplyFrm").css("display") == "block"){
				$("#updateReplyFrm").css("display", "none");
				$("#inserReplyFrm").css("display", "block");
			} else {
				$("#inserReplyFrm").css("display", "block");
			}
			
// 			let tr = $(event.target).parent().parent().next();
			/* $("#showTr").css("display", "block"); */
// 			tr.css("display", "show");
			/* tr.append($("#showTr")); */
			
			/* $(event.target).toggle("slow", function(){
				
			}); */
			
			/* $("#cont").val($("#contents").val()); */
			$("#parentNo").val(no);
			
			
		}

		function updateReReply(no){
			if($("#inserReplyFrm").css("display") == "block"){
				$("#inserReplyFrm").css("display", "none");
				$("#updateReplyFrm").css("display", "block");
			} else {
				$("#updateReplyFrm").css("display", "block");
			}
			
			$("#updateReplyFrm").css("display", "block");
			$("#reno").val(no);
		}
		
		/* 삭제처리 => 화면에서 보이지않게 하고 데이터는 가지고 있기 */
		function deleteReReply(no){
			let confirms = confirm("정말 댓글을 삭제하시겠습니까?");
			if(confirms){
				$.ajax({
					url : "ajaxUpdateDeleteBulletinReply.do",
					dataType : "text",
					type : "post",
					data : {
						"replyDeleteAt":"Y",
						"replyNo":no,
						"freeNo":$("#freeNo1").val()
					},
					success : function(result) {
						console.log(result);
						if(result=="success"){
							Swal.fire('댓글 삭제가 완료되었습니다.');
							$(".swal2-confirm").on("click", function() {
								location.reload();
							});
						}
					},
					error : function(err) {
						console.log(err);
					}
				});
			}
		}
		
		/* 완전삭제 */
		/* function deleteReReply(no){
			let confirms = confirm("정말 댓글을 삭제하시겠습니까?");
			if(confirms){
				$.ajax({
					url : "ajaxDeleteBulletinReply.do",
					dataType : "text",
					type : "post",
					data : {
						"replyNo":no
					},
					success : function(result) {
						console.log(result);
						if(result=="success"){
							Swal.fire('댓글 삭제가 완료되었습니다.');
							$(".swal2-confirm").on("click", function() {
								location.reload();
							});
						}
					},
					error : function(err) {
						console.log(err);
					}
				});
			}
		} */
	</script>
</body>
</html>