    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="sidebar.css" type="text/css">


<title>Developer Home</title>
</head>
<body>
		<ul class="mcd-menu">
			
			<li>
				<a href="profile" class="${pageContext.request.requestURI eq '/task1/profile.jsp' ? ' active' : ''}">
					<i class="fa fa-edit"></i>
					<strong>Profile</strong>
				</a>
			</li>
			<c:choose>
			<c:when test="${level==1}">
			<li>
				<a href="mhome" class="${pageContext.request.requestURI eq '/task1/ManagerHome.jsp' ? ' active' : ''}">
					<i class="fa fa-gift"></i>
					<strong>Tasks</strong>
				</a>
			</li>
			</c:when>
			<c:when test="${level==2}">
			<li>
				<a href="lhome" class="${pageContext.request.requestURI eq '/task1/LeaderHome.jsp' ? ' active' : ''}">
					<i class="fa fa-gift"></i>
					<strong>Tasks</strong>
				</a>
			</li>
			</c:when>
			<c:when test="${level==3}">
			<li>
				<a href="dhome" class="${pageContext.request.requestURI eq '/task1/DeveloperHome.jsp' ? ' active' : ''}">
					<i class="fa fa-gift"></i>
					<strong>Tasks</strong>
				</a>
			</li>
			</c:when>
			</c:choose>
			
			<li>
				<a href="addTask.jsp" class="${pageContext.request.requestURI eq '/task1/addTask.jsp' ? ' active' : ''}">
					<i class="fa fa-globe"></i>
					<strong>Add Task</strong>
				</a>
			</li>
			<c:if test="${level==1}">
			<li>
				<a href="AddEmp.jsp" class="${pageContext.request.requestURI eq '/task1/AddEmp.jsp' ? ' active' : ''}">
					<i class="fa fa-globe"></i>
					<strong>Add Employee</strong>
				</a>
			</li>
			</c:if>
		</ul>

	</body>