package com.jaime.marsrobots.common;

public enum Cardinals {
	NORTH("N", 0),
	EAST("E", 1),
	SOUTH("S", 2), 
	WEST("W", 3);
	
	private final String cardinalLetter;
	private final int cardinalValue;
	
	private Cardinals(String cardinalLetter, int cardinalValue) {
		this.cardinalLetter = cardinalLetter;
		this.cardinalValue = cardinalValue;
	}
	public String getCardinalLetter() {
		return cardinalLetter;
	}
	public int getCardinalValue() {
		return cardinalValue;
	}
	
	
	
}
