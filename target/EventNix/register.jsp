<!DOCTYPE html>
<html lang="en">
  

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EventNix| Register</title>

    <!-- Bootstrap -->
	<script src="js/pace.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/theme.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
  </head>
  <body>
	<div class="container" id="container" style="display:none;">
		<header>
			<!-- Main comapny header -->
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			  <div class="container">
				<div class="navbar-header">
				  <a class="navbar-brand top-navbar-brand" href="#"><img src="images/alpha-logo.png"/>EventNix</a>
				</div>
			  </div>
			</nav>
		</header>
		<section id="form">
			<div class="container">    
				<div id="registertext" class="mainbox col-xs-12 col-sm-6">  
					<div class="jumbotron black-alpha-90 animated fadeInLeft">
						<h2>Be a member of <img src="images/alpha-logo.png"/>EventNix</h2>
						<p>Benefits of you: </p>
						<ul>
							<li>Book for events at the touch of your screen</li>
							<li>Advertise events in four simple steps</li>
						</ul>
					</div>
				</div>
				<div id="loginbox" class="mainbox col-xs-12 col-sm-6 animated zoomInDown">                    
					<div class="panel white-alpha-90" >
						<div class="panel-heading">
							<div class="panel-title text-center"><h2>Sign In to <span class="text-primary">EventNix</span></h2></div>
						</div>     
						<div class="panel-body" >
							<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
							<div id="register-form">
								 <form id="loginform" class="form-horizontal" role="form">
								<!--<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input id="login-username" type="text" class="form-control" name="name" value="" placeholder="name">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username">
								</div>
								<div class="input-group col-xs-6">
									<span class="input-group-addon">fs</span>
									<input id="login-username" type="text" class="form-control" name="email" value="" placeholder="email">
								</div>
								<div class="input-group col-xs-6">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input id="login-password" type="password" class="form-control" name="password" placeholder="password">
								</div>
																<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input id="login-username" type="text" class="form-control" name="name" value="" placeholder="name">
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username">
								</div>
								<div class="input-group col-xs-6">
									<span class="input-group-addon">@</span>
									<input id="login-username" type="text" class="form-control" name="email" value="" placeholder="email">
								</div>
								<div class="input-group col-xs-6">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input id="login-password" type="password" class="form-control" name="password" placeholder="password">
								</div>
								<div class="input-group col-xs-12 text-center login-action">
								  <div class="checkbox">
									<label>
									  <input id="login-remember" type="checkbox" name="remember" value="1" style="margin-top: 10px;"> I agree to terms and conditions &nbsp;
									  <span id="btn-login"><a href="#" class="btn btn-success">Register  </a></span>
									</label>
								  </div>
								</div>
								<div style="margin-top:10px" class="form-group">
									<div class="col-sm-12 controls">
									  
									</div>
								</div>
							</form> -->
							</div>     
						</div>                     
					</div>  
				</div>
			</div>
		</section>
		<footer>
			<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
			  <div class="container text-center">
				<div class="footer-content">
				  Already registered? <a href="login.jsp" class="btn btn-primary"> Sign In </a>
				</div>
			  </div><!-- /.container-fluid -->
			</nav>
		</footer>
	</div>
	<script src="js/EventNix/base.app.js"></script>
	<script src="js/EventNix/register.js"></script>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.backstretch.min.js"></script>
	<script>
		Pace.on('hide', function(){
		  $("#container").fadeIn('1000');
		  $.backstretch([
				"images/taxi-2.jpg"
			], {duration: 5000, fade: 1000});
		});		
	</script>
  </body>
</html>