package com.jaime.marsrobots.POJO;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.jaime.marsrobots.common.Cardinals;
import com.jaime.marsrobots.common.Status;

public class Robot{

	private Coordinates coord;
	private int orientation;
	private String status;
	private String instructions;
	
	public Robot(int x, int y, String orientation) {
		this.coord = new Coordinates(x, y);
		this.orientation = findOrientationValue(orientation);
	}
	
	public Robot(int x, int y, String orientation, String instructions) {
		this.coord = new Coordinates(x, y);
		this.orientation = findOrientationValue(orientation);
		this.instructions = instructions;
	}

	
	public Coordinates getCoord() {
		return coord;
	}
	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public int getOrientation() {
		return orientation;
	}
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	
	public void turnLeft() {
		--this.orientation;
		if(-1 == this.orientation) {
			this.orientation = 3;
		}
	}
	
	public void turnRight() {
		++this.orientation;
		if(4 == this.orientation) {
			this.orientation = 0;
		}
	}
	
	public void moveForward(List<Coordinates> dangerZone) {
		if(checkPath(dangerZone)) {
			switch (this.orientation) {
			case 0 : this.coord.up();
						break;
			case 1 : this.coord.right();
						break;
			case 2 : this.coord.down();
						break;
			case 3 : this.coord.left();
						break;
			}
		}

	}
	
	public Boolean checkPath(List<Coordinates> dangerZone) {
		Optional<Coordinates> path = Optional.empty();
		if(null != dangerZone) {
			switch (this.orientation) {
				case 0 : path = dangerZone.stream()
							.filter(d -> d.getY() == this.coord.getY()+1 && d.getX() == this.coord.getX())
							.findFirst();
						break;
				
				case 1 : path = dangerZone.stream()
							.filter(d -> d.getX() == this.coord.getX()+1 && d.getY() == this.coord.getY())
							.findFirst();
						break;
				case 2 : path = dangerZone.stream()
							.filter(d -> d.getY() == this.coord.getY()-1 && d.getX() == this.coord.getX())
							.findFirst();
						break;
				case 3 : path = dangerZone.stream()
							.filter(d -> d.getX() == this.coord.getX()-1 && d.getY() == this.coord.getY())
							.findFirst();
						break;
				}
		}
		
		return path.isEmpty();
		
		
	}
	
	public void kill() {
		this.status = Status.LOST.getStatus();
	}

	@Override
	public String toString() {
		return this.coord.toString()+" "+findOrientationLetter()+" "+(null == this.status ? "" : this.status);
	}
	
	public String findOrientationLetter() {
		return Arrays.stream(Cardinals.values())
		.filter(o -> o.getCardinalValue() == this.orientation)
		.findFirst()
		.orElseThrow(() -> {throw new IllegalStateException(String.format("Unsupported type %s.", this.orientation));})
		.getCardinalLetter();
	}
	
	private int findOrientationValue(String orientation) {
		return Arrays.stream(Cardinals.values())
				.filter(o -> o.getCardinalLetter().equalsIgnoreCase(orientation))
				.findFirst()
				.orElseThrow(() -> {throw new IllegalStateException(String.format("Unsupported type %s.", orientation));})
				.getCardinalValue();
	}
	
	
}
