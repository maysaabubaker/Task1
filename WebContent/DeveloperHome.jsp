<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/task1/home.css" type="text/css">
<link rel="stylesheet" href="/task1/header.css" type="text/css">
<link rel="stylesheet" href="/task1/sidebar.css" type="text/css">


<title>Developer Home</title>
</head>
<body>

<h1>User Tasks</h1>
<table border=1>
<tr><th>Task Id</th>
<th>Title</th>
<th>Summary</th>
<th>Status</th>
<th></th>
</tr>
<c:forEach var="task" items="${userTasks}">
<c:if test="${task.status != 'waiting leader'}">
<tr>
<td>${task.tid}</td>
<td>${task.title}</td>
<td>${task.summary}</td>
<td>${task.status}</td>
<td>
<form method="POST"
action="changeStatus">
<c:choose>
<c:when test="${task.status=='in progress'}">
<input type=radio name=cstat checked value="in progress"/> in progress<br>
<input type=radio name=cstat  value="done"/> done<br>
<input type=radio name=cstat  value="completed"/>completed<br>
</c:when>
<c:when test="${task.status=='done'}">
<input type=radio name=cstat  value="in progress"/> in progress<br>
<input type=radio name=cstat checked value="done"/> done<br>
<input type=radio name=cstat  value="completed"/>completed<br></c:when>
<c:when test="${task.status=='completed'}">
<input type=radio name=cstat  value="in progress"/> in progress<br>
<input type=radio name=cstat  value="done"/> done<br>
<input type=radio name=cstat  checked value="completed"/>completed<br>
</c:when>
<c:otherwise>
<input type=radio name=cstat  value="in progress"/> in progress<br>
<input type=radio name=cstat  value="done"/> done<br>
<input type=radio name=cstat  value="completed"/>completed<br>
</c:otherwise>
</c:choose>

<br>
<center>
<button name="tid" value="${task.tid}">Change Status</button>
</center>
<br>
</form>
</td>

</tr>
</c:if>
</c:forEach>
</table>
<h1>Pending Tasks</h1>
<table border=1>
<tr><th>Task Id</th>
<th>Title</th>
<th>Summary</th>
</tr>
<c:forEach var="task" items="${userTasks}">
<c:if test="${task.status == 'waiting leader'}">
<tr>
<td>${task.tid}</td>
<td>${task.title}</td>
<td>${task.summary}</td>

</tr>
</c:if></c:forEach>
</table>
<br>
<button onclick="location.href = 'addTask.html';">Add Task</button>
<button onclick="location.href = 'logout';">Logout</button>
<button onclick="location.href = 'profile';">View Profile</button>


</body>
</html>
