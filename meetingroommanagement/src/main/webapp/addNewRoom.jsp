<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%@page import="java.util.*, com.hsbc.meets.entity.*" %>
<%
    List<String> amenities = (List<String>) request.getAttribute("amenities");
    pageContext.setAttribute("amenities", amenities);
%>
<h3>Fill in the details to add new meeting room !</h3>
<form action="http://localhost:8080/meetingroommanagement/meetingroom" method=POST>
   Meeting Room Name : 
   <input type="text" name="mname"><p>
   Capacity of the Room : 
   <input type="text" name="mcapacity"><p>
   
   Amenities : <p>
   <e:forEach items="${amenities}" var="amenity">
	   <input type="checkbox"  name="amenities" value="${amenity}"> ${amenity}    
   </e:forEach>
   <input type ="submit" value ="Add New Room">  

</form>
<p>
</body>
</html>