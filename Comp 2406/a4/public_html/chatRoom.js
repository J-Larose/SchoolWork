$(document).ready(function(){

	var userName = prompt("What's your name?")||"User";
	
	var socket = io(); //connect to the server that sent this page
	socket.on('connect', function(){
		socket.emit("intro", userName);
	});
	
	$('#inputText').keypress(function(ev){
			if(ev.which===13){
				//send message
				socket.emit("message",$(this).val());
				ev.preventDefault(); //if any
				$("#chatLog").append((new Date()).toLocaleTimeString()+", "+userName+": "+$(this).val()+"\n")
				$(this).val(""); //empty the input
			}
	});
	
	socket.on("message",function(data){
		$("#chatLog").append(data+"\n");
		$('#chatLog')[0].scrollTop=$('#chatLog')[0].scrollHeight; //scroll to the bottom
	});
	socket.on("userList", function(data){
			console.log("test");
			$("#userList").empty();
			for(var i=0; i<data.length; i++){
				$("#userList").append("<li class='nameItem'>"+data[i]+"</li>");
			}
		}
	);
	$("#userList").on("dblclick", ".nameItem", dblClickUser);
	socket.on("privateMessage", function(data){
			var reply = window.prompt("Message from: "+data.username+"\n"+data.message);
			if(reply!=null){
				socket.emit("privateMessage", {'username':data.username, 'message':reply});
			}
		}
	);
	function dblClickUser(event){
		if(event.ctrlKey){
			//block the user
			console.log("block: "+$(this).text());
			socket.emit("blockUser", {'username':$(this).text()});
			alert("(un)blocked: "+$(this).text());
		}else{
			//send pm
			console.log("to: "+$(this).text());
			var message = window.prompt("What is your message");
			if(message!=null){
				socket.emit("privateMessage", {'username':$(this).text(), 'message':message});
			}
		}
	}

});
