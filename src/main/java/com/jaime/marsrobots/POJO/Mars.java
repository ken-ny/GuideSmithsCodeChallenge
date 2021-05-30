package com.jaime.marsrobots.POJO;

import java.util.ArrayList;
import java.util.List;

public class Mars {

	private Coordinates coord;
	private List<Coordinates> dangerZone;
	
	public Mars(int x, int y) {
		this.coord = new Coordinates(x, y);
		this.dangerZone = new ArrayList<Coordinates>();
	}
	public Coordinates getCoord() {
		return coord;
	}
	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}
	public List<Coordinates> getDangerZone() {
		return dangerZone;
	}
	
	public void addDangerZone(Coordinates danger) {
		this.dangerZone.add(danger);
	}
	public Mars() {
		super();
	}
	
	public Boolean checkBoundaries(Robot robot) {
		
		return !(robot.getCoord().getX()>=this.coord.getX() || robot.getCoord().getX()<=0 || robot.getCoord().getY()>=this.coord.getY() || robot.getCoord().getY()<=0);
		
	}
	
	
	
}
