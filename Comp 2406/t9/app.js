var MongoClient = require('mongodb').MongoClient;

MongoClient.connect("mongodb://localhost:27017/dbSongs", function(err, db){
    if(err) console.log('FAILED TO CONNECT TO DATABASE');
    else{
        console.log('CONNECTED TO DATABASE');
        var collection = db.collection("Songs");
        collection.insertOne({title: "Happy Birthday", composer: "Anonymous"}, function(err, result){
            var cursor = collection.find();
            cursor.each(function(err,document){
                console.log(document);
				if(document == null) db.close();
            });	 
        });  
    }
});
