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
</head>
<body>
	<h5>
		${replys}<br/>
	</h5>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
			<tbody>
				<tr>
					<th>순번</th>
					<td>${free.freeNo}</td>
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
		
		<div align="center">
		<hr />
		<h2>=============댓글=============</h2>
		<div>
			<textarea rows="30" cols="50" placeholder="댓글작성해주세요" name="replyContent" id="replyContent"></textarea>
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
								<td>작 성  자&nbsp;&nbsp;</td>
								<td>댓글내용&nbsp;&nbsp;</td>
								<td>작성일자&nbsp;&nbsp;</td>
								<td>삭      제&nbsp;</td>
							</tr>
							<c:if test="${not empty replys}">
								<c:forEach items="${replys}" var="reply">
									<c:if test="${reply.replyReplyNo == 0}">
										${reply.replyNo}
									</c:if>
									<c:choose>
										<c:when test="${reply.replyReplyNo == 0}">
											<tr>
												<td>${reply.replyUpdateWriter}</td>
												<td>${reply.replyContent}</td>
												<td>${reply.replyUpdateDate}</td>
												<td><input type="button" value="답변" class="btn btn-danger btn-circle btn-lg"
														onclick="deleteReply('${reply.replyReplyNo}', '${reply.freeNo}');" />
												<c:if test="${user.userId eq reply.replyUpdateWriter}">
													<input type="button" value="삭제" class="btn btn-danger btn-circle btn-lg"
														onclick="deleteReply('${reply.replyReplyNo}', '${reply.freeNo}');" />
												</c:if>
												<c:if test="${user.userId ne reply.replyUpdateWriter}">
													<input type="button" value="삭제" class="btn btn-danger btn-circle btn-lg" onclick="noneDeleteReply()" />
												</c:if>
												</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:if test="${reply.replyNo}"></c:if>
												<tr style="text-align: right;">
													<td><h2>${reply.replyNo}</h2>${reply.replyUpdateWriter}</td>
													<td>${reply.replyContent}</td>
													<td>${reply.replyUpdateDate}</td>
													<td>
														<c:if test="${user.userId eq reply.replyUpdateWriter}">
															<input type="button" value="삭제" class="btn btn-danger btn-circle btn-lg"
																onclick="deleteReply('${reply.replyReplyNo}', '${reply.freeNo}');" />
														</c:if>
														<c:if test="${user.userId ne reply.replyUpdateWriter}">
															<input type="button" value="삭제" class="btn btn-danger btn-circle btn-lg" onclick="noneDeleteReply()" />
														</c:if>
													</td>
												</tr>
											
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
		
	</div>
	
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
	
	<script>
		function insertReply() {
			
		}
		
		function deleteReply(id) {
			
		}
		
		function noneDeleteReply() {
			Swal.fire('타인의 댓글은 지울 수 없습니다.');
			$(".swal2-confirm").on("click", function() {
				/* location.reload(); */
			});
		}
	</script>
</body>
</html>