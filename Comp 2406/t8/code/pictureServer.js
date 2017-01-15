/*
Example of a sending and receiving cookies within an Express app.
 
PREREQUISITES:
install modules listed in package.json with command:
npm install

Use browser to view pages at http://localhost:2406/image

Note: no html page is needed for this application.

Exercise: use cookies to keep track of which image particular clients are
viewing so different clients can view the slide show independently.
*/

var express = require('express'); //express framework
var app = express();
var cookieParser = require('cookie-parser');
var fs = require('fs');


var imageFiles = [
   'lion3.jpg',
   'misty.jpg',
   'moose.jpg',
   'wildebeast1.jpg',
   'wildebeast2.jpg'
 ];
 
 var imageNumber = 0;  //VAR TO USE FOR NOW (will replace with cookies)

 //catch all requests and log them
app.use('*', function(req, res, next){
   console.log(req.url+' request for '+req.url);
   next(); //allow next route or middleware to run
});

//TO DO:  parse incoming cookies here
app.use(cookieParser());


//serve a single image (the next in the list)
app.get('/image', function(req,res){
  
  //TO DO
  /*
  1)Get cookies from request object.
  2)If no cookie exists set one in the response object with imageNumber=0;
         ...can be a session cookie (ie default expires value)
		 ...only needed for this /image path (ie default path value)
  3)If an imageNumber cookie exists extract the imageNumber value as an integer, increment it, 
        (mod numbers of images), and set the cookie with the new value in the response object.
  4)Serve the image at location imageNumber from the imageFiles array. (Should wrap around
    to the beginning after the last one.)  
  */ 
  var imageNumber;
	if(req.cookies.img===undefined){
		imageNumber = 0;
		res.cookie("img", imageNumber, {path:'/', maxAge:60000000});
	}else{
		imageNumber = (parseInt(req.cookies.img)+1) % imageFiles.length;  
		res.cookie("img", imageNumber, {path:'/', maxAge:60000000});
	}
   
   
   //serve the current image
  console.log('serving image number: ' + imageNumber);
  res.sendFile(imageFiles[imageNumber], {root:'./images'});  
});

 app.all("*",function(req,res){
	 res.sendStatus(404);
 });

app.listen(2406,function(){
	console.log('Server listening on port 2406');
});