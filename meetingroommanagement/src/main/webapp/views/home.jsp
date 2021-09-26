<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <!-- <link rel="stylesheet" href="all.css"> -->
    <title>HSCC Meettings</title>
</head>

<body id="page-container">
    <header>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg bg-dark" style="height: 8vh">
            <div class="container">
                <!-- Logo -->
                <img src="images/logo.png" height="30" alt="" />
                <h4 class="text-white ms-4 my-auto">HMeets</h4>
                <!-- Logo -->

                <!-- Menu button -->
                <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#navbarButtons" aria-controls="navbarButtons" aria-expanded="true" aria-label="Toggle navigation">
                    <img src="images/icon_menu.png" height="22" alt="" class="me-1" />
                </button>
                <!-- Menu button -->

                <!-- Nav Items -->
                <div class="collapse navbar-collapse" id="navbarButtons">
                    <div class="me-auto"></div>
                    <!-- <small class="text-info me-4">Link</small> -->
                    <ul class="align-nav-item">
                        <img src="images/icon_user.png" height="16" alt="" class="me-1" />
                        <small class="text-white me-4">Hi! Current User</small>
                    </ul>
                    <ul class="align-nav-item">
                        <a href="login">
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
        <!-- Application Info -->
        <div class="row bg-dark">
            <div class="col-md-5 text-center" id="imgDiv">
                <img src="images/bg_home.png" alt="" id="homeImage" />
            </div>
            <div class="col-md-6 d-flex align-items-center justify-content-center px-3 text-white mb-5">
                <h5 class="text-justify">
                    No demo without Lorem ipsum text. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Provident tenetur delectus fuga et, doloribus rerum! Aperiam voluptate mollitia rerum necessitatibus repudiandae asperiores doloremque deleniti praesentium, dolorem
                    maxime, quia, libero. Maiores?
                </h5>
            </div>
        </div>

        <div class="row m-3" id="roomdetails">
            <div class="card-container col-xl-4 col-lg-6 col-md-6 col-sm-8">
                <div class="import-user-card-body rounded-4 text-center">
                    <img src="images/icon_users.png" height="40" alt="" class="mb-2" />
                    <h5 class="import-card-title text-white space-around mb-2">HSCC Users</h5>
                    <p class="card-text text-white space-around">
                        Import all the users of your organization(if not already imported) before you proceed further.
                    </p>
                    <button type="button" class="btn bg-success" onclick="importUsers()" data-mdb-toggle="modal" data-mdb-target="#importStatusModal">Import Users</button>
                    <!-- data-mdb-toggle="modal" data-mdb-target="#importStatusModal" -->
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="importStatusModal" tabindex="-1" aria-labelledby="statusModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="statusModalLabel">Import status</h5>
                    </div>
                    <div class="modal-body">
                        <h6 id="importStatus">Importing users...</h6>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-info" data-mdb-dismiss="modal">
                            Ok
                        </button>
                    </div>
                </div>
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
    <script src="scripts.js"></script>
    <script>
        function importUsers() {
            let xhttp = new XMLHttpRequest();
            let method = "POST";
            let url = "http://localhost:8080/meetingroommanagement/";
            xhttp.open(method, url);
            // xhttp.send();

            xhttp.onload = function() {
                    let importStatus = xhttp.responseText;
                    let statusElement = document.getElementById('importStatus');
                    if (importStatus.includes("Successfully imported")) {
                        statusElement.style.color = "green";
                    } else {
                        statusElement.style.color = "red";
                    }
                    statusElement.innerHTML = importStatus;
                }
                /*
setTimeout(function() {
    let importStatus = "Successfully imported 11 users"
    let statusElement = document.getElementById('importStatus');
    if (importStatus.includes("Successfully imported")) {
        statusElement.style.color = "green";
    } else {
        statusElement.style.color = "red";
    }
    statusElement.innerHTML = importStatus;
}, 3000);
*/
        }

        window.onload = function() {
            getMeetings();
        }

        // this list of json is only for testing purpose
        let allRooms = [{
            "Name": "Conference call wala room new hai",
            "SeatingCapacity": 23,
            "NumberOfMeetings": 12,
            "Ratings": 3
        }, {
            "Name": "Online wala room",
            "SeatingCapacity": 32,
            "NumberOfMeetings": 2,
            "Ratings": 5
        }, {
            "Name": "Presentation wala room",
            "SeatingCapacity": 45,
            "NumberOfMeetings": 53,
            "Ratings": 4
        }, {
            "Name": "Training wala room",
            "SeatingCapacity": 65,
            "NumberOfMeetings": 90,
            "Ratings": 4
        }];

        function getMeetings() {
            // var roomsLoaded = false;
            var roomDiv = document.getElementById("roomdetails");
            let xhttp = new XMLHttpRequest();
            let method = "GET";
            let url = "http://localhost:8080/meetingroommanagement/room"
            xhttp.open(method, url, true);
            // xhttp.send();

            // if (!roomsLoaded) {
            //     showLoader();
            // }

            xhttp.onload = function() {
                let htmlStr = ""
                let allRooms = JSON.parse(xhttp.responseText);
                if (allRooms.length > 0) {
                    htmlStr = renderRoomsHtml(allRooms);
                    roomDiv.insertAdjacentHTML('beforeend', htmlStr);
                } else {
                    renderNoRoomsHtml();
                }
            };

            // /* this list of json is only for testing purpose
            if (allRooms.length > 0) {
                htmlStr = renderRoomsHtml(allRooms);
                roomDiv.insertAdjacentHTML('beforeend', htmlStr);
            } else {
                renderNoRoomsHtml();
            }
            // */

            function renderRoomsHtml(allRooms) {
                let allRoomsHtml = "";
                allRooms.forEach(room => {
                    allRoomsHtml += `<div class="card-container col-xl-2 col-lg-3 col-md-3 col-sm-4">
                                        <div class="card-body rounded-4">
                                            <h5 class="card-title mb-4">${room.Name}</h5>
                                            <h6 class="card-subtitle text-black">Seating Capacity</h6>
                                            <p class="text-muted">${room.SeatingCapacity} participants</p>
                                            <h6 class="card-subtitle text-black">Per hour cost</h6>
                                            <p>${room.perHourCost} Credits</p>
                                            <h6 class="card-subtitle text-black">Rating: </h6>
                                            <p>${room.Ratings}</p>
                                        </div>
                                    </div>`;
                });
                // hideLoader();
                return allRoomsHtml;
            }

            function renderNoRoomsHtml() {
                let noRoomHtml = `<div class="col-xl-6 col-lg-6 col-md-6 col-sm-4 d-flex align-items-center justify-content-center text-muted mt-4">
                    <h5>No meeting rooms available.</h5>
                </div>`;
                // hideLoader();
                roomDiv.insertAdjacentHTML('beforeend', noRoomHtml);
            }

            // function showLoader() {
            //     let showLoaderHtml = `<div class="col-xl-6 col-lg-6 col-md-6 col-sm-4 d-flex align-items-center justify-content-center text-muted mt-4" id="loader">
            //         <h5>Loading meeting rooms...</h5>
            //     </div>`;
            //     roomDiv.insertAdjacentHTML('beforeend', showLoaderHtml);
            // }

            // function hideLoader() {
            //     roomsLoaded = true;
            //     document.getElementById('loader').style.display = "none!important";
            // }
        }
    </script>
    <!--scripts-->
</body>

</html>