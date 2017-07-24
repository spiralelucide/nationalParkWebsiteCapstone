package com.techelevator.npgeek.controllers;

public class MessageGenerator {
	
	private String message;
	public MessageGenerator(String forecast, int low, int high){
		switch(forecast){
		case "snow": message = "Pack snow shoes. ";
			break;
		case "rain": message = "Pack rain gear, wear waterproof shoes. ";
			break;
		case "thunderstorms" : message = "Seek shelter & avoid hiking on exposed ridges. ";
			break;
		case "sunny" : message = "Bring extra sunblock. ";
			break;
		default : message = "";
		}
		if(low < 20){
			message = message + "Exposure to low temperatures is hazardous.";
		}else if(high > 75){
			message = message + "Bring an extra gallon of water.";
		}
		if(high > low + 20){
			message = message + "Wear breathable layers.";
		}
	}
	public String getMessage(){
		return message;
	}
}
