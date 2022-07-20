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

        /* .container2 {
        	float: left;
        	width: 100%;
        	background: green;
        }
        
        .container1 {
        	float: left;
        	width: 100%;
        	background: blue;
        	position: relative;
        	right: 70%
        } */
        
        .one {
            text-align: center;
            height: 50px;
            background-color: red;
        }

        .two {
            float: left;
            width: 30%;
            background-color: yellow;
            height: 2000px;
            text-align: center;
            line-height: 2000px;
        }

        .three {
            float: left;
            width: 70%;
/*             height: 1000px; */
        }
        
        .four {
        	text-align: center;
            clear: both;
            /* height: 100px; */
            background-color: grey;
            height: 200px;
            line-height: 200px;
        }
        
    </style>
<title> <tiles:getAsString name="title" /> </title>
</head>
<body>
	<!-- <div class="container2">
		<div class="container1"> -->
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
		<!-- </div>
	</div> -->
</body>
</html>