<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<!-- start:font awesome v4.1.0 -->
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <!-- start:bootstrap reset -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap-reset.css">
  
 <script src="//cdn.tinymce.com/4/tinymce.min.js"></script>
  <script>tinymce.init({ selector:'textarea' });</script>
<script type="text/javascript" src= "https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
	  	<link rel="stylesheet" type="text/css" href="css/alertify.core.css">
	<link rel="stylesheet" type="text/css" href="css/alertify.default.css">
	<link rel="stylesheet" type="text/css" href="css/alertify.bootstrap.css">
<link href="js/EventNix/boot/datetimepicker.min.css" rel="stylesheet">
<script src="js/EventNix/boot/jquery-2.1.4.js"></script>
     <script src="js/EventNix/boot/datetimepicker.min.js"></script>
      <script src="js/alertify.min.js"></script>
   

<meta charset="UTF-8">
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<title>EventNix| Organizer Dashboard</title>
	<!-- start:bootstrap v3.2.0 -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<!-- start:font awesome v4.1.0 -->
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <!-- start:bootstrap reset -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap-reset.css">
	<!-- start:style arjuna -->
	<link rel="stylesheet" type="text/css" href="css/arjuna.css">
    <link rel="stylesheet" type="text/css" href="plugins/owl.carousel/owl-carousel/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="plugins/owl.carousel/owl-carousel/owl.theme.css">
    <link rel="stylesheet" type="text/css" href="plugins/owl.carousel/owl-carousel/owl.transitions.css">
<title>Insert title here</title>
</head>
<body class="cl-default fixed">

    <!-- start:navbar top -->
    <header class="header">
        <a href="index.html" class="logo">
            <i class="fa fa-pied-piper-alt"></i>EventNix
        </a>

		<nav class="navbar navbar-static-top" role="navigation">
			<!-- Sidebar toggle button-->
			<a href="#" class="navbar-btn sidebar-toggle" data-target="#atas"
				data-toggle="offcanvas" role="button"> <span class="sr-only">Toggle
					navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			<div class="collapse navbar-collapse" id="atas">
				<div class="navbar-left">
					<ul class="nav navbar-nav">
					</ul>
				</div>
				<div>

					<div class="navbar-login navbar-login-session navbar-right">
					<div class="btn-group">
							<a class ="btn btn-warning btn-md">Welcome, <%
								if (request.getSession().getAttribute("sessionLname") != null) {
									out.println(request.getSession().getAttribute("sessionLname")
											.toString().toUpperCase());}%></a>
							<a href="./login"  name= "logout" class="btn btn-primary btn-md">Logout</a></div>
					</div>
				</div>
			</div>
		</nav>
	</header>
    <!-- end:navbar top -->

  <div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- start:left sidebar -->
		<aside class="left-side sidebar-offcanvas">
			<section class="sidebar">
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="active"><a href="organizer.jsp"> <i
							class="fa fa-dashboard"></i> <span>Dashboard</span>
					</a></li>
					<li class="treeview"><a onclick=" hideAttenders(); hideReport()"> <i class="fa fa-spinner"></i>
							<span>Events Center <!--Components--></span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="eventform.jsp"><i class="fa fa-circle-o"></i>Create
									a new Event<!--Todo List--></a></li>
							<li><a 
								onclick="App.Cmp.showOrganizerEventsProgress()"><i
									class="fa fa-circle-o"></i> View Posted Event Details <!-- Draggable Portlet--></a></li>
							<li><a href="index.jsp"><i
									class="fa fa-circle-o"></i> Book an Event<!-- Draggable Portlet--></a></li>
						</ul></li>
					<li class="treeview"><a onclick="hideReport()"> <i class="fa fa-users"></i>
							<span>List of Event Attenders <!--Charts--></span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a onclick="App.Cmp.loadOrganizerEvents()"><i
									class="fa fa-circle-o"></i>View According to posted Events<!--Todo List--></a></li>

						</ul> </a></li>
					<li class="treeview"><a onclick ="hideAttenders()"> <i
							class="fa fa-credit-card "></i> <span>Payments</span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a onclick="App.Cmp.viewPaymentProgress()"><i
									class="fa fa-circle-o"></i> Graphical Representation of Ticket Sales</a></li>
						</ul></li>

				</ul>
			</section>
		</aside>
        <!-- end:left sidebar -->

        <!-- start:right sidebar -->
        <aside class="right-side">
            <section class="content">

                <!-- start:content -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1>
                            Dashboard
                            <small>Control panel</small>
                        </h1>
                    </div> 
                    
                    <!-- start:AJAX Content to change depending on the item clicked -->
                    <div class="col-lg-12 flot-index" id= "ajax-content">
                        <div class="row">
      <form role="form" method="post" action= "./fileUpload" enctype="multipart/form-data" id="form" >
      		<div class="form group">
      		<div class="input-group"><span class="input-group-addon"><i class="fa fa-certificate"></i></span>
      			<input type="text" class="form-control" name="name"   placeholder="Enter Event Name" required>
                        </div>
                            
                         </br>
                         	<div class="input-group"><span class="input-group-addon"><i class="fa fa-building-o"></i></span>
			<input type="text" class="form-control" id="venue" name="venue" placeholder="Enter your venue" required></div>
				</br>
					<div class="input-group"><span class="input-group-addon"><i class="fa fa-ticket"></i></span>
