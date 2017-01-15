/*SocketIO based chat room. Extended to not echo messages
to the client that sent them.*/

var http = require('http').createServer(handler);
var io = require('socket.io')(http);
var fs = require('fs');

http.listen(2406);

console.log("Chat server listening on port 2406");


function handler(req,res){
	fs.readFile("./files/chatRoom_final.html", function(err,data){
		if(err){
			res.writeHead(500);
			return res.end("Error loading chatRoom.html");
		}else{
			res.writeHead(200);
			res.end(data);
		}
	});
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
	console.log("Got a connection");
	socket.on("intro",function(data){
		socket.username=data
		socket.broadcast.emit("message", timestamp()+": "+socket.username+" has entered the chatroom.");
		socket.emit("message","Welcome, "+socket.username+".");
		clients.push(socket);
		io.emit("userList", getUserList());
	});

	socket.on("message", function(data){
		console.log("got message: "+data);
		socket.broadcast.emit("message",timestamp()+", "+socket.username+": "+data);
		
	});

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