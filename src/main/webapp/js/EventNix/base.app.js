var App = App || {};

App.extend = function (prototype, literal){
	var newLiteral = Object.create(prototype);
	Object.keys(literal).forEach (function (k){
		newLiteral[k] = literal[k];
	})
	return newLiteral;
}

App.Cmp = {
		responseTarget : '',
		httpMethod : 'GET',
		async : true,
		httpUrl : '',
		requestParams : '',
		getEl : function(elId) {
			return document.getElementById(elId);
		},
		updateTarget : function(resp) {
			var me = this;
			me.getEl(me.responseTarget).innerHTML = resp;
		},
		redirect: function(url){
			window.location = url;
		},
		ajaxRequest : function() {
			var me = this;
			var xhr = new XMLHttpRequest();

			xhr.onreadystatechange = function() {

				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						me.updateTarget(xhr.responseText);
					}
				}
			}

			xhr.open(me.httpMethod, me.httpUrl, me.async);
			if (me.requestParams) {
				xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
				xhr.send(me.requestParams);
			} else
				xhr.send();
		},

		model : [],
		form : function() {
			var context = this;
			var form= '<div class="panel-body">	<div> ';
			
		 form+= '<form id="loginform" class="form-horizontal" >';
			context.model.forEach(function(el){
				
				form+= '<div class="input-group">'
					if (el.type =="select" && el.options){
						form+='<span class="input-group-addon"><i class="'+el.span+'"></i></span>'
						form += '<select class="form-control" name="' + el.name
						+ '" id="' + el.id + '">';
						el.options.forEach(function(opt) {
							form += '<option value=' + opt.value + '>' + opt.label+ '</option>'
							});
						if (context.modelId == 'eventform'){
							 form +="</select></div><br>";
							}
							else {
								form += '</select></div>';
							}
					}
					else if (el.type == 'textarea'){
						form+='<span class="input-group-addon"><i class="'+el.span+'"></i></span>'
						+'<'+el.type+ ' name="' + el.name + '" class="form-control" id="'
						+ el.id + '" placeholder ="'+el.placeholder+'" required ="'+el.required+'" COLS=400 ROWS=6>'; 
						form+='</'+el.type+'>';
						 form +="</div><br>";
					}
					else if (el.type == 'number') {
						form+='<span class="input-group-addon"><i class="'+el.span+'"></i></span>'
						+'<input type="'+ el.type+ '" name="' + el.name + '" class="form-control" id="'
						+ el.id + '" placeholder ="'+el.placeholder+'" required ="'+el.required+'">'; 
						if (context.modelId == 'eventform' || context.modelId == 'payment'){
						 form +="</div><br>";
						}
						else {
							
							form +="</div>";
						}
						
					}
				
					else {
						form+='<span class="input-group-addon"><i class="'+el.span+'"></i></span>'
						+'<input type="'+ el.type+ '" name="' + el.name + '" class="form-control" id="'
						+ el.id + '" placeholder ="'+el.placeholder+'" required ="'+el.required+'">'; 
						if (context.modelId == 'eventform' || context.modelId == 'payment'){
						 form +="</div><br>";
						}
						else {
							
							form +="</div>";
						}
						
					}
				
			});
			
			form+='</form></div></div>';
			form+= '<a class="btn btn-success" id= "'+context.modelId+'-save">'+context.modelName+'</a>';
			context.updateTarget(form);
			
			context.getEl(context.modelId+"-save").addEventListener("click", function(){
				context.submit();
			})
			
		},
		
		submit: function(){
			var context = this;
			var formValues = context.model.filter(function(el){
				var formElement = context.getEl(el.id);
				 if (!formElement)
					 
					 return; 
				 
				 el.value = formElement.value;
				 
				 return el;
			}).map(function (el){
				return encodeURIComponent(el.name) + '=' + encodeURIComponent(el.value);
			}).join('&');
			
			context.ajaxRequest.call({
				httpMethod : 'POST',
				httpUrl : context.httpUrl,
				requestParams : formValues,
				responseTarget : context.responseTarget,
				updateTarget : function(resp) {
				context.redirect(resp);
				}
			});	
		},
		
		approve: function (id){
			var context = this;
			
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl: './addEvent/approve?id='+id,
				responseTarget: context.responseTarget,
				updateTarget: function (resp){

				}
			});
		},
		
		disapprove: function (id){
			var context = this;
			
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl:'./addEvent/disapprove?id='+id,
				responseTarget: context.responseTarget,
				updateTarget: function (resp){
					
				}
			});
		},
		
		loadOrganizerEvents: function (){
			var context = this;
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl: './addEvent/loadOrganizerEvent',
				responseTarget: 'ajax-content',
				updateTarget: function (resp){
				var json = JSON.parse(resp)
				var div = '';
				json.forEach(function (el){
					if (el.status == "Approved"){
					var buttonId = "eventId-"+el.id;
					div+= '<button type="button" class="btn btn-primary" id ='+buttonId+'>'+el.name+'</button> &nbsp&nbsp'
					}
					});
				div+='</div>';
				
				context.getEl('ajax-content').innerHTML = div;
				if (context.getEl('ajax-content').innerHTML = div){
					var json = JSON.parse(resp)
					json.forEach(function (el){
						if (el.status =="Approved"){
							var buttonId = "eventId-"+el.id;
							 context.getEl(buttonId).addEventListener("click", function (){
								 context.viewAttendersList(el.id);
							 });
						}
						
						
				 });
				}
			}
			});
			
		},
		loadOrganizerEventsAdmin: function (){
			var context = this;
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl: './addEvent/viewEventsAdmin',
				responseTarget: 'ajax-content',
				updateTarget: function (resp){
				var json = JSON.parse(resp)
				var div = '';
				json.forEach(function (el){
					var buttonId = "eventId-"+el.id;
					div+= '<button type="button" class="btn btn-primary" id ='+buttonId+'>'+el.name+'</button> &nbsp&nbsp'
				});
				div+='</div>';
				context.getEl('ajax-content').innerHTML = div;
				if (context.getEl('ajax-content').innerHTML = div){
					var json = JSON.parse(resp)
					json.forEach(function (el){
						
						var buttonId = "eventId-"+el.id;
					 context.getEl(buttonId).addEventListener("click", function (){
						 context.viewAttendersList(el.id);
					 });
				 });
				}
			}
			});
			
		},
		search: function(){
			var context = this;
			context.ajaxRequest.call({
				httpMethod: 'GET',
				responseTarget: 'search',
				updateTarget: function (resp){
			var div = '<div class="container text-center"><p></p>'
			+'<form class="form-inline" role="form" action="./search" method="post">'
			+'	<label><h4>Search an event by:</h4></label>'
			+'<select class="form-control" name="searchvalue">'
			+'        	      <option value="Name">Name</option>'
			+'          	      <option value="Venue">Venue</option>'
			+'            	      <option value="Description">Description</option>'
			+'                   </select>'
			+'   <input type="text" class="form-control" name="parameter" placeholder="Enter search parameter: "/>'
			+'  <a class="btn btn-large btn-warning" onclick ="App.Cmp.submit()" name="search" ">SEARCH</a>'
			+'</form>'
			 
			+'</div>'
			context.getEl('search').innerHTML =div;
				}
			})
		},
		
		viewPaymentProgress: function (){
			var context = this;
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl: './addEvent/loadOrganizerEvent',
				responseTarget: 'ajax-content',
				updateTarget: function (resp){
				var json = JSON.parse(resp)
				var div = '';
				json.forEach(function (el){
					if (el.status == "Approved"){
					var buttonId = "eventId-"+el.id;
					div+= '<button type="button" class="btn btn-primary" id ='+buttonId+'>'+el.name+'</button> &nbsp&nbsp'
					}
				});
				div+='</div>';
				context.getEl('ajax-content').innerHTML = div;
				if (context.getEl('ajax-content').innerHTML = div){
					var json = JSON.parse(resp)
					json.forEach(function (el){
						if(el.status == "Approved"){
						var buttonId = "eventId-"+el.id;
					 context.getEl(buttonId).addEventListener("click", function (){
						
					context.showTicketsSold(el.id);
					 context.showPaymentReport(el.id);
					 context.SalesReport(el.id)
					 
					 });
						}
				 });
				}
			}
			});
			
			
		},
		viewPaymentProgressAdmin: function (){
			var context = this;
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl: './addEvent/viewEventsAdmin',
				responseTarget: 'ajax-content',
				updateTarget: function (resp){
				var json = JSON.parse(resp)
				var div = '';
				json.forEach(function (el){
					var buttonId = "eventId-"+el.id;
					div+= '<button type="button" class="btn btn-primary" id ='+buttonId+'>'+el.name+'</button> &nbsp&nbsp'
					
				});
				div+='</div>';
				context.getEl('ajax-content').innerHTML = div;
				if (context.getEl('ajax-content').innerHTML = div){
					var json = JSON.parse(resp)
					json.forEach(function (el){
						var buttonId = "eventId-"+el.id;
					 context.getEl(buttonId).addEventListener("click", function (){
						
					context.showTicketsSold(el.id);
					 context.showPaymentReport(el.id);
					 context.SalesReport(el.id)
					 });
				 });
				}
			}
			});
			
			
		},
		showOrganizerEventsProgress : function(){
			var context = this;
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl: './addEvent/loadOrganizerEvent',
				responseTarget: 'ajax-content',
				updateTarget: function (resp){
					var table = '<table class= "table table-bordered table-striped table-condensed">'
						table += "<tr>"
							table +='<th>Event Name</th>'
							table +='<th>Venue</th>'
							table +='<th>Price</th>'
							table +='<th>category</th>'
							table +='<th>description</th>'
							table +='<th>status</th>'
							table +='<th>ticketsAvailable</th>'
							table +='<th>image</th>'
							table +='<th>startDate</th>'
							table +='<th>endDate</th>'	
								
					table+="</tr>";
					
					var json = JSON.parse(resp)
					json.forEach(function (el){
						table+='<tr>'
						table+='<td>'+el.name+'</td>'
						table+='<td>'+el.venue+'</td>'
						table+='<td>'+el.price+'</td>'
						table+='<td>'+el.category+'</td>'
						table+='<td>'+el.description+'</td>'
						
						if(el.status =="Approved")
						table+='<td><span class="label label-primary">APPROVED</span></td>'
						else if (el.status == "Disapproved")
						table+='<td><span class="label label-warning">DISAPPROVED</span></td>'
						else 
							table+='<td><span class="label label-default">PENDING</span></td>'
						table+='<td>'+el.ticketsAvailable+'</td>'
						table+='<td><img  height= "70px" width = "70px" src="myimages/'+el.imageName+'"/></td>'
						table+='<td>'+el.startDate+'</td>'
						table+='<td>'+el.endDate+'</td>'
						table += '</tr>';
						
					});
					table+="</table>";
					context.getEl('ajax-content').innerHTML = table;
			}
			});
		},
		showOrganizerEventsProgressAdmin : function(){
			var context = this;
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl: './addEvent',
				responseTarget: 'ajax-content',
				updateTarget: function (resp){
		
					var table = '<table class= "table table-bordered table-striped table-condensed">'
						table += "<tr>"
							table +='<th>Event Name</th>'
							table +='<th>Venue</th>'
							table +='<th>Price</th>'
							table +='<th>category</th>'
							table +='<th>description</th>'
							
							table +='<th>ticketsAvailable</th>'
							table +='<th>image</th>'
							table +='<th>startDate</th>'
							table +='<th>endDate</th>'
							table +='<th>Approve</th>'	
							table +='<th>Disapprove</th>'	
								
					table+="</tr>";
					
					var json = JSON.parse(resp)
					json.forEach(function (el){
						var approve = "approve-"+el.id; 
						var disapprove ="disapprove-"+el.id;
						if(el.status =="null"){
							
							table+='<tr>'
						table+='<td>'+el.name+'</td>'
						table+='<td>'+el.venue+'</td>'
						table+='<td>'+el.price+'</td>'
						table+='<td>'+el.category+'</td>'
						table+='<td>'+el.description+'</td>'
						table+='<td>'+el.ticketsAvailable+'</td>'
						table+='<td><img  height= "70px" width = "70px" src="myimages/'+el.imageName+'"/></td>'
						table+='<td>'+el.startDate+'</td>'
						table+='<td>'+el.endDate+'</td>'
						table += "<td><a class = \"btn btn-primary\" id=\""+approve+"\">Approve</a></td>";
						console.log(approve)
						table += "<td> <a class=\"btn btn-danger\"  id=\""	+ disapprove + "\">Disapprove</a></td>";
						table += '</tr>';
						}
					});
					table+="</table>";
					
					context.getEl('ajax-content').innerHTML = table;
					if (context.getEl('ajax-content').innerHTML = table) {
					json.forEach(function(el) { 
						if (el.status == "null"){
						var approve = "approve-"+el.id; 
						var disapprove ="disapprove-"+el.id;
					context.getEl(approve).addEventListener('click', function() {
						alertify.confirm("Do you want to proceed", function (e) {
						    if (e) {
						    	context.approve(el.id);
								alertify.error("You have approved the event successfully")
								context.showOrganizerEventsProgressAdmin ();
						    } else {
						    	alertify.error("You have not approved the event")
						    }
						});
						
					
					});
					
					context.getEl(disapprove).addEventListener('click', function() {
						alertify.confirm("Do you want to proceed", function (e) {
						    if (e) {
						context.disapprove(el.id);
						alertify.error("You have Disapproved the event successfully")
						context.showOrganizerEventsProgressAdmin ();
						    } else {
						    	alertify.error("You have not disapproved the event")
						    }
						});
					});
						}
					});	
					
			}
				}
			});
		},
		
		viewAttendersList: function (id){
			var context = this;
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl: './ticket/viewAttendersList?eventid='+id,
				responseTarget: 'nested-attenders-list',
				updateTarget: function (resp){
					console.log(resp)
					var json = JSON.parse(resp)
					var obj = Object.keys(json)
					if(!obj.includes("0")){
						document.getElementById('showAttenders').style.display = 'block';
						document.getElementById("showAttenders").innerHTML ="<br><br><br><br><br><br><h2>No Tickets have been sold</h2><br><br><br><br><br><br>";
						
					}
					else {
					var table = '<table class= "table table-bordered table-striped table-condensed">'
						table += "<tr>"
							table +='<th>Firstname</th>'
							table +='<th>Lastname</th>'
							table +='<th>Email</th>'
							table +='<th>phone</th>'
							table +='<th>Tickets</th>'
							table +='<th>Amount</th>'
							table +='<th>Amount Paid</th>'
					table+="</tr>";
					
					var json = JSON.parse(resp)
					json.forEach(function (el){
						table+='<tr>'
						table+='<td>'+el.firstname+'</td>'
						table+='<td>'+el.lastname+'</td>'
						table+='<td>'+el.email+'</td>'
						table+='<td>'+el.phone+'</td>'
						table+='<td>'+el.tickets+'</td>'
						table+='<td>'+el.amount+'</td>'
						table+='<td>'+el.amountPaid+'</td>'
						table += '</tr>';
						
					});
					table+="</table>";
					
					document.getElementById('showAttenders').style.display = 'block';
					context.getEl('showAttenders').innerHTML = table;
					}
					
				}
			});
			
		},
		
		listView : function() {
			var me = this;

			me.ajaxRequest.call({
				httpMethod : me.httpMethod,
				httpUrl : me.httpUrl,
				responseTarget : me.responseTarget,
				updateTarget : function(resp) {
				var table = '<table class= "table table-bordered table-striped table-condensed">'
				table += "<tr>";
				me.model.forEach(function (el){
					table+='<th>'+el.name+'';
					
				});
				table+="</th>";
				table+="<th></th>";
				table+="<th></th></tr>";
					var jsonRecords = JSON.parse(resp);
					var obj = Object.keys(jsonRecords);
					console.log ("this is the object " +obj)
					jsonRecords.forEach(function(el) {
						var approve = "approve-"+el.id; 
						var disapprove ="disapprove-"+el.id;
						var del ="del-" + el.id;
						var edit="edit-" + el.id;
						table+='<tr>';
						if (el.status == 'Approved'){
							console.log ("the event is approved")
						}
						
						me.model.forEach(function (model){
							if (model.name != "imageName")
							table += '<td>'  +el[model.name] + '</td>'
							
							
							
								
						});
						if (me.modelId == "eventaction"){
						table += "<td><a class = \"btn btn-primary\" id=\""+approve+"\">Approve</a></td>";
						table += "<td> <a class=\"btn btn-danger\"  id=\""	+ disapprove + "\">Disapprove</a></td>";
						table += '</tr>';
						}
						else if (me.modelId == "eventform"){
							table += "<td> <a class=\"btn btn-primary\"  id=\""	+ edit + "\">Edit</a></td>";;
							table += "<td> <a class=\"btn btn-danger\"  id=\""	+ del + "\">Delete</a></td>";
							table += '</tr>';
						}
						
				
				});
					table+="<table>";
				
					me.getEl(me.responseTarget).innerHTML = table;
					
					if (me.getEl(me.responseTarget).innerHTML = table) {
						
						jsonRecords.forEach(function(el) {
		
							var approve = "approve-"+el.id; 
							var disapprove ="disapprove-"+el.id;
							var del ="del-" + el.id;
							var edit="edit-" + el.id;
							
							 if (me.modelId == "eventform"){
							me.getEl(del).addEventListener('click', function() {
								console.log(el.id + "<br>")
							});
							
							me.getEl(edit).addEventListener('click', function() {
								console.log(el.id + "<br>")
							});
							 }
							 
							 else if (me.modelId == "eventaction"){
								 
							me.getEl(approve).addEventListener('click', function() {
								me.approve(el.id);
							});
							
							me.getEl(disapprove).addEventListener('click', function() {
								me.disapprove(el.id);
							});
							
						}
						});
				}
				}
			});
		},
		seeMore: function (id){
			var context = this;
			
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl:'./viewEvent/seemore?id='+id,
				responseTarget: context.responseTarget,
				updateTarget: function (resp){
					var div ='';
					var jsonRecords = JSON.parse(resp);
					console.log(jsonRecords)
				 var obj= Object(jsonRecords);
				
					div += '<div class="container text-center">'+
						'<div class="panel-footer">'+
						'<h2>'+obj.name+'</h2>'+
						'</div>'+
						'<div class="media">'+
						'<div class="media-top media-left">'+
						'<img  class="media-object" src="myimages/'+obj.imageName+'" height="150px" width="200px"/>' +
						'</div>'+
						'<div class="media-body">'+
						'<p> VENUE:  '+obj.venue+'</p>'+
						'<p>PRICE:  '+obj.price+'</p>'+
						' <p>ON: '+obj.startDate+'</p>'+
		                 '<p>TILL: '+obj.endDate+'></p>'+
		                 '  </div>  </div'+
		                 '<div class="panel-footer">DESCRIPTION</div>'+
		                 '<P>'+obj.description+'</p>'+
		                 '<div class="panel-footer">ORDER TICKETS</div>'+
		                 '<table class="table table-responsive text-left"> '+
		                 '<thead>'+
		                 '<tr bgcolor="#999999">'+
		                 '<th>Ticket</th>'+
		                 '<th>Cost per Unit</th>'+
		                 '<th>Total Amount</th>'+
		                 '</tr>'+
		                 '</thead>'+
		                 '<tr>'+
		                ' <td>'+obj.name+'</td>'+
		                '<td>'+
		                '<form  method="post">'+obj.price+
		                ' <select class="unit" name="unit" id ="unit" onclick = >'+
		                
		                '<option value="1">1</option>'+
		                '<option value="2">2</option>'+
		                '<option value="3">3</option>'+
		                '<option value="4">4</option>'+
		                ' <option value="5">5</option>'+
		                ' <option value="6">6</option>'+
		                ' <option value="7">7</option>'+
		                ' <option value="8">8</option>'+
		                '  <option value="9">9</option>'+
		                ' <option value="10">10</option>'+
		                '  <option value="11">11</option>'+
		                ' <option value="12">12</option>'+
		                ' <option value="13">13</option>'+
		                '<option value="14">14</option>'+
		                '<option value="15">15</option>'+
		            '</select></form>'+
		    '</td>'+
		        '<td id="amount_td"></td></tr>'+
		        '</table>'+
		        ' <a class="btn btn-primary" id = "book-ticket">Book Ticket</a>'+
		        '<hr/><br><div>';
					div += '</div></div>';
						context.getEl("show-events").innerHTML = div;

						if (context.getEl("show-events").innerHTML = div) {
							var price, tickets;
							context.getEl("unit").addEventListener("change", function() {
								price = obj.price;
								 tickets = context.getEl('unit').value;
								 totalAmount = tickets * price;
								context.getEl("amount_td").innerHTML = totalAmount;
								});
							context.getEl("book-ticket").addEventListener("click", function (){
								context.bookEvent(obj.id, obj.name, price, tickets);
								context.paymentform();
							})
						}
		}
			});
		},
		

		bookEvent: function (id, name, price, tickets){
			var context = this;
			context.ajaxRequest.call({
				httpMethod: 'GET',
				httpUrl: './viewEvent/eventid?id='+id+'&price='+price+'&tickets='+tickets,
				responseTarget: 'ajax-content',
				updateTarget: function (resp){
					var div = '<div class="container text-center"><div class="well"><h2>'+
					'You have selected <b>'+tickets+'</b> tickets to the <b> '+name+' event </b> each going for Ksh. <b>'+price+'.</b>'+
					'</b><br/> The amount payable is Ksh. <b>'+tickets*price+'</b>'+
					'</h2></div>'+
					' <div class="panel-footer">'+
				    '<h2> Make Payments using MPESA </h2>'+
				   ' </div>'+
				    '<div class="panel-body"> '+
					'<div class="container">'+
					'<div class="row">'+
					'<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">'+
					'  <h3>In order to complete the payment process, you are required to make payment through'+
					' MPESA and reenter the payment details in the form below</h3>'+
					'<ol>'+
					'<div class="panel-body text-left">'+
					'<li> Go to the MPESA Menu on your phone </li>'+
					'<li> Select send money from the menu list </li>'+
					'<li> Enter <b>0715971418</B> </li>'+
					'<li> Enter the amount indicated above</li>'+
					'<li> Enter your MPESA PIN and click Send</li>'+
					'<li> After receiving the confirmation details from MPESA Money, enter the transaction details along with your phone number in the form below</li>'+
					'<li> Once you are through, click on the button "Complete Payment" and wait for a short while as we confirm the details</li>'+
					'</ol>'+
					'<div class="left-align sm-width" id = "payment-form">';
					
					context.getEl("show-events").innerHTML = div;

					
				
				}
			});
			
		},
		 
		userEvents:function(){
			var me = this;
			me.ajaxRequest.call({
				httpMethod :'GET',
				httpUrl : './login/userEvent',
				responseTarget : me.responseTarget,
				updateTarget : function(resp) {
					var json = JSON.parse(resp);
					var object =Object(json);
					var div = '<div class="container">'+
  '<div class="well"><h2>Upcoming Events: Confirmed</h2></div>'+
 '<table class="table table-condensed table-bordered table-hover">'+
    '<tr>'+
     ' <th>EVENT NAME</th>'+
      '<th>CATEGORY</th>'+
      '<th>TICKETS BOOKED</th>'+
      '<th>AMOUNT PAID</th>'+
      '</tr>';
					json.forEach(function (el){
						div+='<tr>'
						div+='<td>'+el.EventName+'</td>'
						div+='<td>'+el.Category+'</td>'
						div+='<td>'+el.Tickets+'</td>'
						div+='<td>'+el.Amount+'</td>'
						div+='</tr>'
					});
					div+='</table>';
					
					
					me.getEl('show-events').innerHTML = div;
					
					
				}
			});
		},
		
		showEvent: function (){
			var me = this;
			//var buttonId = el.id;
			me.ajaxRequest.call({
				httpMethod : me.httpMethod,
				httpUrl : me.httpUrl,
				responseTarget : me.responseTarget,
				updateTarget : function(resp) {
				var div = '';
			
	 		if (me.page == 'home'){
					var jsonRecords = JSON.parse(resp);
					jsonRecords.forEach(function(el) {
						var buttonId = "event-"+el.id;
						
						if (el.status == 'Approved'){
							div += ' <div class="col-sm-6 col-md-4 col-lg-4">';
							div +=  '<div class="thumbnail">';
							div += '<div class="overlay-container">';
							div+= '<img  height= "250px" width = "350px" src="myimages/'+el.imageName+'"/>';	
			                div+= '	<div class="overlay-content">';
			                div+='<h3 class="h4 headline">Description</h3>';
			                div+='<p>'+el.description+'</p>';
			                div+='</div></div>';
							div+='<div class="caption">';
						div += '<div class="thumbnail-meta">';
							div+='<p><b>Event Name </b>: ' +el.name+'</p><hr></div>';
						div += '<div class="thumbnail-meta"><p><b>Venue </b>: '+el.venue+'</p><hr></div>';
						div += '<div class="thumbnail-meta"><span class = "h3">KSH.  <b><i>'+el.price+' /-</i></b></span><hr>';
						div += ' <a class=""btn btn-link pull-right" id = "'+buttonId+'">See More <i class="fa fa-arrow-right"></i></a></div>';
						div+='</div></div></div>'
							
						

						}
						
						div += '</div></div>';
						
						
					});
						me.getEl(me.responseTarget).innerHTML = div;
 	
				if (me.getEl(me.responseTarget).innerHTML = div){
						var jsonRecords = JSON.parse(resp);
					
						jsonRecords.forEach(function(el) {
						if (el.status == 'Approved'){
							var buttonId = "event-"+el.id;
							me.getEl(buttonId).addEventListener('click', function() {
								me.seeMore(el.id);

							});
						}

						});
						
					}
					
					
							
						
						}
	 		else{
	 			
				var jsonRecords = JSON.parse(resp);
				jsonRecords.forEach(function(el) {
					var buttonId = "event-"+el.id;
					
					if (el.status == 'Approved'  && el.category == me.page){
					
							div += ' <div class="col-sm-6 col-md-4 col-lg-4">';
							div +=  '<div class="thumbnail">';
							div += '<div class="overlay-container">';
							div+= '<img  height= "250px" width = "350px" src="myimages/'+el.imageName+'"/>';	
			                div+= '	<div class="overlay-content">';
			                div+='<h3 class="h4 headline">Description</h3>';
			                div+='<p>'+el.description+'</p>';
			                div+='</div></div>';
							div+='<div class="caption">';
						div += '<div class="thumbnail-meta">';
							div+='<p><b>Event Name </b>: ' +el.name+'</p><hr></div>';
						div += '<div class="thumbnail-meta"><p><b>Venue </b>: '+el.venue+'</p><hr></div>';
						div += '<div class="thumbnail-meta"><span class = "h3">KSH.  <b><i>'+el.price+' /-</i></b></span><hr>';
						div += ' <a class=""btn btn-link pull-right" id = "'+buttonId+'">See More <i class="fa fa-arrow-right"></i></a></div>';
						div+='</div></div></div>'
							
						

						}
						
						div += '</div></div>';
			
			});
				me.getEl(me.responseTarget).innerHTML = div;
		 		
			 	
				if (me.getEl(me.responseTarget).innerHTML = div){
						var jsonRecords = JSON.parse(resp);
					
						jsonRecords.forEach(function(el) {
						if (el.status == 'Approved'  && el.category == me.page){
							var buttonId = "event-"+el.id;
							me.getEl(buttonId).addEventListener('click', function() {
								me.seeMore(el.id);

							});
						}

						});
						
					}
		
	 		}
	 		}
			});
				},
		
		init : function() {
			this.form();
		},
		show : function() {
			this.listView(this.httpUrl);
		},
		showEventCategory : function (){
			this.showEvent(this.httpUrl);
		},
		showEventDetails: function(){
			this.seeMore(this.httpUrl);
		},
		
		paymentform: function (){
			payment.form ()
		},
		 showPaymentReport: function(id){
			
			 var jsonObject;
			 var context = this;
				context.ajaxRequest.call({
					httpMethod: context.httpMethod,
					httpUrl: './ticket/ticketsperday?id='+id,
					responseTarget: 'ajax-content',
					updateTarget: function (resp){
						var mydiv = document.getElementById('report');
						 
					    mydiv.style.display = 'block';
				
				
			showTicketsperDay(resp)
						
				}
				});
				
			
			
		 },
		showTicketsSold: function (id){
			
			 var context = this;
				context.ajaxRequest.call({
					httpMethod: context.httpMethod,
					httpUrl: './viewEvent/seemore?id='+id,
					responseTarget: 'ajax-content',
					updateTarget: function (resp){
						var mydiv = document.getElementById('report');
						 
					    mydiv.style.display = 'block'
				
				Script(resp);
					
						
				}
				});
				
				

		},
		SalesReport: function(id){
			
			 var jsonObject;
			 var context = this;
				context.ajaxRequest.call({
					httpMethod: context.httpMethod,
					httpUrl: './ticket/ticketsperday?id='+id,
					responseTarget: 'ajax-content',
					updateTarget: function (resp){

						var mydiv = document.getElementById('report');
						 
						    mydiv.style.display = 'block';
				
						  
						showSalesperDay(resp)
						
				}
				});
				
			
			
		 }
}

