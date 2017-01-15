var express = require('express');
var app = express();
var fs = require('fs');
var bodyParser = require("body-parser");
var MongoClient = require("mongodb").MongoClient;
app.set('views', './views');
app.set('view engine','pug');

app.get(["/","/home","/index.html","/index"], function(req,res){
	res.render("index.pug");
});

app.get("/recipes",function(req,res){
	console.log("popList");
	var nameList=[];
	MongoClient.connect("mongodb://localhost:27017/recipeDB", function(err, db){
		if(err) console.log('FAILED TO CONNECT TO DATABASE');
		else{
			console.log('CONNECTED TO DATABASE');
			var collection = db.collection("recipes");
			var cursor = collection.find();
			cursor.each(function(err,document){
				if(document == null){
					db.close(); 
					res.send({'names':nameList});
				}else{
					console.log(document.name);
					nameList.push(document.name);
				}
			});  
		}
	});

});

app.get("/recipe/:name",function(req,res){
	console.log("request "+req.params.name);
	var nameList=[];
	var sent = false;
	MongoClient.connect("mongodb://localhost:27017/recipeDB", function(err, db){
		if(err) console.log('FAILED TO CONNECT TO DATABASE');
		else{
			console.log('CONNECTED TO DATABASE');
			var collection = db.collection("recipes");
			var cursor = collection.find({name:req.params.name});
			cursor.each(function(err,document){
				if(document == null){
					console.log("null recipe");
					db.close();
					if(!sent){
						res.sendStatus(404);
					}
				}else{
					console.log(document);
					db.close();
					if(!sent){
						res.send({'name': document.name, 'duration':document.duration, 'ingredients':document.ingredients, 'directions':document.directions, 'notes':document.notes});
					}
					sent = true;
				}
			});  
		}
	});

});

app.use('/recipe', bodyParser.urlencoded({ extended:true }));

app.post("/recipe", function(req,res){
	console.log("POST \n\n\n")
	var nameList=[];
	MongoClient.connect("mongodb://localhost:27017/recipeDB", function(err, db){
		if(err) console.log('FAILED TO CONNECT TO DATABASE');
		else{
			console.log('CONNECTED TO DATABASE');
			var collection = db.collection("recipes");
			if(!req.body.name){
				console.log("no name");
				db.close();
				res.sendStatus(400);
			}else{
				console.log("post "+ req.body.name)
				collection.update({name:req.body.name}, req.body, {upsert: true},
					function(err, result){
						if(err){console.log(err); db.close(); res.sendStatus(500);}
						else{db.close(); res.sendStatus(200);}
					}
				);
				
			}
		}
	});
});

app.use(express.static('./public'));

app.listen(2406,function(){
	console.log("Server is listening on port 2406");
});