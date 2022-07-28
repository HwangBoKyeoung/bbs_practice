<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 오늘 날짜 뽑아오기! -->
<c:set var="today" value="<%=new java.util.Date()%>" />
<c:set var="year"> <fmt:formatDate value="${today}" pattern="yyyy" /> </c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>WELCOME HOME</title>
</head>
<body>
	<select name="costDateYear" id="costDateYear">
		<option value="2019" <c:if test="${year=='2019'}">selected</c:if>>2019년</option>
		<option value="2020" <c:if test="${year=='2020'}">selected</c:if>>2020년</option>
		<option value="2021" <c:if test="${year=='2021'}">selected</c:if>>2021년</option>
		<option value="2022" <c:if test="${year=='2022'}">selected</c:if>>2022년</option>
	</select>
	<input type="hidden" id="costYear" name="costYear" />
	<div id="showChartDiv" align="center" style="margin-top: 50px; margin-bottom: 50px;">
		<canvas id="myChart" style="width:100%; max-width:1200px"></canvas>
	</div>
	
	<script>
		let indexArr = ['01', '02', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'];
		
		(function() {
			let yearVal = $("#costDateYear").val();
			console.log(yearVal);
			$("#costYear").val(yearVal);

			$.ajax({
				url: "ajaxCostChartValue.do",
				data: {"year":$("#costYear").val()},
				type: "post",
				dataType: "json",
				success: function(result){
					let x = []; //날짜
					let y = []; //비용합계
					
 					let nowYear = yearVal;

 					for(let i=0; i<indexArr.length; i++){
 						x.push(nowYear + indexArr[i]);
 					}
 					
 					for(let j=0; j<x.length; j++){
 						for(let k=0; k<result.length; k++){
 							let dateExtract = result[k].costDate;
 							let sumExtract = result[k].costSum;
 							
 							if(x[j] == dateExtract){
 	 							y[j] = sumExtract;
 	 						} 
 						}
 						if(y[j] == null || y[j] == "" || y[j] == 0){
 							y[j] = 0;
 						}
 					}

					new Chart("myChart", {
					  type: "line",
					  data: {
					    labels: x,
					    datasets: [{
					      fill: false,
					      lineTension: 0,
					      backgroundColor: "rgba(0,0,255,1.0)",
					      borderColor: "rgba(0,0,255,0.1)",
					      data: y
					    }]
					  },
					  options: {
					    legend: {display: false},
					    scales: {}
					  }
					});
				}
			});
		})();
	
		$("#costDateYear").on("change", function(){
			if($("#costYear").val() != null || $("#costYear").val() != ""){
				$("#costYear").val('');
			}
			
			let year = $(event.target).val();
			$("#costYear").val(year);
			$.ajax({
				url: "ajaxCostChartValue.do",
				data: {"year":$("#costYear").val()},
				type: "post",
				dataType: "json",
				success: function(result){
					let xValues = []; //날짜
					let yValues = []; //비용합계
					
 					let yearExtract = year;

 					for(let i=0; i<indexArr.length; i++){
 						xValues.push(yearExtract + indexArr[i]);
 					}
 					
 					for(let j=0; j<xValues.length; j++){
 						for(let k=0; k<result.length; k++){
 							let dateExtract = result[k].costDate;
 							let sumExtract = result[k].costSum;
 							
 							if(xValues[j] == dateExtract){
 	 							yValues[j] = sumExtract;
 	 						} 
 						}
 						if(yValues[j] == null || yValues[j] == "" || yValues[j] == 0){
 							yValues[j] = 0;
 						}
 					}

					new Chart("myChart", {
					  type: "line",
					  data: {
					    labels: xValues,
					    datasets: [{
					      fill: false,
					      lineTension: 0,
					      backgroundColor: "rgba(0,0,255,1.0)",
					      borderColor: "rgba(0,0,255,0.1)",
					      data: yValues
					    }]
					  },
					  options: {
					    legend: {display: false},
					    scales: {}
					  }
					});
				}
			});
		});
	</script>
</body>
</html>