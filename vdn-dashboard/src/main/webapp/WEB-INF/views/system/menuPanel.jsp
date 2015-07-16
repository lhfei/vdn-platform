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

<title>Dashboard Template for Bootstrap</title>

	<!-- Custom styles for this template -->
	<link href="${basePath }/resources/css/system/grid.css" rel="stylesheet">
	
	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	<script src="${bootstrapRoot}/assets/js/ie-emulation-modes-warning.js"></script>
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    
	<script type="text/javascript" src="${basePath}/resources/modules/hdfs/liststatus/app.js"></script>
</head>

<body>

	<input id="urlHistory" type="hidden" value="${sessionScope['WEBHDFS_URL_HISTORY']}">
<!--     <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th></th>
                    <th>
                        Extra small devices
                        <small>Phones (&lt;768px)</small>
                    </th>
                    <th>
                        Small devices
                        <small>Tablets (&ge;768px)</small>
                    </th>
                    <th>
                        Medium devices
                        <small>Desktops (&ge;992px)</small>
                    </th>
                    <th>
                        Large devices
                        <small>Desktops (&ge;1200px)</small>
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>Grid behavior</th>
                    <td>Horizontal at all times</td>
                    <td colspan="3">Collapsed to start, horizontal above breakpoints</td>
                </tr>
                <tr>
                    <th>Max container width</th>
                    <td>None (auto)</td>
                    <td>750px</td>
                    <td>970px</td>
                    <td>1170px</td>
                </tr>
                <tr>
                    <th>Class prefix</th>
                    <td>
                        <code>.col-xs-</code>
                    </td>
                    <td>
                        <code>.col-sm-</code>
                    </td>
                    <td>
                        <code>.col-md-</code>
                    </td>
                    <td>
                        <code>.col-lg-</code>
                    </td>
                </tr>
                <tr>
                    <th># of columns</th>
                    <td colspan="4">12</td>
                </tr>
                <tr>
                    <th>Max column width</th>
                    <td class="text-muted">Auto</td>
                    <td>60px</td>
                    <td>78px</td>
                    <td>95px</td>
                </tr>
                <tr>
                    <th>Gutter width</th>
                    <td colspan="4">30px (15px on each side of a column)</td>
                </tr>
                <tr>
                    <th>Nestable</th>
                    <td colspan="4">Yes</td>
                </tr>
                <tr>
                    <th>Offsets</th>
                    <td colspan="4">Yes</td>
                </tr>
                <tr>
                    <th>Column ordering</th>
                    <td colspan="4">Yes</td>
                </tr>
            </tbody>
        </table>
    </div> -->
</body>
</html>