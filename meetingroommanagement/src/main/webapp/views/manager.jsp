<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome manager</h1>
	<h3>Enter meeting details</h3>
	<form action="ManagerServletController" method="post">
	HI!!
		<table>
		<tr>
		<td>Title</td><td><input type="text" name="title" id="title"></td>
		</tr>
		
		<tr>
		<td>Date and Start time</td><td> <input type="datetime-local" name="stime" id="time"></td>
		</tr>
		<tr>
		<td>Date and End time</td><td> <input type="datetime-local" name="etime" id="time"></td>
		</tr>
		<tr>
		<td>Duration of meeting in minutes</td><td><input type="number" name="duration" id="duration"></td>
		</tr>
		<tr>
		<td>Select meeting type</td>
		<td>
		<select name="meettype" id="meet">
  			<option value="classroom">Classroom Training</option>
  			<option value="online">Online Training</option>
  			<option value="conference">Conference call</option>
 			<option value="business">Business</option>
 		</select>
		</td>
		</tr>
		<tr>
		<td><input type="submit"></td>
		</tr>
		</table>
	</form>
</body>
</html>