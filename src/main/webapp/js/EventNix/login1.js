var login1 = App.extend(App.Cmp, {
	responseTarget: 'login-form',
	httpUrl: './login',
	modelId: 'login',
	modelName: 'Login',
	model: [{
		id: 'phone',
		name: 'phone',
		type: 'text',
		required: 'required',
		placeholder: 'Enter your phone number',
		span: 'fa fa-phone'
		
	},{
		id: 'password',
		name: 'password',
		type: 'password',
		required: 'required',
		placeholder: 'Password',
		span: 'fa fa-lock'
	}]
});


(function(){
	login1.form();
})();

	

	