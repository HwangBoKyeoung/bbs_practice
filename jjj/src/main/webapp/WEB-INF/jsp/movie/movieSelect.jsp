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
<style>
	#myform fieldset {
	    display: inline-block;
	    direction: rtl;
	    border: 0;
	}
	
	#myform input[type=radio] {
	    display: none;
	}
	
	#myform label {
	    font-size: 3em;
	    color: transparent;
	    text-shadow: 0 0 0 #f0f0f0;
	}
	
	#myform label:hover {
	    text-shadow: 0 0 0 rgba(250,208,0,0.99);
	}
	
	/* label에 마우스 오버했을 때 형제 label도 같이 효과 적용 */
	#myform label:hover ~ label {
	    text-shadow: 0 0 0 rgba(250,208,0,0.99);
	}
	
	#myform input[type=radio]:checked ~ label {
	    text-shadow: 0 0 0 rgba(250,208,0,0.99);
	}
</style>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<br />
		<h1>평점 : ${avg}점 </h1>
		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
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
			class="btn btn-primary btn-icon-split btn-lg"
			value="목록으로" onclick="location.href='movieSelectList.do'" />
	</div>

	<form action="movieDelete.do" method="post">
		<input type="hidden" value="${movie.movieNo}" name="movieNo" id="movieNo" />
		<input type="submit" value="삭제하기" class="btn btn-secondary btn-icon-split" />
	</form>
	<div align="center">
		<hr />
		<h2>=============댓글=============</h2>
		<div>
			<form name="myform" id="myform" method="post">
				<fieldset>
					<input type="radio" name="movieReplyStar" value="5" id="rate1" />
					<label for="rate1">★</label>
					<input type="radio" name="movieReplyStar" value="4" id="rate2" />
					<label for="rate2">★</label>
					<input type="radio" name="movieReplyStar" value="3" id="rate3" />
					<label for="rate3">★</label>
					<input type="radio" name="movieReplyStar" value="2" id="rate4" />
					<label for="rate4">★</label>
					<input type="radio" name="movieReplyStar" value="1" id="rate5" />
					<label for="rate5">★</label>
				</fieldset>
			</form>
			<textarea rows="30" cols="50" placeholder="댓글작성해주세요" name="movieReplyConent" id="movieReplyConent"></textarea>
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
								<td>별      점&nbsp;&nbsp;</td>
								<td>삭      제&nbsp;</td>
							</tr>
							<c:forEach items="${replys}" var="reply">
								<tr>
									<td>${reply.movieReplyWriter}&nbsp;&nbsp;</td>
									<td>${reply.movieReplyConent}&nbsp;</td>
									<td>
										<c:choose>
											<c:when test="${reply.movieReplyStar == 1}">★☆☆☆☆</c:when>
											<c:when test="${reply.movieReplyStar == 2}">★★☆☆☆</c:when>
											<c:when test="${reply.movieReplyStar == 3}">★★★☆☆</c:when>
											<c:when test="${reply.movieReplyStar == 4}">★★★★☆</c:when>
											<c:when test="${reply.movieReplyStar == 5}">★★★★★</c:when>
											<c:otherwise>☆☆☆☆☆</c:otherwise>
										</c:choose>
									</td>
									<c:if test="${user.userId eq reply.movieReplyWriter}">
										<td><input type="button" value="삭제" class="btn btn-danger btn-circle btn-lg"
											onclick="deleteReply('${reply.movieReplyNo}');" /></td>
									</c:if>
									<c:if test="${user.userId ne reply.movieReplyWriter}">
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
	<input type="hidden" id="movieNo" value="${movie.movieNo}"/>
	<input type="hidden" value="${user.userId}" id="userName" />
	<input type="hidden" id="movieReplyStar" />
	<script>
		$("#myform input").on("click", function(){
			let id = $(this).val();
			$("#movieReplyStar").val(id);
			let mv = $("#movieReplyStar").val();
			console.log(mv);
		});
		
		function insertReply() {
			$.ajax({
				url : "ajaxInsertMovieReply.do",
				dataType : "json",
				type : "post",
				data : {
					"movieNo" : $("#movieNo").val(),
					"movieReplyConent" : $("#movieReplyConent").val(),
					"movieReplyWriter" : $("#userName").val(),
					"movieReplyStar" : $("#movieReplyStar").val()
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
		
		function deleteReply(id) {
			$.ajax({
				url: "ajaxDeleteMovieReply.do",
				dataType: "text",
				type: "post",
				data: {"movieReplyNo":id},
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
				/* location.reload(); */
			});
		}
	</script>
</body>
</html>