function Script (resp) {
	var json = JSON.parse(resp)
	var obj = Object(json)
	 var ticketRemaining = obj.ticketsRemaining;
	var tickestSold =obj.ticketsAvailable- obj.ticketsRemaining

Morris.Donut({

    element: 'ticketsales',
     data:[{label: "Remaining tickets", value: ticketRemaining}, {label: "Sold Tickets"  , value: tickestSold}],
       colors: ['#41cac0', ' #ff3333', '#34a39b'],
    formatter: function (y) { return y }
   });
	
}
	
	function showTicketsperDay (resp) {
		var total =0;
		var json = JSON.parse(resp)
		json.forEach(function (el){
			 total+=el.TicketsBooked;
			 console.log ("THe total is "+total+"\n")
		});
	document.getElementById("ticketsalesperday").innerHTML ="";
		var obj = Object.keys(json)
		if(!obj.includes("0")){
			document.getElementById("ticketsalesperday").innerHTML ="<br><br><br><br><br><br><h2>No Tickets have been sold</h2><br><br><br><br><br><br><br><br><br>";
		}
		else{
		var bar = Morris.Bar({
			
	        element: 'ticketsalesperday',
	        data: json,
	        xkey: 'ticketdate',
	        ykeys: ['TicketsBooked'],
	        labels: ['Tickets Sold'],
	        barRatio: 0.4,
	        xLabelAngle: 35,
	        hideHover: 'auto',
	        barColors: ['#6883a3'],
	        resize: true
	      });
		
		
		}
	}
	

	
	function showSalesperDay (resp) {
		
		var json = JSON.parse(resp)
		var obj = Object.keys(json)
		if(!obj.includes("0")){
			document.getElementById("paymentsperday").innerHTML ="<br><br><br><br><br><br><h2>No Tickets have been sold</h2><br><br><br><br><br><br>";
			document.getElementById("totalPayments").innerHTML ="";
		}
		else{
			var total=0;
			var json = JSON.parse(resp)
			json.forEach(function (el){
				var number = parseInt(el.amount)
				 total+= number;
				
				document.getElementById("totalPayments").innerHTML = "<h2>The total Amount accrued is "+total+"<h2>";
			});
			
	document.getElementById("paymentsperday").innerHTML ="";
		Morris.Bar({
	        element: 'paymentsperday',
	        data: json,
	        xkey: 'ticketdate',
	        ykeys: ['amount'],
	        labels: ['Amount Recieved'],
	        barRatio: 0.4,
	        xLabelAngle: 35,
	        hideHover: 'auto',
	        barColors: [' #ff3333'],
	        resize: true
	      });
		
		
		}
	}


