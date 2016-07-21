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
				httpUrl: context.httpUrl+ '/approve?id='+id,
				responseTarget: context.responseTarget,
				updateTarget: function (resp){
					
				}
			});
		},
		
		disapprove: function (id){
			var context = this;
			
			context.ajaxRequest.call({
				httpMethod: context.httpMethod,
				httpUrl: context.httpUrl+ '/disapprove?id='+id,
				responseTarget: context.responseTarget,
				updateTarget: function (resp){
					
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
						'<img  class="media-object" src="img/home/featured-collection/featured-collection-01.jpg" alt="feature-collection-image" height="150px" width="200px"/>' +
						'</div>'+
						'<div class="media-body">'+
						'<p> VENUE:  '+obj.venue+'</p>'+
						'<p>PRICE:  '+obj.price+'</p>'+
						' <p>ON: STILL TO COME></p>'+
		                 '<p>TILL: STILL TO COME></p>'+
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
						context.getEl(context.responseTarget).innerHTML = div;

						if (context.getEl(context.responseTarget).innerHTML = div) {
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
					
					context.getEl(context.responseTarget).innerHTML = div;

					
				
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
							div += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 box-shadow">';
							div +=  '<div class="thumbnail">';
							//console.log(buttonId);
							div+= '<img src="img/home/featured-collection/featured-collection-01.jpg" alt="feature-collection-image">';	
			                 div+='<div class="caption">';
						div += '<h4>'+el.name+'</h4>';
						div += '<p>'+el.venue+'</p>';
						div += '<p>'+el.price+'</p>';
						div += ' <a class="btn btn-primary" id = "'+buttonId+'">See More</a>';
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
						div += ' <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 box-shadow">';
						div +=  '<div class="thumbnail">';
						div+= '<img src="img/home/featured-collection/featured-collection-01.jpg" alt="feature-collection-image" class="">';	
		                 div+='<div class="caption">';
					div += '<h4>'+el.name+'</h4>';
					div += '<p>'+el.venue+'</p>';
					div += '<p>'+el.price+'</p>';
					div += ' <a class="btn btn-sm btn-primary" id = "'+buttonId+'" >See More</a>';
					
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
		}
}
