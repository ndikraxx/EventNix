<!DOCTYPE html>
<html lang="en">
  

<head>

    <!-- SITE TITTLE -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EventNix| Home Page</title>
    
    <!-- PLUGINS CSS STYLE -->
    <link href="plugins/jquery-ui/jquery-ui.css" rel="stylesheet">
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="plugins/selectbox/select_option1.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="plugins/rs-plugin/css/settings.css" media="screen">
    <link rel="stylesheet" type="text/css" href="plugins/owl-carousel/owl.carousel.css" media="screen">
    <link rel="stylesheet" href="options/optionswitch.css">
    
    <!-- CUSTOM CSS -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/mystyle.css" rel="stylesheet">
    <link rel="stylesheet" href="css/colors/default.css" id="option_color">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>

  <body>

  <!--=== option Switcher ===-->
  <i class="option-switcher-btn fa fa-gear hidden-xs"></i>
  <div class="option-switcher container animated fadeInRight">
    <div class="option-swticher-header">
      <div class="option-switcher-heading">Template Options</div>            
      <div class="theme-close"><i class="fa fa-close"></i></div>
    </div>
    <div class="option-swticher-body">
      <!-- Theme Colors -->
      <ul class="list-unstyled">
        <li class="theme-default theme-active" data-color="default" data-logo="default-logo"></li>
        <li class="theme-pink" data-color="pink" data-logo="pink"></li>
        <li class="theme-purple" data-color="purple" data-logo="purple"></li>
        <li class="theme-deepBlue" data-color="deepBlue" data-logo="deepBlue"></li>
        <li class="theme-orange last" data-color="orange" data-logo="orange"></li>
      </ul>
      <!-- Layout Styles -->
      <div class="row no-col-space layoutStyle">
        <div class="col-xs-6">
          <a href="javascript:void(0);" class="btn-u  btn-block active-switcher-btn wide-layout-btn">Wide</a>                
        </div>
        <div class="col-xs-6">
          <a href="javascript:void(0);" class="btn-u btn-block boxed-layout-btn">Boxed</a>
        </div>                
      </div> 
      <!-- Header Styles -->
      <div class="row no-col-space headerStyle">
        <div class="col-xs-6">
          <a href="javascript:void(0);" class="btn-u btn-block active-switcher-btn fixed-header-btn">Fixed Top</a>               
        </div>
        <div class="col-xs-6">
          <a href="javascript:void(0);" class="btn-u  btn-block static-header-btn">Static Top</a>
        </div>               
      </div>              
    </div>
  </div>
  <!--/option-switcher-->

    <div class="main-wrapper">

      <!-- HEADER -->
      <div class="header clearfix">

        <!-- TOPBAR -->
        <div class="topBar">
          <div class="container">
            <div class="row">
              <div class="col-md-6 hidden-sm hidden-xs">
              
              </div>
              <div class="col-md-6 col-xs-12">
                <ul class="list-inline pull-right">
                  <li><span><a data-toggle="modal" href='.html'>Log in</a><small>or</small><a data-toggle="modal" href='#signup'>Create an account</a></span></li>
                  <li class="dropdown searchBox">
                    <a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-search"></i></a>
                    <ul class="dropdown-menu dropdown-menu-right">
                      <li>
                        <span class="input-group">
                          <input type="text" class="form-control" placeholder="Search" aria-describedby="basic-addon2">
                          <span class="input-group-addon" id="basic-addon2">Search</span>
                        </span>
                      </li>
                    </ul>
                  </li>
       
                </ul>
              </div>
            </div>
          </div>    
        </div>

        <!-- NAVBAR -->
        <nav class="navbar navbar-main navbar-default" role="navigation">
          <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="javascript:void(0)"><img src="" alt=""><b>EventNix<b></b></a>
            </div>
        
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">            
              <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="javascript:void(0)">Home</a></li>
                <li ><a onclick="food.showEventCategory()">Foods and Drinks</a></li>
                <li ><a onclick="social.showEventCategory()">Social and Networking</a></li>
                <li ><a href="javascript:void(0)">Arts and Culture</a></li>
            
                
             
               
              </ul>
            </div><!-- /.navbar-collapse -->
          </div>
        </nav>

      </div>
      
     

      <!-- MAIN CONTENT SECTION -->
      <section class="mainContent clearfix">
        <div class="container">
          <div class="row featuredCollection">
            <div class="col-xs-12">
              <div class="page-header">
                <h4>Featured Events</h4>
              </div>
            </div>
            <div class="col-sm-4 col-xs-12">
              <div class="thumbnail" onclick="location.href='single-product.html';">
                <div class="imageWrapper">
                  <img src="img/home/featured-collection/featured-collection-01.jpg" alt="feature-collection-image">
                  <div class="masking"><a href="product-grid-left-sidebar.html" class="btn viewBtn">View Products</a></div>
                </div>
                <div class="caption">
                  <h4>Shoes</h4>
                </div>
              </div>
            </div>
            <div class="col-sm-4 col-xs-12">
              <div class="thumbnail" onclick="location.href='single-product.html';">
                <div class="imageWrapper">
                  <img src="img/home/featured-collection/featured-collection-02.jpg" alt="feature-collection-image">
                  <div class="masking"><a href="product-grid-left-sidebar.html" class="btn viewBtn">View Products</a></div>
                </div>
                <div class="caption">
                  <h4>Bags</h4>
                </div>
              </div>
            </div>
            <div class="col-sm-4 col-xs-12">
              <div class="thumbnail" onclick="location.href='single-product.html';">
                <div class="imageWrapper">
                  <img src="img/home/featured-collection/featured-collection-03.jpg" alt="feature-collection-image">
                  <div class="masking"><a href="product-grid-left-sidebar.html" class="btn viewBtn">View Products</a></div>
                </div>
                <div class="caption">
                  <h4>Glasses</h4>
                </div>
              </div>
            </div>
          </div>
          <div class="row featuredProducts">
            <div class="col-xs-12">
              <div class="page-header">
                <h4>Featured Products</h4>
              </div>
            </div>
            
            

          </div>
          <div class= "row text-center" id = "show-events" ></div>
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
    <script src="plugins/jquery-ui/jquery-ui.js"></script>
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="plugins/rs-plugin/js/jquery.themepunch.tools.min.js"></script>
    <script src="plugins/rs-plugin/js/jquery.themepunch.revolution.min.js"></script>
    <script src="plugins/owl-carousel/owl.carousel.js"></script>
    <script src="plugins/selectbox/jquery.selectbox-0.1.3.min.js"></script>
    <script src="plugins/countdown/jquery.syotimer.js"></script>
    <script src="options/optionswitcher.js"></script>
    <script src="js/custom.js"></script>

  </body>

</html>