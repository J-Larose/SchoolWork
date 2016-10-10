if(document.referrer!=""){
	var x = document.referrer;
	document.getElementById("jsp").innerHTML = x;
}else{
	document.getElementById("jsp").innerHTML = "no referrer";
}
