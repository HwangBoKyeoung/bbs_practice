<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
<!-- Editor's Style -->
<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<title>WELCOME HOME</title>
</head>
<body>
	<div>
		<!-- Begin Page Content -->
		<div class="container-fluid">
			<div id="editor"></div>
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->

	<script>
		const editor = new Editor({
		  el: document.querySelector('#editor'),
		  height: '500px',
		  initialEditType: 'markdown',
		  previewStyle: 'vertical'
		});

		editor.getMarkdown();
	</script>
</body>
</html>

