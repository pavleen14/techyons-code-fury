<%@page import="com.hsbc.meets.entity.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="e"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/meetingroommanagement/css/style.css">
    <title>Feedback | HMeets</title>
</head>

<body id="page-container">

<%
    User user = (User)request.getSession().getAttribute("user");
    pageContext.setAttribute("user", user); 
    
    String room = (String) request.getAttribute("roomId");
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
                        <small class="text-white me-4">Hi! ${ user.name }</small>
                    </ul>
                    <ul class="align-nav-item">
                        <a href="login?op=logout">
                            <button type="button" class="btn btn-outline-info" data-mdb-ripple-color="dark">
                                Login
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
        <section>
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class=" col-6 col-sm-4 col-md-4 col-lg-6 col-xl-5">
                        <img src="/meetingroommanagement/resources/images/bg_feedback.png" class="img-fluid" alt="Login">
                    </div>
                    <div class="col-9 col-sm-9 col-md-9 col-lg-6 col-xl-4 offset-xl-1">
                        <form action="/meetingroommanagement/feedback" method="post">
                            <input type="hidden" name="roomId" value="${room}" />
                            <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                                <!-- <p class="lead mb-0 me-3">Feedback for room <%=room %></p> -->
                                <p class="lead mb-0 me-3">Feedback</p>
                            </div>

                            <!-- Rating -->
                            <div class="form-outline mt-4 mb-4">
                                <input type="number" name="rating" id="ratingField" class="form-control form-control-lg" placeholder="Rate the meeting room" required />
                                <label class="form-label" for="ratingField">Rating</label>
                                <!-- add value="${email}" to input tag -->
                            </div>

                            <!-- Comments -->
                            <div class="form-outline mb-3">
                                <input type="text" name="comment" id="commentField" class="form-control form-control-lg" placeholder="Comments about room" required />
                                <label class="form-label" for="commentField">Comments</label>
                            </div>

                            <div class="text-center text-lg-start mt-4 pt-2">
                                <input class="btn btn-primary btn-lg" type="submit" value="Submit" />
                            </div>

                            
                        </form>
                    </div>
                </div>
            </div>

        </section>
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