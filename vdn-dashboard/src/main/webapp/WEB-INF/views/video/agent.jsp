<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<jsp:include page="../commons/extjs4.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>${globalTitle}</title>
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	
	<!-- HighCharts libs. -->
	<script src="${basePath}/resources/bootstrap/3.3.4/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${basePath}/resources/highcharts4/js/highcharts.js"></script>
	<script src="${basePath}/resources/highcharts4/js/modules/exporting.js"></script>
	
	<script type="text/javascript" src="${basePath}/resources/modules/video/agent/app.js"></script>
</head>

<body>

	<!-- VDN 可行性统计汇总 -->
	<div id="avlbChart" style="height: 300px" ></div>
	
	
	<!-- VDN 可用性分时统计概况 -->
	<div id="avlbSumChart" ></div>
	
	<!-- VDN 请求样本数统计汇总 -->
	<div id="vdnSummaryChart" ></div>
	
	<!-- VDN 流畅度统计汇总 -->
	<div id="fluentChart" ></div>
	
	<!-- VDN 播放不完整统计汇总 -->
	<div id="incompleteChart" ></div>
	
	
	
</body>
</html>