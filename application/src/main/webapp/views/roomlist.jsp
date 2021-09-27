<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/meetingroommanagement/css/style.css">
    <title>All Rooms</title>
</head>

<body id="page-container">
<%@page import="java.util.*, com.hsbc.meets.entity.*" %>
<%
	User user = (User)request.getSession().getAttribute("user");
	pageContext.setAttribute("user", user); 

    List<MeetingRoom> room = (List<MeetingRoom>)request.getAttribute("elist");
    pageContext.setAttribute("room", room);
   
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
                <div class="collapse navbar-collapse" id="navbarButtons">
                    <div class="me-auto"></div>
                    <!-- <small class="text-info me-4">Link</small> -->
                    <ul class="align-nav-item">
                        <img src="/meetingroommanagement/resources/images/icon_user.png" height="16" alt="" class="me-1" />
                        <small class="text-white me-4">Hi! ${user.name}</small>
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
        <div class="row m-3" id="roomdetails">
        <e:forEach items="${room}" var="room">
            <e:set var="eid" value="${room.meetingRoomId}" />
		        <div class="card-container col-xl-2 col-lg-3 col-md-3 col-sm-4">
		            <div class="card-body rounded-4">
		                <h5 class="card-title mb-4">${room.meetingRoomName}</h5>
		                <h6 class="card-subtitle text-black">Seating Capacity</h6>
		                <p class="text-muted">${room.seatingCapacity} participants</p>
		                <h6 class="card-subtitle text-black">Per hour cost</h6>
		                <p>${room.creditsPerHour} Credits</p>
		                <h6 class="card-subtitle text-black">Rating: </h6>
		                <p>${room.rating} (${ room.noOfFeedbacks })</p>
		                <a href="/meetingroommanagement/admin?option=edit&&room=${room.meetingRoomId}">
		                    <div class="text-end">
		                        <span style="border-radius: 20px;" class="text-center px-4 pt-1 pb-2 bg-info">
		                            <img src="/meetingroommanagement/resources/images/icon_edit.png" height="16" alt="">
		                        </span>
		                    </div>
		                </a>
		            </div>
		        </div>
	        </e:forEach>
        </div>
    </main>

    <!--Footer-->
    <footer id="footer">
        <div>
            <hr class="my-2">
        </div>
        <div class="footer-copyright d-flex align-items-center justify-content-center">
            © 2021 Copyright: HSCC Meettings
        </div>
    </footer>
    <!--/.Footer-->

    <!--scripts-->
    <script src="/meetingroommanagement/scripts/scripts.js"></script>
    
    <!--scripts-->
</body>

</html>