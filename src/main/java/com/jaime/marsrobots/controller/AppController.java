package com.jaime.marsrobots.controller;

import com.jaime.marsrobots.POJO.Input;
import com.jaime.marsrobots.POJO.Mars;
import com.jaime.marsrobots.POJO.Robot;

public class AppController implements Commands{
	private Mars planet;
	
	@Override
	public void execute(Input in, OutputImpl out) {
		
		{planet = in.getPlanet();}

		in.getRobotList().forEach((r) -> {
				executeInstructions(r);
				out.print(r.toString());
			});
		out.save(in);
		
	}

	private void executeInstructions(Robot robot) {
		
		String[] instructions = robot.getInstructions().split("");
		
		for(String i : instructions) {
			switch(i) {
			case "L" : robot.turnLeft();
						break;
			case "R" : robot.turnRight();
						break;
			case "F" : robot.moveForward(planet.getDangerZone());
						break;
			}
			
			if(!this.planet.checkBoundaries(robot)) {
				robot.kill();
				this.planet.addDangerZone(robot.getCoord());
				break;
			}
		}
	}
	
}
