package com.jaime.marsrobots.POJO;

public class Coordinates {
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return x + " "+ y;
	}
	
	public void up() {
		++this.y;
	}
	
	public void down() {
		--this.y;
	}
	
	public void left() {
		--this.x;
	}
	
	public void right() {
		++this.x;
	}
	
}
