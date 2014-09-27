"use strict";

changeState("create");

var boardList = [];
$("#btnAdd").onclick = function(event) {
	var board = new Board($("#title").value, $("#content").value,
			$("#writer").value, $("#password").value);

	boardList.push(board);
	resetForm();
	reloadBoardlist();
}

$("#btnCancel").onclick = function(event) {
	changeState("create");
}

function changeState(state) {
	var stateMap = {
		create : "none",
		detail : "none"
	};

	stateMap[state] = "";

	var createClass = document.body.querySelectorAll(".create");
	var detailClass = document.body.querySelectorAll(".detail");

	for (var i = 0; i < createClass.length; i++) {
		$(createClass[i]).css("display",stateMap.create);
	}

	for (var i = 0; i < detailClass.length; i++) {
		$(detailClass[i]).css("display", stateMap.detail);
	}
}

function Board(title, content, writer, password) {
	this.title = title;
	this.content = content;
	this.writer = writer;
	this.password = password;
	this.date = new Date();
	this.count = 0;
}

function resetForm() {
	$('#btnCancel').onclick();
}

function reloadBoardlist() {

	var boardTable = $("#boardTable");
	var tbody = boardTable.firstElementChild;

	for (var i = tbody.children.length - 1; i > 0; i--) {
		tbody.removeChild(tbody.children[i]);
	}

	for (var i = 0; i < boardList.length; i++) {
		$("<tr>")
		.append($("<td>").html(i))
		.append($("<td>").append( $("<a>")
				.html(boardList[i].title)
				.attr("bno", i)
				.attr("href","#")
				.click(loadBoardDetail)))
		.append($("<td>")
				.html(boardList[i].writer))
		.append($("<td>")
				.html(toYYYYMMDD(boardList[i].date)))
		.append($("<td>")
				.html(boardList[i].count))
		.appendTo(tbody);
	}
}

function loadBoardDetail(event) {
	event.preventDefault();

	changeState("detail");

	var board = boardList[this.getAttribute("bno")];
	$("#number").val(this.getAttribute("bno"));
	$("#title").val(board.title);
	$("#content").val(board.content);
	$("#writer").val(board.writer);
	$("#date").val(toYYYYMMDD(board.date));
}

