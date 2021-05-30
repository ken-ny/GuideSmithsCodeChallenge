package com.jaime.marsrobots.POJO;

import java.util.List;

public class Input {
	private List<Robot> robotList;
	private Mars planet;
	public List<Robot> getRobotList() {
		return robotList;
	}
	public void setRobotList(List<Robot> robotList) {
		this.robotList = robotList;
	}
	public Mars getPlanet() {
		return planet;
	}
	public void setPlanet(Mars planet) {
		this.planet = planet;
	}
	public Input(List<Robot> robotList, Mars planet) {
		super();
		this.robotList = robotList;
		this.planet = planet;
	}
	
	
	
}
