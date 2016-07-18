var eventaction = App.extend(App.Cmp, {
	httpUrl: "./addEvent",
	responseTarget: 'ajax-content',
	modelId: 'eventaction',
	modelName: 'Create Event',
	button1: "Approve",
	button2: "Disapprove",
	model:[{
		name: 'name',
	},{
		id: 'venue',
		name: 'venue',
		placeholder: 'Enter the event venue',
		type: 'text',
		span: 'fa fa-building-o'
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
		placeholder: 'Enter the start date', 
		span: ' fa fa-certificate '
	},/*{
		id: 'image',
		name: 'image',
		placeholder: 'Select image',
		type: 'file',
		span: ' fa fa-file-image-o'
	},*/{
		type: 'select',
		id: 'category',
		name: 'category',
		options:[
		          {label: "Social and Networking", value: "Social and Networking"},
		          {label: "Foods and Drinks", value: "Foods and Drinks"},
		          {label: "Music", value: "Music"},
		          {label: "Arts and Culture", value: "Arts and Culture"}
		          ],
		span: ' fa fa-sort-desc'
		
	},{
		id: 'description',
		name: 'description',
		placeholder: 'Enter your description here',
		type: 'textarea',
		span: ' fa fa-keyboard-o'
		
	},{
		name: 'status',
		type: 'hidden'
	}
	],	
});

