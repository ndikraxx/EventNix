<!DOCTYPE html>
<html lang="en">
  

<head>

    <!-- SITE TITTLE -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EventNix| Home Page</title>

	<link href="css/min.css" rel="stylesheet">
	<link href="css/theme.min.css" rel="stylesheet">


<link type="text/css" href="css/custom.css"/>
    <link href="css/mystyle.css" rel="stylesheet">
    <link rel="stylesheet" href="css/colors/default.css" id="option_color">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">
  </head>

  <body>
<nav class="navbar navbar-inverse navbar-fixed-top" id="my-navbar">
		<div class="container"> 
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main_menu">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a href="" class="navbar-brand">EventNix</a>
			</div>
			<!--End NavBar-Header-->
			<div class="collapse navbar-collapse" id="main_menu">
           
              <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="home.showEventCategory()">Home</a></li>
                <li ><a onclick="food.showEventCategory()">Foods and Drinks</a></li>
                <li ><a onclick="social.showEventCategory()">Social and Networking</a></li>
                <li ><a href="javascript:void(0)">Arts and Culture</a></li>
            
               <div class=' btn btn-group'>
               
               
               <div class="btn-group">
						<div class="btn-group">
						 <%
								if (request.getSession().getAttribute("sessionLname") != null) {
									out.println("<a class='btn btn-large btn-default dropdown-toggle' data-toggle='dropdown'>"+"Welcome, "+request.getSession().getAttribute("sessionLname").toString().toUpperCase()+" <span class='caret'></span></a>"+
									"<ul class='dropdown-menu'><li><a onclick='App.Cmp.userEvents()'>My Events</a></li></ul>");}
							
								else {
									out.println("<a href='./login' name='logout' class='btn btn-primary btn-md'>Sign in</a>");
								}
								
											%></a>
								 <%	if (request.getSession().getAttribute("sessionLname") != null) {
									out.println("<a href='./login' name='logout' class='btn btn-primary btn-md'>Logout</a>");}

								else {
									out.println("<a href='register.jsp' name='' class='btn btn-primary btn-md'>Sign Up</a>");
								}
								%>
											
						</div>
						</div>
						
		<!-- 				<a href='#' class='btn btn-large btn-default dropdown-toggle' data-toggle='dropdown'>Username <span class='caret'></span></a>
						<ul class='dropdown-menu'>
						<li><a href='profile.php'>My Profile</li>
						<li><a href='user-events.php'>My Events</li>
						</ul>
						<a href='php/logout.php' class='btn btn-large btn-default'>".$log."</a>
					</div>";
					}
		else{ 
				echo "<div class='btn btn-group'>
						<a href='signup.php' class='btn btn-small btn-default'>SIGN UP</a>
						<a href='login.php' class='btn btn-large btn-default'>LOG IN</a>
					</div>";} -->
             		</ul>
             
               
         	</div><!--End collapse-->
			</div> <!--End Container-->
		</nav><!--End NavBar-->
                </br></br>     </br>
      
     


				<div class="jumbotron">
			<div class="container text-center">
			
		 <%
			if (request.getSession().getAttribute("sessionLname") != null && request.getSession().getAttribute("userType").equals("Organizer")) {
					out.println("<h1>Welcome, "+request.getSession().getAttribute("sessionLname").toString().toUpperCase()+" </h1>");

					out.println("<a href='organizer.jsp' class='btn btn-primary btn-md'>Go to the Event Organizer Site</a>");
					
								}
								
			else if (request.getSession().getAttribute("sessionLname") != null && request.getSession().getAttribute("userType").equals("Admin")) {
				out.println("<h1>Welcome, "+request.getSession().getAttribute("sessionLname").toString().toUpperCase()+" </h1>");
		
				out.println("<a href='admin.jsp' class='btn btn-primary btn-md'>Go to the Admin Panel</a>");
				
			}
		 out.println("<h2>OR</h2>");
											%>

				<h1>Search for an event on our site </h1>
<div class="container text-center">
<div class ="row>">
<div class="col-xs-4 col-lg-4 col-md-4 col-sm-4 pull-center"></div>
<div class="col-xs-4 col-lg-4 col-md-4 col-sm-4">
				<form class= "text-center form-inline"  method="post" >
				<input type="text" class="form-control" name="parameter" id="parameter"  placeholder="Enter Search Parameter" required>
				 <select class="unit" name="searchvalue" id ="searchvalue">
		                
		                <option value="Name">Name</option>
		                <option value="Venue">Venue</option>
		                <option value="Description">Description</option>
		            
		           
		            </select>
		            
				</form>
				
				</div>
				<div class="col-xs-4 col-lg-4 col-md-4 col-sm-4">
				  <button onclick="search()" class="btn btn-lg btn-info text-center"  id="submita" name="submit">Submit</button> 
</div>
<div class="col-xs-4 col-lg-4 col-md-4 col-sm-4"></div>

			</div>
		</div>
		
            
            </div>

          </div>
          </section>
          
   <section class="wrapper-md bg-highlight"> 
          
          <div class ="container">
          <br>
          <br>
          <div class= "row" id = "show-events" ></div>
        </div>
        
      </section>

      <!-- LIGHT SECTION -->
      
      
   
    <script src ="js/EventNix/base.app.js"></script>
      <script src = "js/EventNix/home.js"></script>
        <script src ="js/EventNix/socialandNetworking.js"></script>
  <script
			  src="https://code.jquery.com/jquery-2.2.4.min.js"
			  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
			  crossorigin="anonymous"></script>
		<script type="text/javascript" src="js/EventNix/foodandDrinks.js"></script>
		 <script src ="js/EventNix/showEventDetails.js"></script>
		 <script src ="js/EventNix/payment.js"></script>
		
		 <script src=" js/EventNix/refreshPayments.js"></script>

		
		<!--bootstrap minified javascript-->
		<script src="js/bootstrap.min.js"></script>
    

  </body>

</html>