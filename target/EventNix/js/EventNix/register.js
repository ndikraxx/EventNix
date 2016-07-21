var register = App.extend(App.Cmp, {
	httpUrl: "./register",
	responseTarget: 'register-form',
	modelId: 'register',
	modelName: 'Sign Up',
	model: [{
		id: 'firstname', 
		name: 'firstname',
		type: 'text',
		placeholder: 'Enter your first name',
		span: 'fa fa-user',
		required: 'required'
	},{
		id: 'lastname', 
		name: 'lastname',
		type: 'text',
		placeholder: 'Enter your last name',
		span: 'fa fa-user',
		required: 'required',
		form: 'input'
	},{
		id: 'phonenumber', 
		name: 'phone',
		type: 'text',
		placeholder: 'Enter your phone number',
		span: 'fa fa-phone',
		required: 'required',
		form: 'input'
	},
	{
		id: 'identification', 
		name: 'id',
		type: 'text',
		placeholder: 'Enter your id or passport number',
		span: 'fa fa-user',
		required: 'required',
		form: 'input'
	},{
		id: 'email', 
		name: 'email',
		type: 'email',
		placeholder: 'Enter your email',
		span: 'fa fa-envelope',
		required: 'required',
		form: 'input'
	},{
		id: 'usertype',
		name: 'usertype',
		type: 'select',
		span: 'fa fa-user',
		options: [
		          {label: 'Attender', value: 'Attender'},
		          {label: 'Organizer', value: 'Organizer'}
		          ]
	},{
		id: 'password', 
		name: 'password',
		type: 'password',
		placeholder: 'Enter your password',
		span: 'fa fa-lock',
		required: 'required',
		form: 'input'
	},{
		id: 'rpassword', 
		name: 'rpassword',
		type: 'password',
		placeholder: 'Repeat your password',
		span: 'fa fa-lock',
		required: 'required',
		form: 'input'
	}]
});

(function (){
	register.form();
})();