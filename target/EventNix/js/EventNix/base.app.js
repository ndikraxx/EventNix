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
			var form = '<form id="loginform" class="form-horizontal" role="form">';
			context.model.forEach(function(el){
				
				form+= '<div class="input-group">'
					if (el.type =="select" && el.options){
						form+='<span class="input-group-addon"><i class="'+el.span+'"></i></span>'
						form += '<select class="form-control" name="' + el.name
						+ '" id="' + el.id + '">';
						el.options.forEach(function(opt) {
							form += '<option value=' + opt.value + '>' + opt.label+ '</option>'
							});
						form += '</select></div>';
					}
					else {
						form+='<span class="input-group-addon"><i class="'+el.span+'"></i></span>'
						+'<input type="'+ el.type+ '" name="' + el.name + '" class="form-control" id="'
						+ el.id + '" placeholder ="'+el.placeholder+'" required ="'+el.required+'"></div>';
					}
				
			});
			
			form+='</form>';
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
				
				}
			});
			
			
		}
		
		
}
