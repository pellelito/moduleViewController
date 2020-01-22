<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="main.css">
<title>LogIn</title>
</head>
<body>
<div><h1>Login</h1></div>
<div>
<form action="ControllerServlet" method="post">
Username:<input type="text" name="name"><br>
Password: <input type="password" name="password"><br>
<input type="submit" value="Login">
</form>
</div>
</body>
</html>