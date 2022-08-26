<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set
	value="${pageContext.request.contextPath}/file/fullcalendar-4.4.0/packages"
	var="path" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='${path}/core/main.css' rel='stylesheet' />
<link href='${path}/daygrid/main.css' rel='stylesheet' />
<link href='${path}/timegrid/main.css' rel='stylesheet' />

<script src='${path}/core/main.js'></script>
<script src='${path}/interaction/main.js'></script>
<script src='${path}/daygrid/main.js'></script>
<script src='${path}/timegrid/main.js'></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	document.addEventListener('DOMContentLoaded', function() {
		$.ajax({
			url : "ajaxCalendarInfo.do",
			type : "post",
			dataType : "json",
			async : false,
			success : function(result) {
				printCalendarValue(result);
			},
			error : function(err) {
				console.log(err);
			}
		});
		
		function printCalendarValue(data){
			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				plugins : [ 'interaction', 'dayGrid', 'timeGrid' ],
				header : {
					left : 'prev,next today',
					center : 'title',
					right : 'dayGridMonth,timeGridWeek,timeGridDay'
				},
				defaultDate : '2022-08-25',
				navLinks : true, // can click day/week names to navigate views
				selectable : false,
				selectMirror : true,
				select : function(arg) {
					var title = prompt('Event Title:');
					if (title) {
						calendar.addEvent({
							title : title,
							start : arg.start,
							end : arg.end,
							allDay : arg.allDay
						})
					}
					calendar.unselect()
				},
				editable : true,
				eventLimit : true,
			// allow "more" link when too many events
				events: data
			});

			calendar.render();
		}
		
	});
</script>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}
body {
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 50px auto;
}
</style>
</head>
<body>
	<div id='calendar'></div><br/>
	<div align="center">
		<button onclick="location.href='home.do'" style="border: none; background-color: red; color: white; font-weight: bold; width: 800px; height: 100px;">목록으로</button>
	</div>
</body>
</html>
