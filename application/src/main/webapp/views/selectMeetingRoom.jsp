<%@page import="com.hsbc.meets.entity.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e"%>
<%-- @author shalaka --%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.hsbc.meets.entity.MeetingRoom" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/meetingroommanagement/css/style.css">
    <title>Available Rooms</title>
</head>

<body id="page-container">
<%
	List<MeetingRoom> rooms = (List<MeetingRoom>)request.getAttribute("rooms");
	pageContext.setAttribute("rooms", rooms);
    User user = (User)request.getSession().getAttribute("user");
    pageContext.setAttribute("user", user); 
   
%>
    <header>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg bg-dark" style="height: 8vh">
            <div class="container">
                <!-- Logo -->
                <img src="/meetingroommanagement/resources/images/logo.png" height="30" alt="" />
                <h4 class="text-white ms-4 my-auto">HMeets</h4>
                <!-- Logo -->

                <!-- Menu button -->
                <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#navbarButtons" aria-controls="navbarButtons" aria-expanded="true" aria-label="Toggle navigation">
                    <img src="/meetingroommanagement/resources/images/icon_menu.png" height="22" alt="" class="me-1" />
                </button>
                <!-- Menu button -->

                <!-- Nav Items -->
                <div class="collapse navbar-collapse align-items-center" id="navbarButtons">
                    <div class="me-auto"></div>
                    <!-- <small class="text-info me-4">Link</small> -->
                    <ul class="align-nav-item">
                        <img src="/meetingroommanagement/resources/images/icon_user.png" height="16" alt="" class="me-1" />
                        <small class="text-white me-4">Hi! ${ user.name }</small>
                    </ul>
                    <ul class="align-nav-item">
                        <a href="login?op=logout">
                            <button type="button" class="btn btn-outline-info" data-mdb-ripple-color="dark">
                                Logout
                            </button>
                        </a>
                    </ul>
                    <!-- </div> -->
                </div>
                <!-- Nav Items -->
            </div>
        </nav>
        <!-- Navbar -->
    </header>

    <main id="content-wrap">
        <div class="container-fluid h-custom">
            <div class="row">
                <section class="col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                        <p class="lead mx-3">Available Meeting Rooms</p>
                    </div>
                    <!-- Meeting Rooms -->
                    <e:forEach items="${rooms}" var="room">
                        <e:set var="eid" value="${room.meetingRoomId}" />
                        <div class="card-container">
                            <div class="card-body rounded-4">
                                <div class="row">
                                    <div class="col-md-6 mb-2">
                                        <h5 class="card-title">${room.meetingRoomName}</h5>
                                    </div>
                                    <div class="col-md-3">
                                        <h6 class="card-subtitle text-black">Capacity</h6>
                                        <p>${room.seatingCapacity} members</p>
                                    </div>
                                    <div class="col-md-3">
                                        <h6 class="card-subtitle text-black">Rating</h6>
                                        <p>${room.rating} stars</p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <h6 class="card-subtitle text-black">Amenities: </h6>
                                        <p class="text-muted">${room.amenities}</p>
                                    </div>
                                    <div class="col-md-3">
                                        <h6 class="card-subtitle text-black">Per Hour Cost</h6>
                                        <p>${room.creditsPerHour} Credits</p>
                                    </div>
                                    <div class="col-md-3">
                                    	<form action="http://localhost:8080/meetingroommanagement/meeting/members" method="POST">
                                    		<input type="hidden" name="roomId" value="${room.meetingRoomId}">
                                    		<input type="hidden" name="roomName" value="${room.meetingRoomName}">
                                    		<input type="hidden" name="roomCapacity" value="${room.seatingCapacity}">
	                                    	<button type="submit" class="btn btn btn-primary">
	                                            Select Room
	                                        </button>
                                    	</form>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </e:forEach>
                    <!-- Meeting Rooms -->
                </section>
            </div>
        </div>
    </main>

    <!--Footer-->
    <footer id="footer">
        <div>
            <hr class="my-2">
        </div>
        <div class="footer-copyright d-flex align-items-center justify-content-center">
            � 2021 Copyright: HSCC Meettings
        </div>
    </footer>
    <!--/.Footer-->

    <!--scripts-->
    <script src="/meetingroommanagement/scripts/scripts.js"></script>
    
    <script>
    
    	func formSubmit(roomId){
    		let xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
    		let theUrl = "http://localhost:8080/meetingroommanagement/meetingroom/members";
    		xmlhttp.open("POST", theUrl);
    		xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    		xmlhttp.send(JSON.stringify({"mid" : roomId}));	
    	}
	    
    </script>
    <!--scripts-->
</body>

</html>