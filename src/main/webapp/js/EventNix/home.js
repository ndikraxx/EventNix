var home = App.extend(App.Cmp, {
	responseTarget: 'show-events',
	
	httpUrl: "./addEvent",
	page: 'home'
});
(function(){
	home.showEvent();
})();
