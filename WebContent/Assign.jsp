<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Task</title>
</head>
<body>
<h1>Assign task</h1>
<form action="astask" method="post">
<table>
<tr><td>
Title:</td><td> <input type="text" name="title"/></td>
</tr>
<tr><td>
Summary:</td><td><textarea name="summary" >Enter task summary</textarea></td>
</tr>
<tr><td></td><td>
<input type="submit" value="Assign"/></td></tr>
</table>
<input type="hidden" name="aid" value="${param.aid}"/>


</form>
</body>
</html>