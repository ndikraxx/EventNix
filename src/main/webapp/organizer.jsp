<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<title>EventNix| Organizer Dashboard</title>
<!-- start:bootstrap v3.2.0 -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<!-- start:font awesome v4.1.0 -->
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<!-- start:bootstrap reset -->
<link rel="stylesheet" type="text/css" href="css/bootstrap-reset.css">
<!-- start:style arjuna -->
<link rel="stylesheet" type="text/css" href="css/arjuna.css">
<link rel="stylesheet" type="text/css"
	href="plugins/owl.carousel/owl-carousel/owl.carousel.css">
<link rel="stylesheet" type="text/css"
	href="plugins/owl.carousel/owl-carousel/owl.theme.css">
<link rel="stylesheet" type="text/css"
	href="plugins/owl.carousel/owl-carousel/owl.transitions.css">
<link rel="stylesheet"
	href="http://cdn.oesmith.co.uk/morris-0.4.3.min.css">
<script src="https://code.jquery.com/jquery-2.2.4.min.js"
	integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
	crossorigin="anonymous"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="http://cdn.oesmith.co.uk/morris-0.4.3.min.js"></script>
<script type="text/javascript">
function hideAttenders(){
	var mydiv = document.getElementById('showAttenders');
    mydiv.style.display = 'none'
}

</script>

</head>
<body class="cl-default fixed">

	<!-- start:navbar top -->
	<header class="header">
		<a href="index.html" class="logo"> <i class="fa fa-pied-piper-alt"></i>EventNix
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
							<a class="btn btn-warning btn-md">Welcome, <%
								if (request.getSession().getAttribute("sessionLname") != null) {
									out.println(request.getSession().getAttribute("sessionLname")
											.toString().toUpperCase());}%></a> <a href="./login"
								name="logout" class="btn btn-primary btn-md">Logout</a>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</header>
	<!-- end:navbar top -->

	<!-- start:wrapper body -->
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
									class="fa fa-circle-o"></i> Graphical Representation </a></li>
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
							Dashboard <small>Control panel</small>
						</h1>
					</div>

					<!-- start:AJAX Content to change depending on the item clicked -->
					<div class="col-lg-12 flot-index" id="ajax-content"></div>
					 <div id="showAttenders"></div>
				<div class="row" style="display:none;" id="report" >
				
					<div class="col-md-6">
					<div class="box">
							<h4>Tickets Sold vs Ticket Remaining</h4>
							<hr>
							<div id="ticketsales" class="graph"></div>
						</div>
					</div>
					<div class="col-md-6">
					<div class="box">
							<h4>Ticket Sales per day</h4>
							<hr>
							<div id="ticketsalesperday" class="graph"></div>
						</div>
					</div>
			 	
					<div class="col-lg-12 col-md-12">
					<div class="box">
							<h4>Ticket Sales per day</h4>
							<hr>
							<div id="paymentsperday" class="graph"></div>
							<div id="totalPayments" class="graph"></div>
						</div>
					</div> 
				</div>


				</div>
				<!-- end:content -->
			</section>
			<!-- <div class="col-lg-12 flot-index"  id="report" > -->

		</aside>
		<!-- end:right sidebar -->

		<!-- end:wrapper body -->

		<!-- start:javascript for all pages -->
		<!-- start:jquery -->
		<script src="js/EventNix/base.app.js"></script>
		<script src="js/EventNix/eventform.js"></script>
		<script src="js/jquery-1.11.1.min.js"></script>
		<!-- start:bootstrap -->
		<script src="js/bootstrap.min.js"></script>
		<!-- start:arjuna.js -->
		<script src="js/arjuna.js"></script>
		<!-- end:javascript for all pages-->

		<!-- start:javascript for this page -->
		<script src="plugins/flot/jquery.flot.min.js"></script>
		<script src="plugins/flot/jquery.flot.tooltip.min.js"></script>
		<script src="plugins/flot/jquery.flot.spline.js"></script>
		<script src="plugins/flot/jquery.flot.pie.min.js"></script>
		<script src="plugins/flot/jquery.flot.resize.js"></script>
		<script src="plugins/flot/jquery.flot.grow.js"></script>
		<script src="plugins/flot/demo.js"></script>
		<script src="plugins/owl.carousel/owl-carousel/owl.carousel.js"></script>
		<script src="js/owl-carousel.js"></script>
		<!-- end:javascript for this page -->
</body>
</html>
