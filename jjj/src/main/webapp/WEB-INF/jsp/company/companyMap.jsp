<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<h1 style="text-align: center;">포위즈시스템 오시는 길(대구)</h1> <br/>
	<div id="map" style="width: 80%; height: 500px; margin-left: 10%;">
	
	</div>

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9e46d4c14573f15bdc90d9870215de52"></script>
	<script>
		$(document).ready(function(){
			setZoomable(false);
		});
		
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(35.877696, 128.736007), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		var iwContent = '<div style="padding:5px;">포위즈시스템</div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
		iwPosition = new kakao.maps.LatLng(35.877696, 128.736007), //인포윈도우 표시 위치입니다
		iwRemoveable = true; // removeable 속성을 true 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

		// 인포윈도우를 생성하고 지도에 표시합니다
		var infowindow = new kakao.maps.InfoWindow({
			map : map, // 인포윈도우가 표시될 지도
			position : iwPosition,
			content : iwContent,
			removable : iwRemoveable
		});
		
		// 아래는 지도 확대, 축소기능
		function setZoomable(zoomable){
			map.setZoomable(zoomable);
		}

		// 아래 코드는 인포윈도우를 지도에서 제거합니다
		// infowindow.close();
	</script>
</body>
</html>