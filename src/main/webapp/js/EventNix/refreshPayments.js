(function (){
	var ajax = new XMLHttpRequest();
	ajax.onreadystatechange = new function (){
		if (status == 200 && readyState == 4){
			
		}
		
	}
	ajax.open("GET", "./ticket", true);
	ajax.send();
	
})();