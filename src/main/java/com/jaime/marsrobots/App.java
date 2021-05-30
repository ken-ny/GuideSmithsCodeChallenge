package com.jaime.marsrobots;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.jaime.marsrobots.POJO.Input;
import com.jaime.marsrobots.POJO.Mars;
import com.jaime.marsrobots.POJO.Robot;
import com.jaime.marsrobots.common.Errors;
import com.jaime.marsrobots.controller.AppController;
import com.jaime.marsrobots.controller.OutputImpl;

public class App 
{
    public static void main( String[] args )
    {
    	Mars mars;
    	System.out.println("Hello human. Please, input the coordinates x and y of the planet Mars separated by spaces:");
    	try {
			String coordinates = new BufferedReader(new InputStreamReader(System.in)).readLine();
			if(coordinates.isBlank()) {
		    	Errors.EMPTY_INPUT.print();
		    	return;
			}
			String[] split = coordinates.split(" ");
			if(split.length<2) {
		    	Errors.MISSING_PARAM.print();
		    	return;
			}
			
			mars = new Mars(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
		} catch (IOException e) {
	    	Errors.ERROR_COORDINATES.toString();
	    	return;
		}
    	
    	System.out.println("Thank you. Now you can start deployment of roboworkers.");
    	
    	Boolean deploy = true;
    	List<Robot> robotDeployed = new ArrayList<Robot>();
    	
    	while(deploy) {
        	System.out.println("Please, indicate the inicial coordinates of the roboworker and its orientation separated by space. Ex: 1 1 N");
        	
        	try {
    			String deployment = new BufferedReader(new InputStreamReader(System.in)).readLine();
    			
    			if(deployment.isBlank()) {
    		    	Errors.EMPTY_INPUT.print();
    		    	return;
    			}
    			
    			String[] split = deployment.split(" ");
    			if(split.length<3) {
    		    	Errors.MISSING_PARAM.print();
    		    	return;
    			}
    			Robot robot = new Robot(Integer.parseInt(split[0]), Integer.parseInt(split[1]), split[2]);
            	
    			System.out.println("Please, indicate the instructions for the roboworker");
    			String instructions = new BufferedReader(new InputStreamReader(System.in)).readLine();
    			if(instructions.length()>=100) {
    				Errors.TOO_MANY_INSTRUCTIONS.print();
    				return;
    			}
    			
    			robot.setInstructions(instructions);    			
            	robotDeployed.add(robot);
            	
            	System.out.println("Do you wish to deploy another robot? Y/N");
				String decision = new BufferedReader(new InputStreamReader(System.in)).readLine();
				if(!"Y".equalsIgnoreCase(decision)) {
					deploy=false;
				}

    		} catch (IOException e) {
    			Errors.ERROR_COORDINATES.toString();
    	    	return;
    		}
        	
    	}
    	
    	System.out.println("Thank you. Exploration start...");

    	new AppController().execute(new Input(robotDeployed, mars), new OutputImpl());

    	
    }
    
}
