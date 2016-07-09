var App =  App || {};

App.extend = function (prototype, literal){
	var newLiteral = Object.create(prototype);
	Object.keys(literal).forEach(function (k){
		newLiteral[k] = literal[k];
	})
	return newLiteral;
}

App.Cmp = {
		httpMethod: 'GET',
		responseTarget: '',
		async: true,
		httpUrl: '',
		updateTarget: function (resp){
			var context = this
		context.getEl(context.reponseTarget).innerHTML = resp;
		},
		getEl: function (elementId){
			return document.getElementById(elementId);
		},
		ajaxRequest: function (){
			var context = this;
			var ajax = new XMLHttpRequest ();
			ajax.onreadystatechange = function (){
				if(ajax.readyState == 4 && ajax.status == 200){
				me.updateTarget(ajax.responseText);
				}
			}
			
		},
		
		

		
	
};