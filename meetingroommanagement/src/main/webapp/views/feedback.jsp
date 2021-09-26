<%@page import="com.hsbc.meets.entity.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e"%>
<!DOCTYPE html>

    
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>FEEDBACK FORM</h2>
<%
	String room = (String) request.getAttribute("roomId");
	pageContext.setAttribute("room", room); 
%>
<h3>Fill the feedback form for room id: ${ room }</h3>
<form action="feedback" method="post" >

<input type="hidden" name="roomId" value="${room}" />
</br>
<span>Rating:<input type="number" name="rating" required></span>
</br>
<span>Comments:<input type="text" name="comment" required></span>
</br>
<span>${message}</span>
<input type="submit" value="Submit">
 

</form>
</html>