function search(){
		
		

 	var searchvalue = document.getElementById("searchvalue").value;
		var parameter = document.getElementById("parameter").value;
		 var params = 'searchvalue=' + encodeURIComponent(searchvalue)+'&parameter='+encodeURIComponent(parameter);
 App.Cmp.ajaxRequest.call({
	 	responseTarget : '',
		httpMethod : 'POST',
		async : true,
		httpUrl : './search',
		requestParams : params,
		updateTarget: function (resp){
			var div= '<div class=" well text-center">'+
	    	'<h2>SHOWING SEARCH RESULTS</h2>'+
	          '</div>'+
	          '<div class= "container">';
			var response = JSON.parse(resp);
		response.forEach(function (el){
		
        div+=' <div class="media">'+
              '   <div class="media-left media-top ">'+
                           '<img  class="media-object "  height= "170px" width = "300px" src="myimages/'+el.imageName+'"/>'+
                         ' </div>'+
          			'<div class="media-body">'+
          					' <h4>'+el.name+'</h4>'+
          					'<p> VENUE: '+el.venue+'</p>'+
          					'<p>PRICE: KSH '+el.price+'</p>'+
          					'<p>START DATE:  '+el.startDate+'</p>'+
          					'<p>END DATE:  '+el.endDate+'</p>'+
          						'<a class="btn btn-sm btn-primary" id ='+el.id+'>See More</a>'+
          			
                                  '</div>'+
                         ' </div>'+
                       '<hr>	'+
         ' </div>';
			
			document.getElementById('show-events').innerHTML =div;
			

				
    	
			
		})
		if (document.getElementById('show-events').innerHTML =div){
			var jsonRecords = JSON.parse(resp);
		
			jsonRecords.forEach(function(el) {
			
				var buttonId = el.id;
				document.getElementById(buttonId).addEventListener('click', function() {
					console.log(buttonId)
					App.Cmp.seeMore(el.id);

				});
			
			});
		}					
		}
 })
 	
	
}


(function (){

	var mydiv = document.getElementById('report');
	    mydiv.style.display = 'none'
})();

function hideReport(){
	var mydiv = document.getElementById('report');
    mydiv.style.display = 'none'
}
