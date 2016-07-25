<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<!-- start:font awesome v4.1.0 -->
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <!-- start:bootstrap reset -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap-reset.css">
  

<script type="text/javascript" src= "https://cdn.jsdelivr.net/momentjs/2.14.1/moment.min.js"></script>
	  
<link href="js/EventNix/boot/datetimepicker.min.css" rel="stylesheet">
<script src="js/EventNix/boot/jquery-2.1.4.js"></script>
     <script src="js/EventNix/boot/datetimepicker.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
        
        <script>
       
        </script>

<div class="container">
    <div class='col-md-5'>
      <form role="form" method="post" action= "./fileUpload" enctype="multipart/form-data" >
      		<div class="form group">
      			<input type="text" class="form-control" id="event_name" id="ename" name="event_name"   placeholder="Enter Event Name" required>
                        
                            
                         </br>
			<input type="text" class="form-control" id="venue" name="event_venue" placeholder="Enter your venue" required>
				</br>
 <div><input type="number" class="form-control" id="nts"  name="number_of_tickets" placeholder="Number of Tickets Available" required>
            <span id="st" class="text-danger">
                
            </span></div></br>

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
            $(function () {
                $('#datetimepicker2').datetimepicker({
                    locale: 'en',
                  
                });
            });
        </script>

 <script type="text/javascript">
            $(function () {
                $('#datetimepicker3').datetimepicker({
                    locale: 'en',
                  
            
                });
            });
        </script> 
         

  

<div><span id="sdate" class="text-danger"></span></div>
        <br>
        <div class="form-group form-inline text-left">
      			<label for="inputfile">Select an image
      				<input type="file" id="inputfile" name="event_image" required></label>
      			
      			</div>
      				<button type = "submit" class="btn btn-lg btn-info"  id="submita" name="submit"  >Submit</a>
      			      	</form>  
      			      	
      			      	
      			      	
</body>

		<!-- start:arjuna.js --></html>