var login = App.extend(App.Cmp, {
	responseTarget: 'login-form',
	httpUrl: './login',
	modelId: 'login',
	modelName: 'Login',
	model: [{
		id: 'username',
		name: 'username',
		type: 'text',
		required: 'required',
		placeholder: 'Username',
		span: 'fa fa-user'
		
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
	login.form();
})();

	