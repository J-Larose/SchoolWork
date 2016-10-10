/**
Assignment 1
Jacob Larose
101013798
*/
/*Tree constructor*/
var Tree = function() {
    this.root = new Node();
};
/*add all the methods*/
Tree.prototype = {
	isEmpty: function(){
		if(typeof this.root.data == "undefined"){
			return true;
		}else{
			return false;
		}
	},
	isLeaf: function(){
		return this.root.isLeaf();
	},
	insert :function(value){
		/*check if input value is an array, recursively call insert function for each value if so.*/
		if (typeof value == "object"){
			console.log	("insert array");
			for(y = 0; y<value.length; y++){
				console.log(this.insert(value[y]));
			}
			return "all done";
		}
		var current = this.root;
		
		/*search through tree to find where to add given value*/
		while(1){
			if(typeof current.data == "undefined"){
				current.data = value;
				break;
			}else if(current.data == value){
				console.log("value is already in tree");
				break;
			}else if(value < current.data){
				if(typeof current.left == "undefined"){
					current.left = new Node();
					current.left.data = value;
					break;
				}
				else{
					current = current.left;
				}
			}else if(value > current.data){
				if(typeof current.right == "undefined"){
					current.right = new Node();
					current.right.data = value;
					break;
				}
				else{
					current = current.right;
				}
			}
		}
		return "added"+value+"to the tree";
	},
	remove: function(value){
		var current = this.root;
		/*search tree to find value, then set pointer to value to undefined*/
		while(1){
			if(typeof current.data == "undefined"){
				console.log("tree is empty")
				break;
			}else if (current.data == value){
				console.log("value is root");
				break;
			}else if(value < current.data){
				if(typeof current.left == "undefined"){
					console.log("value not in tree");
					break;
				}else if(current.left.data == value){
					current.left = undefined;
					break;
				}else{
					current = current.left;
				}
			}else if(value > current.data){
				if(typeof current.right == "undefined"){
					console.log("value not in tree--");
					break;
				}else if(current.right.data == value){
					current.right = undefined;
					break;
				}else{
					current = current.right;
				}
			}
		}
	},
	contains: function(value){
		var current = this.root;
		
		/*search tree to find value*/
		while(1){
			if(typeof current.data == "undefined"){
				console.log("tree is empty")
				break;
			}else if(current.data == value){
				return true;
			}else if(value < current.data){
				if(typeof current.left == "undefined"){
					return false;
				}
				else{
					current = current.left;
				}
			}else if(value > current.data){
				if(typeof current.right == "undefined"){
					return false;
				}
				else{
					current = current.right;
				}
			}
		}
	},
	findLargest: function(){
		var current = this.root;
		/* search down the right side of tree*/
		while(typeof current.right != "undefined"){
			current = current.right;
		}
		return current.data;
	},
	findSmallest: function(){
		var current = this.root;
		
		/* search down the left side of tree*/
		while(typeof current.left != "undefined"){
			current = current.left;
		}
		return current.data;
	},
	toString: function(){
		var current = this.root;
		if(typeof current.data == "undefined"){
			return "";
		}
		var data = "";
		/* call dfs(depth first search) helper function that returns data*/
		data = dfsDta(current, data);
		return data;
	},
	copy: function(){
		var t2 = new Tree();
		t2.root.data = this.root.data;
		/*call dfs(depth first search) helper function that does not return data*/
		dfsNoDta(this.root, t2.root);
		return t2;
	},
	treeMap: function(operation){
		if(operation == "add"){
			dfsAdd(this.root);
		}else if(operation == "subtract"){
			dfsSub(this.root);
		}else if(operation == "multiply"){
			dfsMul(this.root);
		}else if(operation == "divide"){
			dfsDiv(this.root);
		}else if(operation == "square"){
			dfsSqr(this.root);
		}else{
			return "that operation is not supported";
		}
	}
}
/*Node constructor*/
var Node = function() {
    this.data;
    this.left;
	this.right;
};
/*add isLeaf() method to node*/
Node.prototype = {
	isLeaf: function(){
		if(typeof this.left == "undefined" && typeof this.right == "undefined"){
			return true;
		}
		return false;
	}
}
/*recursively calls dfs starting with the left, then adds current data, then right reference: https://www.tutorialspoint.com/data_structures_algorithms/tree_traversal.htm*/
function dfsDta(current,fullData){
	if(typeof current == "undefined"){
		return fullData;
	}
	fullData = dfsDta(current.left, fullData);
	fullData = fullData + current.data.toString()+", "; 
	fullData = dfsDta(current.right, fullData);
	return fullData;
}

