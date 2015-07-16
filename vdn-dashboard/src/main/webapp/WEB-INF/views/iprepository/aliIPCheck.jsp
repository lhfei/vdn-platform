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
	    
	<%-- <script type="text/javascript" src="${basePath}/resources/bootstrap/bootgrid/jquery.bootgrid.min.js"></script> --%>
	
	<script type="text/javascript" src="${basePath}/resources/modules/iprepository/ipcheck/app.js"></script>
	
	<script type="text/javascript">
		/* $(function() {
			$("#grid-data").bootgrid({
			    ajax: true,
			    post: function () {
			        return {
			            ip: "b0df282a-0d67-40e5-8558-c9e93b7befed"
			        };
			    },
			    url: "getIpInfo.do?ips=123",
			    formatters: {
			        "link": function(column, row) {
			            return "<a href=\"#\">" + column.id + ": " + row.ip + "</a>";
			        }
			    }
			});	
		}) */ 
	
	</script>
</head>

<body>
	<!-- <table id="grid-data" class="table table-condensed table-hover table-striped">
	    <thead>
	        <tr>
	            <th data-column-id="ip" data-type="numeric">IP</th>
	            <th data-column-id="country">国家/地区</th>
	            <th data-column-id="region" data-order="desc">省份</th>
	            <th data-column-id="city" data-order="desc">城市</th>
	            <th data-column-id="county" data-order="desc">区县</th>
	            <th data-column-id="isp" data-order="desc">运行商</th>
	            
	            <th data-column-id="ip" data-formatter="link" data-sortable="false">城市</th>
	        </tr>
	    </thead>
	</table> -->
</body>
</html>