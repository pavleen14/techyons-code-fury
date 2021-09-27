<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e"%>
<%@ page import="com.hsbc.meets.entity.User"%>
<%@ page import="com.hsbc.meets.entity.Meeting"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/meetingroommanagement/css/style.css">
    <title>Manager | HMeets</title>
</head>

<body id="page-container">

<%
    User user = (User)request.getSession().getAttribute("user");
    pageContext.setAttribute("user", user); 
    
    List<Meeting> upcoming = (List<Meeting>) request.getAttribute("upcoming");
    pageContext.setAttribute("upcoming", upcoming);
    
    List<Meeting> recent = (List<Meeting>) request.getAttribute("recent");
    pageContext.setAttribute("recent", recent);
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
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center mb-4">
                <div class="col-11 col-sm-9 col-md-9 col-lg-5 col-xl-5">
                    <form action="http://localhost:8080/meetingroommanagement/meeting/rooms" method="POST">
                        <!--Heading-->
                        <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                            <p class="lead mb-0 me-3">Create new meeting</p>
                        </div>

                        <!-- Meeting Title -->
                        <div class="form-outline mt-2 mb-1">
                            <input type="text" name="title" id="meetingTitle" class="form-control form-control-lg" placeholder="Enter meeting name" required />
                            <label class="form-label" for="meetingTitle">Meeting Name</label>
                        </div>
                        <!-- Start Date & Time -->
                        <div class="form-outline mt-4 mb-1">
                            <label class="form-label px-2" for="meetingStart">Meeting date and start time</label>
                            <input type="datetime-local" name="stime" id="meetingStart" class="form-control form-control-lg" required />
                        </div>
                        <!-- End Date & Time -->
                        <div class="form-outline mt-4 mb-1">
                            <label class="form-label px-2" for="meetingEnd">Meeting date and end time</label>
                            <input type="datetime-local" name="etime" id="meetingEnd" class="form-control form-control-lg" required />
                        </div>
                        <!--Meeting Type-->
                        <div class="dropdown my-3">
                            <label class="pe-4">Meeting Type: </label>
                            <select class="btn btn-dark dropdown-toggle" name="meettype" id="meet">
                                <option value="CLASSROOM_TRAINING">Classroom Training</option>
                                <option value="ONLINE_TRAINING">Online Training</option>
                                <option value="CONFERENCE_CALL">Conference call</option>
                                <option value="BUSINESS">Business</option>
                            </select>
                        </div>

                        <!--Create meeting button-->
                        <input class="btn" id="btnadmin" type="submit" value="Create Meeting" />
                        <!--Create meeting button-->

                    </form>
                </div>
            </div>
            <div class="row">
                <section class="col-11 col-sm-9 col-md-9 col-lg-5 col-xl-5">
                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                        <p class="lead mb-0 mx-3">Upcoming Meetings</p>
                    </div>
                    <e:forEach items="${upcoming}" var="meeting">
            			<e:set var="eid" value="${meeting.meetingTitle}" />
	                    <div class="card-container">
	                        <div class="card-body rounded-4">
	                            <div class="row">
	                                <div class="col-md-9">
	                                    <h5 class="card-title">${meeting.meetingTitle}</h5>
	                                </div>
	                                <div class="chip text-center col-md-3 mb-3">
	                                    <p>${meeting.timeAsString }</p>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-7">
	                                    <h6 class="card-subtitle text-black">Organizer</h6>
	                                    <p class="text-muted">${meeting.organizedBy}</p>
	                                </div>
	                                <div class="col-md-5">
	                                    <h6 class="card-subtitle text-black">Meeting Type</h6>
	                                    <p>${meeting.meetingType}</p>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                 </e:forEach>
                </section>
                <section class="col-11 col-sm-9 col-md-9 col-lg-5 col-xl-5 offset-xl-1 offset-lg-1">
                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                        <p class="lead mb-0 mx-3">Recent Meetings</p>
                    </div>
                    <e:forEach items="${recent}" var="meeting">
                    <e:set var="eid" value="${meeting.meetingTitle}" />
	                    <div class="card-container">
	                        <div class="card-body rounded-4">
	                            <div class="row">
	                                <div class="col-md-7">
	                                    <h5 class="card-title mb-4">${meeting.meetingTitle}</h5>
	                                </div>
	                                <div class="col-md-5 text-end">
	                                	<a href="http://localhost:8080/meetingroommanagement/feedback?room=${meeting.meetingRoom.meetingRoomId}">
		                                    <button type="button" class="btn btn btn-outline-primary">
		                                        Rate meeting room
		                                    </button>
	                                    </a>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-7">
	                                    <h6 class="card-subtitle text-black">Organizer</h6>
	                                    <p class="text-muted">${meeting.organizedBy}</p>
	                                </div>
	                                <div class="col-md-5">
	                                    <h6 class="card-subtitle text-black">Meeting Type</h6>
	                                    <p>${meeting.meetingType}</p>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                 </e:forEach>
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
            © 2021 Copyright: HSCC Meettings
        </div>
    </footer>
    <!--/.Footer-->

    <!--scripts-->
    <script src="/meetingroommanagement/scripts/scripts.js"></script>
    <!--scripts-->
</body>

</html>