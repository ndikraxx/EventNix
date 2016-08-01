<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>EventName</title>
	<!-- Bootstrap -->

<style>
</style>

</head>

<body>
	<!--navbar-->
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
				<ul class="nav navbar-nav">
					<li><a href="template.php">Home</a> </li>

			                                   
                     
                           
			

		<!--jumbotron-->
               
		<div class="jumbotron">
			<div class="container text-center">
                         
				<p>
					</p>
				<form class="form-inline" role="form" action="search-results.php" method="post">
					<label><h4>Search an event by:</h4></label>
					<select class="form-control" name="searchvalue">
                             	      <option value="Name">Name</option>
                             	      <option value="Venue">Venue</option>
                             	      <option value="Description">Description</option>
                                    </select>
                    <input type="text" class="form-control" name="parameter" placeholder="Enter search parameter: "/>
                    <button class="btn btn-large btn-warning" type="submit" name="search">SEARCH</button>
				</form>
				</div>
		</div><!-- End of Jumbotron-->



          </div>
          <div class= "row text-center" id = "show-events" ></div>
        </div>
      </section>

      <!-- LIGHT SECTION -->
      
      
   
    
	</body>
</html>
 
				
