"use strict";

changeState("create");

var boardList = [];
$("#btnAdd").onclick = function(event){
	var board = new Board($("#title").value,
			$("#content").value,
			$("#writer").value,
			$("#password").value);
	
	boardList.push(board);
	resetBaord();
	refreshBaordList();
}

$("#btnCancel").onclick = function(evnet){
	changeState("create");
}

function refreshBaordList(){
	var boardTable = $("#boardTable");
	var tbody = boardTable.lastChild;
	
	for(var i=boardList.length-1; i>0; i-- ){
		tobody.removeChild(tbody.children[i]);
	}
	
	for(var i=0; i<boardList.length; i++){
		$("<tr>")
		.append($("<td>").html(i))
		.append($("<td>").append($("<a>")
				.html(boardList[i].title)
				.attr("bno", i)
				.attr("href", "#")
				.click(boardDetailList)))
		.append($("<td>").html(boardList[i].writer))
		.append($("<td>").html(toYYYYMMDD(boardList[i].date)))
		.append($("<td>").html(boardList[i].count))
		.appendTo(tbody);
	}
}


function boardDetailList(){
	changeState("detail");
	var board = boardList[this.getAttribute("bno")];
	
	$("#number").val(this.getAttribute("bno"));
	$("#title").val(board.title);
	$("#content").val(board.content);
	$("#writer").val(board.writer);
	$("#date").val(toYYYYMMDD(board.date));
	
}
function resetBaord(){
	$("#btnCancel").click();
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
			create : "none",
			detail : "none"
	}
	
	stateMap[state] = "";
	
	var detailClass = document.querySelectorAll(".detail");
	var createClass = document.querySelectorAll(".create");
	
	for(var i=0; i<detailClass.length; i++){
		$(detailClass[i]).css("display", stateMap.detail);
	}
	
	for(var i=0; i<createClass.length; i++){
		$(createClass[i]).css("display", stateMap.create);
	}
}