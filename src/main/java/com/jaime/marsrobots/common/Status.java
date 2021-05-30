package com.jaime.marsrobots.common;

public enum Status {
	LOST("LOST");
	
	private final String status;
	
	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	
}
