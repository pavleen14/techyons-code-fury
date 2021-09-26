<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- @author shalaka --%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.hsbc.meets.entity.MeetingRoom" %>

<%ArrayList<MeetingRoom> li = new ArrayList<MeetingRoom>();
li=(ArrayList)request.getAttribute("MeetingRoomList");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome manager</h1>
	<h3>Enter meeting details</h3>
	
	hello selectmeeting room .jsp<br>
	
	<form action="SelectMeetingRoomController" method="post">
	<table border=1 >
	
	<tr>
	<td><b>Choose</b></td>
	<td><b>Room name</b></td>
	<td><b>Room capacity</b></td>
	<td><b>Room perhourcost</b></td>
	<td><b>Room rating</b></td>
	<td><b>Room number of feedbacks</b></td>
	<td><b>Amenities</b></td>
	</tr>
	
	 
	
	
	<%	int row=1;
		for(int i=0;i<li.size();i++){
			MeetingRoom m=li.get(i);
			String name=m.getMeetingRoomName(); %>
			<tr>
			<td><input type="radio" id="html" name="fav_language" value=name></td>
			<label for=name>
			<td style="text-align:center"><% out.println(name); %></td></label>
			<td style="text-align:center"><% out.println(m.getSeatingCapacity()); %></td>
			<td style="text-align:center"><% out.println(m.getCreditsPerHour()); %></td>
			<td style="text-align:center"><% out.println(m.getRating()); %></td>
			<td style="text-align:center"><% out.println(m.getNoOfFeedbacks()); %></td>
			<td>
			<ul>
			<% List<String> amenities=m.getAmenities();
			for(int j=0;j<amenities.size();j++)
			{ %>
				<li><% out.println(amenities.get(j)); %></li>
			<% } %>
			</ul>
			</td>
			
			</tr>
		<% }
	
	%>
	

	
	</table>
	<br><br>
	<input type="submit" name="submit">
	</form>
</body>
</html>