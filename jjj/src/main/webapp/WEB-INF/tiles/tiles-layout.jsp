<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
        *{
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        div{
            overflow: hidden;
        }

        .one {
            text-align: center;
            height: 50px;
            background-color: red;
        }

        .two {
            float: left;
            height: 1000px;
            width: 30%;
            background-color: yellow;
        }

        .three {
            float: left;
            width: 70%;
            height: 1000px;
        }

        .four {
            float: clear;
            height: 100px;
            background-color: grey;
        }
    </style>
<title> <tiles:getAsString name="title" /> </title>
</head>
<body>
	<div class="one">
		<tiles:insertAttribute name="header" />
	</div>
	<div class="two">
		<tiles:insertAttribute name="left" />
	</div>
	<div class="three">
		<tiles:insertAttribute name="body" />
	</div>
	<div class="four">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>