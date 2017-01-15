//An asynchronous server that serves static files

// load necessary modules
var http = require('http');
var fs = require('fs');
var mime = require('mime-types');
var url = require('url');
var hex = require('hexcodes.js')
const ROOT = "./public_html";

// create http server
var server = http.createServer(handleRequest); 
server.listen(2406);
console.log('Server listening on port 2406');

var users = [];

function handleRequest(req, res) {
	
	//process the request
	console.log(req.method+" request for: "+req.url);
	
	//parse the url
	var urlObj = url.parse(req.url,true);
	var filename = ROOT+urlObj.pathname;

	console.log(urlObj.pathname);
	//the callback sequence for static serving...
	if(urlObj.pathname == "/colors/user"){
		console.log("test");
		var client = {colors:hex.makeColorList(1)};
		client.question= randEle(client.colors);
		client.level=1;
		client.username = urlObj.query.username;
		users.push(client);
		respond(200, JSON.stringify(client));
		return;
	}
	if(urlObj.pathname == "/colors/choice"){
		var x;
		for(var i=0;i<users.length;i++){
			if(users[i].username == urlObj.query.username){
				var client = users[i];
				x=i;
			}
		}
		console.log(client.colors[x]);
		console.log(client.question);
		if(client.colors[x] === client.question){
			users[x].level++;
		}
		users[x].colors = hex.makeColorList(users[x].level);
		users[x].question = randEle(client.colors);
		
		respond(200, JSON.stringify(users[x]));
		return;
	}
	fs.stat(filename,function(err, stats){
		if(err){   //try and open the file and handle the error, handle the error
			respondErr(err);
		}else{
			if(stats.isDirectory())	filename+="/index.html";
		
			fs.readFile(filename,"utf8",function(err, data){
				if(err)respondErr(err);
				else respond(200,data);
			});
		}
	});			
	
	//locally defined helper function
	//serves 404 files 
	function serve404(){
		fs.readFile(ROOT+"/404.html","utf8",function(err,data){ //async
			if(err)respond(500,err.message);
			else respond(404,data);
		});
	}
		
	//locally defined helper function
	//responds in error, and outputs to the console
	function respondErr(err){
		console.log("Handling error: ",err);
		if(err.code==="ENOENT"){
			serve404();
		}else{
			respond(500,err.message);
		}
	}
		
	//locally defined helper function
	//sends off the response message
	function respond(code, data){
		// content header
		res.writeHead(code, {'content-type': mime.lookup(filename)|| 'text/html'});
		// write message and signal communication is complete
		res.end(data);
	}	
	
};//end handle request



function randEle(list){
	return list[Math.floor(Math.random()*list.length)];
}




