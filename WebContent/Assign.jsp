<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Task</title>
<link rel="stylesheet" href="home.css" type="text/css">
<style>
table td, table th {border: none;}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="card">
<div class="content">
<h1>Assign task</h1>
<form action="astask" method="post">
<table>
<tr><td>
Title:</td><td> <input type="text" name="title"/></td>
</tr>
<tr><td>
Summary:</td><td><textarea name="summary" ></textarea></td>
</tr>
<tr><td></td><td>
<button type="submit">Assign Task</button> </td></tr>
</table>
<input type="hidden" name="aid" value="${param.aid}"/>
</form>
</div>
</div>
</body>
</html>