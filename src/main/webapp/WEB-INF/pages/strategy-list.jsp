<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of Strategies</title>
<link type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet"/>
<link type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap-3.1.1/css/bootstrap-theme.min.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.0.min.js"></script>
</head>
<body>
<h1>List of strategies</h1>
<p>Here you can see the list of the strategies, edit them, remove or update.</p>
<table class="table table-striped" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="10%">id</th><th width="15%">name</th><th width="10%">type</th><th width="10%">actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="strategy" items="${strategies}">
<tr>
	<td>${strategy.id}</td>
	<td>${strategy.name}</td>
	<td>${strategy.type}</td>
	<td>
	<a href="${pageContext.request.contextPath}/strategy/edit/${strategy.id}.html">Edit</a><br/>
	<a href="${pageContext.request.contextPath}/strategy/delete/${strategy.id}.html">Delete</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>

<p><a href="${pageContext.request.contextPath}/index.html">Home page</a></p>

</body>
</html>