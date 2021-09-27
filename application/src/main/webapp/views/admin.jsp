<%@page import="com.hsbc.meets.entity.User"%>
<%@page import="javax.servlet.descriptor.JspPropertyGroupDescriptor"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/meetingroommanagement/css/style.css">
    <title>Admin | HMeets</title>
</head>

<body id="page-container">
<%
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
        <div class="container-fluid">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-9 col-sm-8 col-md-9 col-lg-6 col-xl-4 offset-xl-1">
                    <!--Welcome Text-->
                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                        <h3 class="text-muted">Welcome to</h3><br>
                    </div>
                    <div>
                        <h1 class="text-center lead d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                            Meeting Room Management</h1>
                    </div>
                    <!--/ Welcome Text-->

                    <!--User Details-->
                    <div class="card mt-5 mb-3" style="border-radius: .5rem;">
                        <div class="row g-0">
                            <div class="col-md-4 gradient-custom d-flex flex-row align-items-center justify-content-center" style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                                <img src="/meetingroommanagement/resources/images/img_user_card.png" alt="avatar" class="rounded-circle img-fluid py-4 p-3" style="width: 150px;">
                            </div>
                            <div class="col-md-8">
                                <div class="user-card-body px-4 py-2">
                                    <h5 class="my-3">${ user.name }</h5>
                                    <hr class="my-4">
                                    <div class="col-12 mb-1">
                                        <h6>Email</h6>
                                        <p class="text-muted">${ user.email }</p>
                                    </div>
                                    <hr class="mt-4">
                                    <div class="col-12 mb-1">
                                        <h6>Last Login</h6>
                                        <p class="text-muted">${ user.lastLogin }</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--/ User Details-->

                    <!--Action Buttons-->
                    <div class="row">
                        <div class="col-md-6">
                        	<a href = "/meetingroommanagement/admin?option=create">
                            <button type="button" class="btn" id="btnadminoutline">
                                Add New Room
                            </button>
                            </a>
                        </div>
                        <div class="col-md-6">
	                        <a href = "/meetingroommanagement/meetingroom">
	                            <button type=" button" class="btn" id="btnadmin">Edit Room</button>
	                        </a>
                        </div>
                    </div>
                    <!--/ Action Buttons-->

                </div>
                <!--Background picture-->
                <div class="col-9 col-sm-6 col-md-6 col-lg-6 col-xl-5">
                    <img src="/meetingroommanagement/resources/images/bg_admin.png" class="img-fluid" alt="Login">
                </div>
                <!--Background picture-->
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