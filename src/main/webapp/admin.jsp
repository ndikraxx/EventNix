<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
	<title>EventNix| Admin Dashboard</title>
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
    
    	
</head>
<body class="cl-default fixed">

    <!-- start:navbar top -->
    <header class="header">
        <a href="index.html" class="logo">
            <i class="fa fa-pied-piper-alt"></i>EventNix
        </a>

        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="navbar-btn sidebar-toggle" data-target="#atas" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="collapse navbar-collapse" id="atas">
                <div class="navbar-left">
                    <ul class="nav navbar-nav">
                       
                     
                        </ul>
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
                <!-- Sidebar user panel -->
                <div class="user-panel">
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <li class="active">
                        <a href="index.html">
                            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-spinner"></i>
                            <span>Events Center <!--Components--></span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
<li><a href="todo-list.html"><i class="fa fa-circle-o"></i>Approve Pending Events <!--Todo List--></a></li>
                          
                            <li><a href="draggable-portlet.html"><i class="fa fa-circle-o"></i>Posted Event  <!-- Draggable Portlet--></a></li>
                            <!--<li><a href="nestable.html"><i class="fa fa-circle-o"></i>Archieved Events<!--Nestable</a></li>-->

                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-users"></i>
                            <span>Users <!--Charts--></span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="morris.html"><i class="fa fa-circle-o"></i> Event Marketers <!--Morris--></a></li>
                            <li><a href="xchart.html"><i class="fa fa-circle-o"></i> Event Organizers <!--XChart--></a></li>
                            <li><a href="xchart.html"><i class="fa fa-circle-o"></i> List of Event Attenders <!--XChart--></a></li>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-credit-card "></i>
                            <span>Payments</span>
                            <i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="general.html"><i class="fa fa-circle-o"></i> General</a></li>
                        
                        </ul>
                    </li>

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
                            <div class="col-sm-6">
                                <section>
                                    
                   
                              
                              
                                </section>
                            </div>
                            <div class="col-sm-6">
                            

                            </div>
                        </div>
                    </div>
                    <!-- end:AJAX content-->



                </div>
                <!-- end:content -->
            </section>
        </aside>
        <!-- end:right sidebar -->

    <!-- end:wrapper body -->

	<!-- start:javascript for all pages -->
		<!-- start:jquery -->
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