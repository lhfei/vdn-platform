<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String bootstrapRoot = basePath + "/resources/bootstrap/3.3.4/"; 	
	request.setAttribute("basePath", basePath);
	request.setAttribute("bootstrapRoot", bootstrapRoot);
	
	request.setAttribute("globalTitle", "VDN Data Thinker");
%>

	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="${bootstrapRoot}/css/bootstrap.min.css">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="${bootstrapRoot}/css/bootstrap-theme.min.css">

	
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
    <script src="${bootstrapRoot}/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="${bootstrapRoot}/js/bootstrap.min.js"></script>	
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="${bootstrapRoot}/assets/js/vendor/holder.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${bootstrapRoot}/assets/js/ie10-viewport-bug-workaround.js"></script>