<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../commons/extjs4.jsp"></jsp:include>
<jsp:include page="../commons/bootstrap.jsp"></jsp:include>
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

<script type="text/javascript"
	src="${basePath}/resources/modules/configure/globalConf/app.js"></script>

<script type="text/javascript">
	
	</script>
</head>

<body>
	<div id="global-div" class="x-hide-display">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="email"
						placeholder="Enter email">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd"
						placeholder="Enter password">
				</div>
			</div>
		</form>
	</div>

	<div id="hdfs-div" class="x-hide-display">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">HDFS URL:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="hdfsUrl" name="hdfsurl" value="${global.hdfs['HDFS_URL'] }" 
					placeholder="Hadoop REST 服务URL, 默认为 http://114.80.177.144:50070/">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Web HDFS URL:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="webUrl" name="WEBHDFS_DEFAULT_URL" value="${global.hdfs['WEBHDFS_DEFAULT_URL'] }"
						placeholder="'Hadoop REST 默认操作, webhdfs/v1/?op=LISTSTATUS.">
				</div>
			</div>
		</form>
	</div>



	<div id="ipserver-div" class="x-hide-display">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">IPServer URL:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="ipserver-url" name="ipserver-url" value="${global.ipServer['IPSERVER_URL'] }"
						placeholder="IPServer的URL地址,默认值为 http://123.103.58.182/ipbase/ipserver/ipArea">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">File Location:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="iparea_file_location" name="IPAREA_FILE_LOCATION" value="${global.ipServer['IPAREA_FILE_LOCATION'] }"
						placeholder="IPArea txt 文件本地存储目录, 默认为 /home/cloudland/app_data/ipArea.txt.">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">File Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="iparea_file_name" name="iparea_file_name" value="${global.ipServer['IPAREA_FILE_NAME'] }"
						placeholder="IPArea txt 文件名称, 默认ipArea.txt.">
				</div>
			</div>			
		</form>
	</div>

</body>
</html>