/* same as dfsDta but copies data instead of returning it*/
function dfsNoDta(n, n2){
	if(typeof n == "undefined"){
		return;
	}
	n2.data = n.data;
	
	if(typeof n.left !="undefined"){
		n2.left = new Node();
	}
	dfsNoDta(n.left, n2.left);
	
	if(typeof n.right !="undefined"){
		n2.right = new Node();
	}
	dfsNoDta(n.right, n2.right);
	return;
}
/*dfs functions to apply treeMap() operations*/
function dfsAdd(current){
	if(typeof current == "undefined"){
		return;
	}
	current.data +=1;
	dfsAdd(current.left);
	dfsAdd(current.right);
	return;
}
function dfsSub(current){
	if(typeof current == "undefined"){
		return;
	}
	current.data -=1;
	dfsSub(current.left);
	dfsSub(current.right);
	return;
}
function dfsMul(current){
	if(typeof current == "undefined"){
		return;
	}
	current.data *= 2;
	dfsMul(current.left);
	dfsMul(current.right);
	return;
}
function dfsDiv(current){
	if(typeof current == "undefined"){
		return;
	}
	current.data = current.data/2;
	dfsDiv(current.left);
	dfsDiv(current.right);
	return;
}
function dfsSqr(current){
	if(typeof current == "undefined"){
		return;
	}
	current.data = current.data * current.data;
	dfsSqr(current.left);
	dfsSqr(current.right);
	return;
}

function test(){
	console.log("this is the test function");
	//t is the tree
	var t = new Tree();
	console.log("empty tree t has been created \n t.isEmpty (should display true):");
		console.log(t.isEmpty());
	console.log("t.isLeaf (also true): ");
		console.log(t.isLeaf());
	console.log("next should be empty string:");
		console.log(t.toString());
	console.log("insert element 5 and display string:");
		t.insert(5);
		console.log(t.toString());
	console.log("check if still empty (not)");
		console.log(t.isEmpty());
	console.log("insert more elements 3,6,4,7,8,9 and print tree");
		t.insert([3,6,4,7,8,9]);
		console.log(t.toString());
	console.log("remove elements 1 and 8 and print (element 1 not in tree, should notify): ");
		t.remove(1);
		t.remove(8);
		console.log(t.toString());
	console.log("contains 1 then 3, (false then true):");
		console.log(t.contains(1));
		console.log(t.contains(3));
	console.log("find largest then smallest (7, 3): ");
		console.log(t.findLargest());
		console.log(t.findSmallest());
	console.log("copy t to t2, then print both:")
		var t2 = t.copy();
		console.log(t.toString());
		console.log(t2.toString());
	console.log("insert 2 to t2 then reprint both t and t2");
		t2.insert(2);
		console.log(t.toString());
		console.log(t2.toString());
	console.log("apply treeMap operations to t: ");
		console.log("add 1");
			t.treeMap("add");
			console.log(t.toString());
		console.log("subtract 1: ");
			t.treeMap("subtract");
			console.log(t.toString());
		console.log("multiply by 2: ");
			t.treeMap("multiply");
			console.log(t.toString());
		console.log("divide by 2: ");
			t.treeMap("divide");
			console.log(t.toString());
		console.log("square the numbers: ");
			t.treeMap("square");
			console.log(t.toString());
}
module.exports.Tree = Tree;
module.exports.tree = Tree;
module.exports.test = test;
