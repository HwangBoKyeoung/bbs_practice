<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Error</title>
</head>

<body>
	<div align="center" style="width: 100%; height: 500px; background-color: red; font-size: 80px; color: white; line-height: 500px;">
    	<spring:message code='security.common.msg' />
    </div>
    <script>
    	alert("<spring:message code='security.common.msg' />");
    </script>
</body>
</html>