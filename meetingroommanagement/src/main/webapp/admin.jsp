<%@page import="com.hsbc.meets.entity.User"%>
<%@page import="javax.servlet.descriptor.JspPropertyGroupDescriptor"%>
<html>
<body>
<%
    User user = (User)request.getSession().getAttribute("user");
    pageContext.setAttribute("user", user); 
%>
<h1> Welcome to Meeting Room Management Admin</h1>
<h3> Name: ${user.name}</h3>
<h3> Email: ${user.email}</h3>
   <a href="/meetingroommanagement/meetingroom" >View Available Meeting Rooms</a><p>
    <form>
         <input type="button" onclick="window.location.href = 'http://localhost:8080/meetingroommanagement/admin?option=create'" value="Add Meeting Room"/>
     </form>
</body>
</html>