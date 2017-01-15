//global variables
var username;
var guessCount = 0;
/**
* builds the initial login screen
* runs on window load
*/
function buildLogin(){
	$("#gameSpace").append('<div id="login"> <label for="userName"><br> Username: </label> <input type = "text" id="userName"><button id="submit">Submit</button></div>');
}
$(document).ready(buildLogin);

/**
* event listener to log in
*/
$("#gameSpace").on("click", "#submit", function(){
	console.log($("#userName").val());
	username = $("#userName").val();
	$.ajax({
		method:"GET",
		url: "/memory/intro",
		data: {'username' : $("#userName").val()},
		success: buildGame,
		dataType:'json'
	});
});
/**
* builds the game
*/
function buildGame(data){
	$("#gameSpace").empty();
	//builds table as an html string
	var table = '<table>';
	for(var i=0; i<parseInt(data.size); i++){
		table += "<tr>";
		for(var x=0; x<parseInt(data.size); x++){
			table += '<td><div class="cardBack" data-row="'+i+'" data-col="'+x+'"></div>';
		}
		table += "</tr>";
	}
	table+="</table>";
	$("#gameSpace").append(table);
	//$.off() wasnt working so on first level, add event listener that remains for the whole session
	if(data.type == 0){
		$("#gameSpace").on("click", ".cardBack", cardClicked);
	}
}
/**
* runs when a card is selected to be flipped
*/
function cardClicked(){
	console.log("cardClicked");
	//catch error cases where card is clicked twice in a row (redundant) 
	if($(this).hasClass("right")){
		return;
	}
	//animate half of card flip
	$(this).css({'word-spacing':0}).animate({'word-spacing':90}, 
		{step: function(now){
				$(this).css('webkitTransform', 'rotateY('+now+'deg)');
			},
			duration: 500
		});
	//wait for animation to finishe then send ajax for card data, calls flipCard on success
	var curr = this;
	setTimeout(function(){
			$(curr).removeClass("cardBack").addClass("cardFront");
			console.log("before ajax");
			$.ajax({
				method:"GET",
				url: "/memory/card",
				data: {'username' : username, 'choiceCol': $(curr).data('col'), 'choiceRow': $(curr).data('row')},
				success: flipCard,
				dataType:'json'
			});
		},
	500);
	

	/**
	* flips card and tracks whether or not to check for a match
	*/
	function flipCard(data){
		//selects proper card
		$(".cardFront").each(function(){
				if($(this).data('col')==data.col && $(this).data('row')==data.row){
					//adds check class to track, adds data, then finishes flip animations
					$(this).addClass("check");
					$(this).append("<p><span>"+data.number+"</span></p>");
					$(this).css({'word-spacing':90}).animate({'word-spacing':0}, 
						{step: function(now){
								$(this).css('webkitTransform', 'rotateY('+now+'deg)');
							},
							duration: 500
						});
				}
			}
		);
		//if 2 cards have class check, then compare them for a match
		var count=0;
		$(".check").each(function(){
				count++;
			}
		);
		if (count>=2){
			checkCards();
		}
	}
}
/**
* compares cards, flips them back if wrong
*/
function checkCards(){
	var selectedCards =[];
	console.log("checkCards");
	$(".check").each(function(){
			selectedCards.push($(this).text());
		}
	);
	//if cards match
	if(selectedCards[0]==selectedCards[1]){
		console.log("right");
		guessCount++;
		$(".check").each(function(){
				$(this).addClass("right").removeClass("check");
			}
		);
		//if all cards are flipped forward, then player has won
		var winCount = 0;
		$(".cardBack").each(function(){
				winCount++;
			}
		);
		if(winCount==0){
			//allow animations to finish alerts player with guess count, request next level
			setTimeout(function(){
					alert("You completed the level in "+guessCount+" guesses! Press ok to go the next level");
					$.ajax({
						method:"GET",
						url: "/memory/intro",
						data: {'username' : username},
						success: buildGame,
						dataType:'json'
					});
				}, 1000);
		}
	}else{
		console.log("wrong");
		guessCount++;
		//allow player to view cards, then flip them back
		setTimeout(function(){
				$(".check").each(function(){
						$(this).css({'word-spacing':0}).animate({'word-spacing':90}, 
							{step: function(now){
									$(this).css('webkitTransform', 'rotateY('+now+'deg)');
								},
								duration: 500
							});
						var curr = this;
						setTimeout(function(){
								$(curr).empty().removeClass("cardFront").addClass("cardBack").removeClass("check");
							},
						500);
						$(this).css({'word-spacing':90}).animate({'word-spacing':0}, 
							{step: function(now){
									$(this).css('webkitTransform', 'rotateY('+now+'deg)');
								},
								duration: 500
							});
					}
				)
			}, 
		1000);
	}
}
