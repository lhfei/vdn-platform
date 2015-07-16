<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%
	String rootPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	String startbootstrap = rootPath + "/resources/bootstrap/startbootstrap/"; 	
	
	request.setAttribute("rootPath", rootPath);
	request.setAttribute("startbootstrap", startbootstrap);
	
%>
	
    <!-- Bootstrap Core CSS -->
    <link href="${rootPath}/resources/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${startbootstrap}/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="${startbootstrap}/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${startbootstrap}/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${startbootstrap}/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${startbootstrap}/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">



    <!-- jQuery -->
    <script src="${startbootstrap}/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${startbootstrap}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${startbootstrap}/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${startbootstrap}/bower_components/raphael/raphael-min.js"></script>
    <script src="${startbootstrap}/bower_components/morrisjs/morris.min.js"></script>
    <script src="${startbootstrap}/js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${startbootstrap}/dist/js/sb-admin-2.js"></script>
    