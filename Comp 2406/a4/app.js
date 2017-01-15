/*SocketIO based chat room. Extended to not echo messages
to the client that sent them.*/

var http = require('http').createServer(handler);
var io = require('socket.io')(http);
var fs = require('fs');
var mime = require('mime-types');
const ROOT = "./public_html";
var url = require('url');

http.listen(2406);

console.log("Chat server listening on port 2406");


function handler(req,res){
	//process the request
	console.log("Request for: "+req.url);
	var urlObj = url.parse(req.url,true);
	var query = urlObj.query;
	
	var filename = ROOT+url.parse(req.url).pathname;
	
	var code;
	var data = "";
	var dataType;
	if(fs.existsSync(filename)){
		console.log("File Exists");
		if(fs.statSync(filename).isDirectory()){
			console.log("getting directory");
			filename = ROOT +"/index.html";
			console.log("index request");
			data = getFileContents(filename);
			code = 200;
			respond(code, data, dataType);
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
	function getFileContents(filename){
		var contents;
		//handle good requests
		console.log("Getting file");
		contents = fs.readFileSync(filename);
		console.log("typeof: "+typeof(contents));

		return contents;
	}
};
var clients = [];
function getUserList(){
	var ret = [];
	for(var i=0;i<clients.length;i++){
		ret.push(clients[i].username);
	}
	return ret;
}
io.on("connection", function(socket){
	console.log("Got a connection: "+socket.id);
	socket.on("intro",function(data){
		socket.username=data;
		socket.blocked = [];
		socket.broadcast.emit("message", timestamp()+": "+socket.username+" has entered the chatroom.");
		socket.emit("message","Welcome, "+socket.username+".");
		clients.push(socket);
		io.emit("userList", getUserList());
	});

	socket.on("message", function(data){
		console.log("got message: "+data);
		//socket.broadcast.emit("message",timestamp()+", "+socket.username+": "+data);
		for (var i=0;i<clients.length;i++){
			if(clients[i].blocked.indexOf(socket.username)<=(-1) && clients[i].id!=socket.id){
				io.to(clients[i].id).emit("message",timestamp()+", "+socket.username+": "+data);
			}
		}

	});
	
	socket.on("privateMessage", function(data){
		console.log("got private message for: "+data.username+"from:"+socket.username);
		for(var i=0;i<clients.length;i++){
			if(clients[i].username === data.username){
				console.log("user found")
				if(clients[i].blocked.indexOf(socket.username)>(-1)){
					console.log("blocked");
					break;
				}
				io.to(clients[i].id).emit("privateMessage", {'username':socket.username,'message':data.message});
				break;
			}
		}
		
	});
	
	socket.on("blockUser",function(data){
			if(socket.blocked.indexOf(data.username)<=(-1)){
				console.log("user: "+socket.username+"blocked: "+data.username);
				socket.blocked.push(data.username);
			}else{
				console.log("user: "+socket.username+" unblocked: "+data.username);
				socket.blocked.splice(socket.blocked.indexOf(data.username), 1);
			}
		}
	);

	socket.on("disconnect", function(){
		console.log(socket.username+" disconnected");
		io.emit("message", timestamp()+": "+socket.username+" disconnected.");
		
		clients = clients.filter(function(ele){  
			   return ele!==socket;
		});
		io.emit("userList", getUserList());
	});
	
});

function timestamp(){
	return new Date().toLocaleTimeString();
}