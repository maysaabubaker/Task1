<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
</head>
<body>
<h1>Personal Information</h1>
<table>
<tr>
<td>First Name:</td>
<td>${person.fname}</td>
</tr>

<tr>
<td>Last Name:</td>
<td>${person.lname}</td>
</tr>

<tr>
<td>Address</td>
<td>${person.address}</td>
</tr>

<tr>
<td>Email</td>
<td>${person.email}</td>
</tr>

<tr>
<td>Phone Number</td>
<td>${person.phonenumber}</td>
</tr>

<tr>
<td>Level</td>
<td>${person.level}</td>
</tr>

</table>
</body>
</html>