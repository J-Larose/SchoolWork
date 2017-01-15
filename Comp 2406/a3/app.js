//Jacob Larose, 101013798

//simple server listens on the provided port and responds with requested pages

// load modules
var http = require('http');
var fs = require('fs');
var mime = require('mime-types');
var makeBoard = require('makeBoard.js');
const ROOT = "./public_html";
var url = require('url');

// create http server
var server = http.createServer(handleRequest);
server.listen(2406);
console.log('Server listening on port 2406');

var users=[];
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
	//route for new players and level up
	if(urlObj.pathname == "/memory/intro"){
		var lvlUp = false;
		var clientNum = -1;
		var userName = query.username;
		//if username already exists, assume level up
		for(var i=0; i<users.length; i++){
			if(userName == users[i].username){
				lvlUp = true;
				console.log("lvl up   "+i);
				clientNum = i;
				break;
			}
		}
		//if user does not exist create new and push to list else increase level and send bigger board
		if(lvlUp == false){
			console.log("new user entered");
			var client = {"username":userName, "board": [], "level":1};
			var board = makeBoard.makeBoard(client.level*2);
			client.board = board;
			users.push(client);
			var returnData = {'size':(board.length).toString(), 'type':0};		
		}else{
			users[clientNum].level++;
			users[clientNum].board = makeBoard.makeBoard(users[clientNum].level*2);
			var returnData = {'size':(users[clientNum].board.length).toString(), 'type':1};
		}
		respond(200, JSON.stringify(returnData), dataType);
		
	//route for card requests	
	}else if(urlObj.pathname == "/memory/card"){
		console.log("card clicked");
		var x;
		for(var i=0;i<users.length;i++){
			if(users[i].username == urlObj.query.username){
				var user = users[i];
				x=i;
			}
		}
		var number = user.board[urlObj.query.choiceRow][urlObj.query.choiceCol];
		respond(200, JSON.stringify({'number': number, 'col':urlObj.query.choiceCol, 'row': urlObj.query.choiceRow}), dataType);
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
