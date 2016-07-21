var payment = App.extend(App.Cmp, {
	responseTarget: 'payment-form',
	httpUrl: './viewEvent',
	modelId: 'payment',
	modelName: 'Confirm payment',
	model: [{
		id: 'phone',
		name: 'phone',
		type: 'text',
		required: 'required',
		placeholder: 'Enter phone number',
		span: 'fa fa-phone'
		
	},{
		id: 'transaction',
		name: 'transaction',
		type: 'text',
		required: 'required',
		placeholder: 'Enter MPESA transaction',
		span: 'fa fa-money'
	}]
});


	