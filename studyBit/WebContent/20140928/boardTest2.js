"use strict";

changeState("create");

var boardList = [];
$("#btnAdd").onclick = function(event){
	var board = new Board( $("#title").value,
			$("#content").value,
			$("#writer").value,
			$("#password").value);
	
	boardList.push(board);
	
	resetBoard();
	refreshBoard();
	
}

function refreshBoard(){
	var boardTable = $("#boardTable");
	var tbody = boardTable.firstElementChild;
	
	//console.log(boardTable);
	//console.log(tboay);
	
	for(var i=boardList.length-1; i>0; i--){
		tbody.removeChild(tbody.children[i]);
	}
	
	for(var i=0; i<boardList.length; i++){
		var tr = $("<tr>")
		.append($("<td>").html(i))
		.append($("<td>")
				.append($("<a>")
				.html(boardList[i].title)
				.attr("bno",i)
				.attr("href", "#")
				.click(boardListDetail)))
		.appendTo(tbody);
	}
}
function resetBoard(){
	$("#btnCancel").click();
}

function boardListDetail(){
	changeState("detail");
	
	var board = boardList[this.getAttribute("bno")];
	
	$("#no").val(this.getAttribute("bno"));
}

function Board(title, content, writer, password){
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.password = password;
	this.date = new Date();
	this.count = 0;
	
}

function changeState(state){
	var stateMap = {
		create: "none",
		detail: "none"
	};
	
	stateMap[state] ="";
	
	var createClass = document.querySelectorAll(".create");
	var detailClass = document.querySelectorAll(".detail");
	
	for(var i=0; i<createClass.length; i++){
		$(createClass[i]).css("display", stateMap.create);
	}
	
	for(var i=0; i<detailClass.length; i++){
		$(detailClass[i]).css("display", stateMap.detail);
	}
}