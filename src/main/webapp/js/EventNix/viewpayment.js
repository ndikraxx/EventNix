var payment = App.extend(App.Cmp, {
	responseTarget: 'payment-form',
	httpUrl: './viewEvent',
	modelId: 'payment',
	modelName: 'Confirm payment',
	model: [{
		name: 'firstname'
	},{
		name: 'lastname'
	},{
		name: 'email'
	},{
		name: 'phone'
	},{
		name: 'tickets'
	},{
		name: 'amount'
}]
});