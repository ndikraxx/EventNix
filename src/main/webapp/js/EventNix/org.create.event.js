var event = App.extend(App.Cmp, {
	//httpUrl: "./register",
	responseTarget: 'ajax-content',
	modelId: 'createEvent',
	modelName: 'Create Event',
	model:[{
		id: 'name',
		name: 'name',
		placeholder: 'Enter the name of the event',
		type: 'text',
		span: 'fa fa-certificate '
	},{
		id: 'venue',
		name: 'venue',
		placeholder: 'Enter the event venue',
		type: 'text',
		span: 'fa fa-map'
	},{
		id: 'price',
		name: 'price',
		placeholder: 'Ksh....',
		type: 'number',
		span: 'fa fa-usd '
	},
	{
		id: 'ticketsAvailable',
		name: 'ticketsAvailable',
		placeholder: 'Enter number of tickets available',
		type: 'number',
		span: 'fa fa-ticket '
	},{
		id: 'startDate',
		name: 'startDate',
		type: 'text',
		span: ' fa fa-certificate '
	},{
		id: 'image',
		name: 'image',
		placeholder: 'Select image',
		type: 'file',
		span: 'fa-file-image-o'
	},{
		id: 'category',
		name: 'category',
		options: [
		          {name: "Social and Networking", value: "Social and Networking"},
		          {name: "Foods and Drinks", value: "Foods and Drinks"},
		          {name: "Music", value: "Music"},
		          {name: "Arts and Culture", value: "Arts and Culture"}
		          ],
		span: ' fa fa-sort-desc'
		
	},{
		id: 'desc',
		name: 'desc',
		placeholder: 'Enter your description here',
		type: 'textarea',
		span: ' fa fa-keyboard-o'
		
	}
	],
	
		
		
	
	
});
