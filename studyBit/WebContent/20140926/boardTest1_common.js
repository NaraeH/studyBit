"use strict";

function bit(value){
	var element = null;
	if(value instanceof Element){
		element = value;
	}else if(value.charAt(0) == "#"){
		element = document.getElementById(value.substring(1));
	}else if(value.charAt(0) == "<"){
		element = document.createElement(value.replace(/<|>/g, ""));
	}
	
	element.html = function(value){
		this.innerHTML = value;
		return this;
	}
	
	element.append = function(value){
		element.appendChild(value);
		return this;
	}
	element.appendTo = function(value){
		value.appendChild(element);
		return this;
	}
	
	element.attr = function(key,value){
		element.setAttribute(key, value);
		return this;
	}
	element.click = function(listener){
		if(listener){
			element.onclick = listener;
		}else{
			var event = new MouseEvent('click', {});
			element.dispatchEvent(event);
		}
		return this;
	}
	element.val = function(value){
		element.value = value;
		return this;
	}
	
	element.css = function(name, value){
		element.style[name] = value;
		return this;
	}
	return element;
}

var $ = bit;

function toYYYYMMDD(date) {
	return (date.getFullYear() + "-" + date.getMonth() + "-" + date.getDate());
}