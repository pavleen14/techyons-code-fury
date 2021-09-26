<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HMeets | Login</title>
</head>
<body>
<form action="login" method="post">
<span>Email:<input type="text" name="email" value="${email}" required></span>
<br/>
<span>Password<input type="password" name="password" required></span>
<br/>
<span>${message}</span>
<input type="submit" value="Submit">


</form>
</body>
</html>