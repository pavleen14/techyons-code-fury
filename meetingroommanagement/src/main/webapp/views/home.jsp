<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>HMeets</title>
</head>
<body id="page-container">
	<header>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg bg-dark" style="height: 8vh">
            <div class="container">
                <!-- Logo -->
                <img src="logo.png" height="30" alt="" />
                <h4 class="text-white ms-4 my-auto">HMeets</h4>
                <!-- Logo -->

                <!-- Menu button -->
                <button class="navbar-toggler" type="button" data-mdb-toggle="collapse" data-mdb-target="#navbarButtons" aria-controls="navbarButtons" aria-expanded="true" aria-label="Toggle navigation">
                    <img src="icon_menu.png" height="22" alt="" class="me-1" />
                </button>
                <!-- Menu button -->

                <!-- Nav Items -->
                <div class="collapse navbar-collapse" id="navbarButtons">
                    <div class="me-auto"></div>
                    <!-- <small class="text-info me-4">Link</small> -->
                    <ul>
                        <img src="icon_user.png" height="16" alt="" class="me-1" />
                        <small class="text-white me-4">Hi! Current User</small>
                    </ul>
                    <ul>
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
                <img src="bg_home.png" alt="" id="homeImage" />
            </div>
            <div class="col-md-6 d-flex align-items-center justify-content-center px-3 text-white mb-5">
                <h5 class="text-justify">
                    No demo without Lorem ipsum text. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Provident tenetur delectus fuga et, doloribus rerum! Aperiam voluptate mollitia rerum necessitatibus repudiandae asperiores doloremque deleniti praesentium, dolorem
                    maxime, quia, libero. Maiores?
                </h5>
            </div>
        </div>

        <div class="row m-3">
            <div class="card-container col-xl-3 col-lg-4 col-md-6 col-sm-6">
                <div class="import-user-card-body rounded-4 text-center">
                    <img src="icon_users.png" height="40" alt="" class="mb-2" />
                    <h5 class="import-card-title text-white">Card title</h5>
                    <p class="card-text text-white">
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </p>
                    <button type="button" class="btn bg-success" onclick="importUsers()">Import Users</button>
                </div>
            </div>
            <div class="card-container col-xl-3 col-lg-4 col-md-6 col-sm-6">
                <div class="card-body rounded-4">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </p>
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
                </div>
            </div>
            <div class="card-container col-xl-3 col-lg-4 col-md-6 col-sm-6">
                <div class="card-body rounded-4">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </p>
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
                </div>
            </div>
            <div class="card-container col-xl-3 col-lg-4 col-md-6 col-sm-6">
                <div class="card-body rounded-4">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </p>
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
                </div>
            </div>
            <div class="card-container col-xl-3 col-lg-4 col-md-6 col-sm-6">
                <div class="card-body rounded-4">
                    <h5 class="card-title">Card title</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                    <p class="card-text">
                        Some quick example text to build on the card title and make up the bulk of the card's content.
                    </p>
                    <a href="#" class="card-link">Card link</a>
                    <a href="#" class="card-link">Another link</a>
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
	<div id="roomdetails">Meeting room</div>
	
	
	
	<script type="text/javascript">
		
		function importUsers() {
			let xhttp = new XMLHttpRequest();
			let method = "POST";
			let url = "http://localhost:8080/meetingroommanagement/";
			xhttp.open(method, url);
			xhttp.send();

			xhttp.onload = function() {
				let importStatus = xhttp.responseText;
				console.log(importStatus);
				// TODO show popup to user with importStatus as messaage
			}
		}
		
		
		let allRooms;
		function getMeetings() {
		var roomid=document.getElementById("roomdetails");
		window.addEventListener("load",function(){
			
		
			let xhttp = new XMLHttpRequest();
			let url = "http://localhost:8080/meetingroommanagement/room"
			xhttp.open("GET", url,true);
			
		
			xhttp.onload = function() {
				let recievedRooms = JSON.parse(xhttp.responseText);
				allRooms = [...allRooms, ...recievedRooms]; // appending additional rooms to current list				
			renderHTML(recievedRooms);
			};
			xhttp.send();
			});

			function renderHTML(recievedRoomData)
			{
				for(i=0;i<recievedRoomData.length;i++)
					{
					var roomDetails="";
					roomDetails+= "<p>"+"Name :"+roomDetails[i].Name+"<br>"+"Seating Capacity :"+roomDetails[i].SeatingCapacity+"<br>"+"Total Meetings Conducted :"+roomDetails[i].NumberOfMeetings+"<br>"+"Ratings :"+roomDetails[i].Ratings+"</p>";
					roomid.insertAdjacentHTML('beforeend',roomDetails);
					}
			}
		}
	</script>
</body>
</html>