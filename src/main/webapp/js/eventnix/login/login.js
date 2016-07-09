var login =  App.extend (App.Cmp, {
	model: [{

	id: "username",
	name: "password",
	type: "text",
	required: "required",
	placeholder: "Username"
},{
	id:"password",
	name: "password",
	type: "password",
	required: "required",
	placeholder: "Password"	
}]
}