<input type="number" class="form-control" id="nts"  name="ticketNumber" placeholder="Number of Tickets Available" required>
            </div>
           </br>
           	<div class="input-group"><span class="input-group-addon"><i class="fa fa-usd"></i></span>
	<input type="text" class="form-control"  id="price" name="price"   placeholder="Enter Price of ticket" required>
                        </div>
                            
                         </br>
            <div class="form-group">
                <div class='input-group date' id='datetimepicker2'>
                    <input type='text' class="form-control" name="start_date_time" id="start" placeholder="Select the date and time below"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
              <div class="form-group">
                <div class='input-group date' id='datetimepicker3'>
                    <input type='text' class="form-control" name="end_date_time" placeholder="Select the end date and time below" id="end" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    
                </div>
            </div>
            
      

        
        <script type="text/javascript">
        function beforeSubmit(){
        	alertify.alert("You have successfully created the event :-)");
        }
        $(function () {
            $('#datetimepicker2').datetimepicker();
            $('#datetimepicker3').datetimepicker({
                useCurrent: false //Important! See issue #1075
            });
            $("#datetimepicker2").on("dp.change", function (e) {
                $('#datetimepicker3').data("DateTimePicker").minDate(e.date);
            });
            $("#datetimepicker3").on("dp.change", function (e) {
                $('#datetimepicker2').data("DateTimePicker").maxDate(e.date);
            });
        });
        </script> 
         

  

        <br>
        <div class="form-inline">
  <label for="category">Select one of the categories :</label>
         <select class="unit" name="category" id ="category" onclick = >
		                
		                <option value="Social and Networking">Social and Networking</option>
		                <option value="Foods and Drinks">Foods and Drinks</option>
		                <option value="Music">Music</option>
		                <option value="Arts and Culture">Arts and Culture</option>
		                
		            </select>
   </div>
        <br>
        	
       
      				<div class="input-group"><span class="input-group-addon"><i class="fa fa-keyboard-o"></i></span>
      				
  <textarea class="form-control" rows="5" id="comment" name = "description"></textarea> 
</div>
      		<br>
      		 <div class=" form-inline text-left">
      			<label for="inputfile">Select an image</label>
      				<input type="file" id="inputfile" name="image" required>
      			
      			</div>
      	<br>
      		
      		<button class="btn btn-lg btn-info text-center"  id="submita" name="submit" onclick = "beforeSubmit()">Create the Event</button>
      			      	</form>  
      		</div>
      		</div>
      		</div></section>	      	
      			      	
      			      	
</body>
		<script src="js/EventNix/base.app.js"></script>
		<script src="js/EventNix/eventform.js"></script>

		<!-- start:arjuna.js --></html>