<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>
<%-- <c:set value="<%=sf.format(nowTime)%>" var="d1" /> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>WELCOME HOME</title>
<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
</head>
<body>
	<div align="center">
		<h1>=====WELCOME=====</h1>
		<form action="freeInsert.do" method="post" onsubmit="return submitPre();">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<tbody>
					<tr>
						<th>제목</th>
						<td><input type="text" maxlength="30" required
							name="freeTitle" /></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<c:choose>
								<c:when test="${userId == null}">
									<input type="text" maxlength="10" required name="freeWriter" />
								</c:when>
								<c:otherwise>
									<input type="text" readonly name="freeWriter" value="${userId}" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td><input type="date" min="<%=sf.format(nowTime)%>" max="<%=sf.format(nowTime)%>" required
							name="freeDate" /></td>
					</tr>
					<tr>
						<th>글종류</th>
						<td>
							<select name="freeNoticeYn" id="freeNoticeYn" class="form-control form-control-user" style="padding: 0; text-align: center;">
								<option value="1" selected>공지글</option>
								<option value="2">자유글</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>회원여부</th>
						<td>
							
							<select name="freeRegYn" id="freeRegYn" class="form-control form-control-user" style="padding: 0; text-align: center;">
								<c:choose>
									<c:when test="${userId != null || not empty userId}">
										<option value="1">회원</option>
									</c:when>
									<c:otherwise>
										<option value="2">비회원</option>
									</c:otherwise>
								</c:choose>
							</select>
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><div id="editor"></div></td>
					</tr>
					<tr style="display: none;">
						<td><textarea cols="100" rows="10" maxlength="500"
								name="freeContent" id="freeContent"></textarea></td>
					</tr>
				</tbody>
			</table>
			<br /> 
			<input type="submit" value="글등록" />
		</form>
	</div>
	
	<script>
        const Editor = toastui.Editor;

        const editor = new Editor({
            el: document.querySelector('#editor'),
            height: '500px',
            initialEditType: 'markdown',
            previewStyle: 'vertical'
        });

        editor.getMarkdown();
        
        function submitPre(){
        	let text = editor.getMarkdown();
            let content = document.querySelector("#freeContent");
            let inner = content.innerText;
            inner = text;
            
            alert(inner)
            return true;
        }
        
    </script>
</body>
</html>