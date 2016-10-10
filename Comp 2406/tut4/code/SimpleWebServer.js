//simple server listens on the provided port and responds with requested pages

// load modules
var http = require('http');
var fs = require('fs');
var mime = require('mime-types');
const ROOT = "./public_html";

var url = require('url');

// create http server
var server = http.createServer(handleRequest);
server.listen(2406);
console.log('Server listening on port 2406');

//widget
var widgetsData =  {
	barbaloot: "A modification on the idea of a chest of drawers. A barbaloot uses patented rinker-flink technology to randomly exchange the locks and contents of each drawer at a prespecified interval. <span id='slogan'>Barbaloot, you can't lose your belongings if you don't know where they aren't.</span>",
	diffendoofer: "Ever wish your scale knew better than to tell you the truth? Well now it does! The diffendoofer&trade; is not your every day bathroom scale. Preset gravity coeficients, altered physical vibration frequencies, reassuring lies, all easily programmable with the included diffendoofr smartphone app!",
	flooberblub: "Toilet related smartphone accidents account for 1/3rd of all broken smartphones, and 3/5ths of all ear infections! Protect your smartphone with a flooberblub, the world's leading floatation-based retrieval technology. Clincal trials have proven flooberblubs will catch 85% of all falling smartphones before they hit the surface of the water. The remaining 15% will be retreived through the flooberblubs system of flushing and filtering. <span class='disclaimer'>Results may vary. Flooberblubs are not a replacement for common sense, and cannot be held liable for the consequences of your butterfingers.</span>",
	flunnel: "Cut out the middleman! With a flunnel you can pour large amounts of things into small openings that are very far away! Simply pour your large amount of things into the adjustably-sized funnel-style opening, and they will be accelerated to obscene speeds as they exit! Make rice without getting off the couch, organize your collection of antique shards of glass, relocate entire ant colonies! You can do it all with flunnel!",
	hackencracks: "<span id='slogan'>Break stuff!</span> Hackencracks are a series of microscopic swordsmen suspended in a semi-solid gel that, when activated, go to work punching, kicking, and chopping away at whichever surface you've applied them to. Now a available in viking and ninja flavours!",
	quimney: "A quimney is an autonomous quad-copter drone with the predisposition to oppose disorganization. Simply release a quimney in your home and it will go to work grabbing things with its usb3.1-powered electro-magnetic grappling hands. It's like a roomba for your things! <span id='slogan'>Organize your home with a quimney!</span> <span class='disclaimer'>Warning, quimneys do not distinguish inanimate objects from animate ones, and will in fact see animate objects as vectors of disorganization and seek to set them still. Do not operate around small children or anyone with a less than perfectly symmetrical face.</span>"
}

// handler for incoming requests
function handleRequest(req, res) {
	//process the request
	console.log("Request for: "+req.url);
	var urlObj = url.parse(req.url,true);
	var query = urlObj.query;
	
	var filename = ROOT+url.parse(req.url).pathname;
	
	var code;
	var data = "";
	
	if(filename.endsWith("form.html") && query){  //handle the request from our form (in formDemo.html)
		data = getFileContents(filename);
		code = 200;
		var widget = query.widgetName;
		if(typeof widgetsData[widget] == "undefined"){
			filename = ROOT + "\\404.html";
			data = getFileContents(filename);
			code = 404;
		}
		data = data.slice(0,data.indexOf("id='name'>")+10)+widgetsData[widget]+"!"+data.slice(data.indexOf("id='name'>")+10,data.length);
		
	}else if(fs.existsSync(filename)){
		data = getFileContents(filename);
		code = 200;
	}else{
		filename = ROOT + "\\404.html";
		data = getFileContents(filename);
		code = 404;
	}

	
	// content header
	res.writeHead(code, {'content-type': mime.lookup(filename)||'text/html'});
	// write message and signal communication is complete
	res.end(data);
};

//read a file and returns its contents
function getFileContents(filename){
	
	var contents;
	
	//handle good requests
	var stats=fs.statSync(filename)
	if(stats.isDirectory()){
		console.log("Getting index");
		contents = fs.readFileSync(ROOT +"/index.html");
		console.log("typeof: "+typeof(contents));
	}else{
		console.log("Getting file");
		contents = fs.readFileSync(filename);
		console.log("typeof: "+typeof(contents));
	}
	return contents;
}