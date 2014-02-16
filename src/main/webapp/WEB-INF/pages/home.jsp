<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Home page</title>
<link type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-3.1.1/css/bootstrap-theme.min.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.min.js"></script>
</head>
<body>
<h1>Home page</h1>
<p>
${message}<br/>
<a href="${pageContext.request.contextPath}/strategy/add.html">Add New Strategy</a><br/>
<a href="${pageContext.request.contextPath}/strategy/list.html">Strategy list</a><br/>
</p>
</body>
</html>