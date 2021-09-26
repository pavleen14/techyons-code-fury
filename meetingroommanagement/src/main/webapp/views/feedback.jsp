<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

    
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>FEEDBACK FORM</h2>
<%String room = request.getParameter("roomId");%>
<h3>Fill the feedback form for room id: <%=room %></h3>
<form action="feedback" method="post" >

<input type="hidden" name="roomId" value="${room}" />
</br>
<span>Rating:<input type="text" name="rating" value="${rating}" required></span>
</br>
<span>Comments:<input type="text" name="comment" required></span>
</br>
<span>${message}</span>
<input type="submit" value="Submit">
 

</form>
</html>