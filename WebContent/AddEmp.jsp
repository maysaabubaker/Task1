<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="home.css" type="text/css">
<style>
table td, table th {border: none;}
</style>
<title>Add Employee</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="card">
<div class="content">
<h1>Add Employee</h1>
<form method="post" action="newemp">
<table >
<tr>
<td>Username:</td>
<td><input type="text" name="username"/></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td>First Name:</td>
<td><input type="text" name="fname"/></td>
</tr>
<tr>
<td>Last Name:</td>
<td><input type="text" name="lname"/></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="address"/></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="email" name="email"/></td>
</tr>
<tr>
<td>Phone number:</td>
<td><input type="text" name="phone"/></td>
</tr>
<tr>
<td>Level:</td>
<td><select name="level">
<option value="2">Team Leader</option>
<option value="3">Developer</option>
</select></td>
</tr>
<tr>
<td></td>
<td>
<button type="submit">Add Employee</button> 
</td>
</tr>
</table>
</form>
</div>
</div>
</body>
</html>