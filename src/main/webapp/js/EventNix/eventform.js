var eventform = App.extend(App.Cmp, {
	httpUrl: "./addEvent",
	responseTarget: 'ajax-content',
	modelId: 'eventform',
	modelName: 'Create Event',
	button1: "Edit",
	button2: "Delete",
	model:[{
		id: 'name',
		name: 'name',
		placeholder: 'Enter the name of the event',
		type: 'text',
		span: 'fa fa-certificate'
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
	},{
		name: 'endDate'
		
		
		
		
	},
{
		name: 'imageName'
		
		
		
	},{
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
 var showeventform = function (){
	eventform.init();
}
