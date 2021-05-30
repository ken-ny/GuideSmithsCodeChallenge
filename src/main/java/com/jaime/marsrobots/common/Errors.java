package com.jaime.marsrobots.common;

public enum Errors {
	EMPTY_INPUT("Err0r: 0ne or more of the params are empty. Exiting..."),
	MISSING_PARAM("Err0r: 0ne of the params is missing. Exiting...."),
	ERROR_COORDINATES("Err0r procesing coordinates. Exiting..."),
	TOO_MANY_INSTRUCTIONS("Err0r: T00 many instructions. Overload. Exiting....");
	private final String error;
	
	private Errors(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}
	
	public void print() {
		System.out.print(this.error);
	}
	
}
