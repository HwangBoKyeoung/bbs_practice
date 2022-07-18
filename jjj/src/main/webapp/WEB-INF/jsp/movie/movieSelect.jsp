<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set value="${pageContext.request.contextPath}/images" var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<h5>${movie}</h5>
		<c:forEach items="${list}" var="movie">
			<hr />
			${movie}
			<br />
			${movie.movieCodeVO}
			<br />
			${movie.movieCodeVO.movieCdRename}
			<br />
			${movie.movieCodeVO.movieCdDetail}
		</c:forEach>
		<h3>${user}</h3>
		<table border="1">
			<tbody>
				<tr>
					<th>순번</th>
					<td>${movie.movieNo}</td>
				</tr>
				<tr>
					<th>영화명</th>
					<td>${movie.movieName}</td>
				</tr>
				<tr>
					<th>영화내용</th>
					<td>${movie.movieConent}</td>
				</tr>
				<tr>
					<th>영화가격</th>
					<td><fmt:formatNumber value="${movie.moviePrice}" pattern="#,###" />원</td>
				</tr>
				<c:forEach items="${list}" var="file" varStatus="status">
					<tr>
						<th>포스터<c:out value="${status.count}" /></th>
						<td align="center">
							<c:choose>
								<c:when test="${not empty file.movieCodeVO.movieCdRename}">
									<img src="/upload/${file.movieCodeVO.movieCdRename}" width="200px" height="200px" />
									<br />
									<a href="/upload/${file.movieCodeVO.movieCdRename}" download="${file.movieCodeVO.movieCdDetail}">
										${file.movieCodeVO.movieCdDetail}
									</a>
								</c:when>
								<c:otherwise>
									<img src="${path}/egovframework/none/none.png" alt="없음.." />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<div>
			
		</div>

		<br /> <input type="button"
			style="width: 200px; height: 100px; background-color: red; color: white;"
			value="목록으로" onclick="location.href='movieSelectList.do'" />
	</div>

	<%-- <form action="costUpdateForm.do" method="post">
		<input type="hidden" value="${cost.costNo}" name="costNo" id="costNo" />
		<fmt:formatDate value="${cost.costDate}" pattern="yyyy-MM-dd" var="costDt" />
		<input type="hidden" value="${costDt}" name="costDate" id="costDate" />
		<input type="hidden" value="${cost.costMethod}" name="costMethod" id="costMethod" /> 
		<input type="hidden" value="${cost.costCategory}" name="costCategory" id="costCategory" /> 
		<input type="hidden" value="${cost.costDetail}" name="costDetail" id="costDetail" /> 
		<input type="hidden" value="${cost.costBuyer}" name="costBuyer" id="costBuyer" /> 
		<input type="hidden" value="${cost.costSum}" name="costSum" id="costSum" /> 
		<input type="hidden" value="${cost.fileName}" name="fileName" id="fileName" /> 
		<input type="submit" value="수정하기" />
	</form> --%>

	<form action="movieDelete.do" method="post">
		<input type="hidden" value="${movie.movieNo}" name="movieNo" id="movieNo" />
		<input type="submit" value="삭제하기" />
	</form>
	<%-- <div align="center">
		<hr />
		<h2>=============댓글=============</h2>
		<div>
			<textarea rows="30" cols="50" placeholder="댓글작성해주세요"
				name="replyContent" id="replyContent"></textarea>
			<input type="submit" value="댓글입력" onclick="insertReply();" />
		</div>
		<hr />
		<c:choose>
			<c:when test="${empty replys}">
				<h2>아직 입력된 댓글이 없습니다.</h2>
			</c:when>
			<c:otherwise>
				<div id="replyShow">
					<table>
						<tbody id="replyTbody">
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
										<td><input type="button" value="삭제"
											onclick="deleteReply('${reply.replyNo}');" /></td>
									</c:if>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div> --%>
	<input type="text" value="${user.userId}" id="userName" />
	<script>
		/* function insertReply() {
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
		} */
	</script>
</body>
</html>