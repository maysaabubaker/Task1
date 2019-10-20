<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leader Home</title>
</head>
<body>
Hi ${username}<br>
<h1>Leader Tasks</h1>
<table border=1>
<tr><th>Task Id</th>
<th>Title</th>
<th>Summary</th>
<th>Status</th>
<th></th>
</tr>
<c:forEach var="task" items="${userTasks}">
<c:if test="${task.status != 'waiting manager'}">
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
<br>
<h1>Pending Tasks</h1>
<table border=1>
<tr><th>Task Id</th>
<th>Title</th>
<th>Summary</th>
</tr>
<c:forEach var="task" items="${userTasks}">
<c:if test="${task.status == 'waiting manager'}">
<tr>
<td>${task.tid}</td>
<td>${task.title}</td>
<td>${task.summary}</td>

</tr>
</c:if>
</c:forEach>
</table>
<br>
<h1>Developers</h1>
<table border=1>
<tr>
<th>Name</th>
<th>Tasks</th>
</tr>
<c:forEach var="developer" items="${developers}">
<tr>
<tr>
<td>${developer.name}</td>

<td>
<form action="vtask" method="post">
<button name="pid"  value="${developer.id}">View Tasks</button>
</form>
</td>

<td>
<form action="Assign.jsp" method="post">
<button name="aid"  value="${developer.id}">Assign Task</button>
</form>
</td>

</tr>
</c:forEach>
</table>
<br><br>
<c:if test="${empty vtask}">
<table border=1>
<tr><th>Task Id</th>
<th>Title</th>
<th>Summary</th>
<th>Status</th>
</tr>
<c:forEach var="task" items="${vtasks}">
<tr>
<td>${task.tid}</td>
<td>${task.title}</td>
<td>${task.summary}</td>
<td>
<c:choose>
<c:when test="${task.status!='waiting leader'}">
${task.status}
</c:when>
<c:when test="${task.status=='waiting leader'}">
<form action="atask" method="post">
<button name="accept"  value="${task.tid}">accept</button></form>
<form action="rtask" method="post">
<button name="reject"  value="${task.tid}">reject</button>
</form>
</c:when>
</c:choose>
</td>
</tr>
</c:forEach>
</table>
</c:if>
<br>
<button onclick="location.href = 'addTask.html';">Add Task</button>
<button onclick="location.href = 'logout';">Logout</button>
<button onclick="location.href = 'profile';">View Profile</button>

</body>
</html>