var register = App.extend (App.Cmp, {model: [{
	id: "firstname",
	name: "firstname",
	type: "text", 
	placeholder: "Enter your first name",
	required: "required"
},{
	id: "lastname",
	name: "lastname",
	type: "text", 
	placeholder: "Enter your last name",
	required: "required"
},{
	id: "email",
	name: "email",
	type: "email", 
	placeholder: "Enter your email",
	required: "required"
},{
	id: "phone",
	name: "phone",
	type: "number", 
	placeholder: "Enter your phone number",
	required: "required"
},{
	id: "usertype",
	name: "usertype",
	type: "select",
	options: [
	          {label:"Event Attender", value: "Event Attender"},
	          {label: "Event Marketer", value: "Event Makerter"}
	         ]
},{
	id: "password",
	name: "password",
	type: "password", 
	placeholder: "Enter your password",
	required: "required"
},{
	id: "rpassword",
	name: "rpassword",
	type: "rpassword", 
	placeholder: "Confirm your password",
	required: "required"
}]
});