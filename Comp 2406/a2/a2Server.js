//Jacob Larose, 101013798

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


// handler for incoming requests
function handleRequest(req, res) {
	//process the request
	console.log("Request for: "+req.url);
	var urlObj = url.parse(req.url,true);
	var query = urlObj.query;
	
	var filename = ROOT+url.parse(req.url).pathname;
	
	var code;
	var data = "";
	var dataType;
	//route if request for recipes
	if(urlObj.pathname.substring(0,8)=="/recipes"){
		//if requesting the recipe directory, populate dropdown list
		if(fs.statSync(filename).isDirectory()){
			console.log("popList");
			fs.readdir("./public_html/recipes/", function(err, array){
					data = JSON.stringify(array);
					dataType = 'application/json';
					respond(200, data, dataType);
				}
			);
		}else{
			//get recipe
			if(req.method === "GET"){
				fs.readFile("./public_html"+urlObj.pathname, 'utf8', function (err, data) {
						if (err){
							console.log(err);
						}else{
							var jsonParsed = JSON.parse(data);
							var data = JSON.stringify(jsonParsed);
							dataType = 'application/json';
							respond(200, data, dataType);
						}
					}
				);
			//save recipe
			}else if (req.method==="POST"){
				console.log("recipe submited");
				var postBody="";
				req.on('data',function(chunk){
						postBody+=chunk;
					}
				);
				req.on('end',function(){
						console.log("post body: "+postBody);
						try{
							var recipeNew = JSON.parse(postBody);
						}catch(err){
							console.log("JSON parse error");
							res.writeHead(400);
							res.end();
							return;
						}							
						var recipeNewString = JSON.stringify(recipeNew);
						
						fs.writeFile("./public_html"+urlObj.pathname, recipeNewString, function(err) {
								if(err) {
								  console.log(err);
								} else {
								  console.log("JSON saved to " + "./public_html"+urlObj.pathname);
								  res.writeHead(201);
								  res.end();
								}
							}
						); 
					}
				);
			}
		}
	//static route
	}else if(fs.existsSync(filename)){
		console.log("File Exists");
		if(fs.statSync(filename).isDirectory()){
			console.log("getting directory");
			if(urlObj.pathname == "/recipes"){
				
			}else{
				filename = ROOT +"/index.html";
				console.log("index request");
				data = getFileContents(filename);
				code = 200;
				respond(code, data, dataType);
			}

		}else{
			console.log("getting page");
			respond(200, getFileContents(filename), dataType);
		}
	}else{
		console.log("File Not Exists");
		filename = ROOT + "\\404.html";
		data = getFileContents(filename);
		code = 404;
		respond(code, data, dataType);

	}
	
	//build and send response 
	function respond(code, data, dataType){
		// content header
		if (typeof dataType!='undefined'){
			res.writeHead(code, {'content-type': dataType});
		}else{
			res.writeHead(code, {'content-type': mime.lookup(filename)|| 'text/html'});
		}
		// write message and signal communication is complete
		res.end(data);
	}	
};

//read a file and returns its contents
function getFileContents(filename){
	
	var contents;
	
	//handle good requests
	console.log("Getting file");
	contents = fs.readFileSync(filename);
	console.log("typeof: "+typeof(contents));

	return contents;
}
