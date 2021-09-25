<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%@page import="java.util.*, com.hsbc.meets.entity.*" %>
<%
    MeetingRoom room = (MeetingRoom) request.getAttribute("room");
    pageContext.setAttribute("room", room);
    List<String> amenities = (List<String>) request.getAttribute("amenities");
    pageContext.setAttribute("amenities", amenities);
%>
<h3>Edit the Meeting Room !</h3>
<form action="meetingroom" method="POST">
   Meeting Room ID : 
   <input type="text" name="mid" value="${room.meetingRoomId}" readonly><br>
   Meeting Room Name : 
   <input type="text" name="mname" value="${room.meetingRoomName}"><br>
   Capacity of the Room : 
   <input type="number" name="mcapacity" value="${room.seatingCapacity}"><br>
   
   <e:forEach items="${amenities}" var="amenity">
	   <input type="checkbox"  name="amenities" value="${amenity}"> ${amenity}    
   </e:forEach>
   <input type ="submit" value ="Update">  
   <!-- this has to look like a button -->
   <input type = "hidden" name="editflag" value="true"/>
   <a href="admin.jsp">Cancel</a>
  
</form>
<p>
</body>
</html>