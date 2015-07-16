<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<jsp:include page="WEB-INF/views/commons/extjs4.jsp"></jsp:include>

<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String bootstrapRoot = basePath + "/resources/bootstrap/3.3.4/"; 	
	request.setAttribute("basePath", basePath);
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<!-- Bootstrap core JavaScript
		    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="${basePath}/resources/bootstrap/3.3.4/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${basePath}/resources/highcharts4/js/highcharts.js"></script>

	<script type="text/javascript">
	
	$(function () {
		
		$.ajax({
			url: 'ipserver/123.103.58.147/read.do',
			success: function(response) {
				
				var ts = [],
					total = [],
					request = [],
					live = [];
				
				$.map(response.data, function(val, i){
					ts[i] = val.create_time
					total[i] = val.total;
					request[i] = val.request_total;
					live[i] = val.live_total;
				})
				
			    $('#container').highcharts({
			        chart: {
			            type: 'line'
			        },

			        xAxis: {
			            categories: ts
			        },

			        series: [{
			        	name: 'Total',
			        	color: '#00FF00',
			        	data: total
			        },{
			        	name: '点播',
			        	color: '#FF00CC',
			        	data: request
			        }, {
			        	name: '直播',
			        	color: '#AA00FF',
			        	data: live
			        }]
			        
			    });
				
			}
		});
		
		
		var win = Ext.create('widget.window', {
            title: 'Layout Window with title <em>after</em> tools',
            closable: true,
			
            maximizable: true,
            maximized: true,
            minimizable: true,
            modal: true,
            layout: 'fit',
            
            contentEl: 'container'
		});
		
		win.show();
		
	});
</script>	
	
	</head>


<body>
<div id="container" style="height: 100%" class="x-hide-display"></div>
</body>
</html>
