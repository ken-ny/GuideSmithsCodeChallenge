package com.jaime.marsrobots.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jaime.marsrobots.POJO.Input;
import com.jaime.marsrobots.POJO.Mars;
import com.jaime.marsrobots.POJO.Robot;

import junit.framework.TestCase;

public class AppControllerTest extends TestCase {
	private AppController app;
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	
    @Before                                         
    public void setUp() throws Exception {
        app = new AppController();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    
    @Test                                               
    public void testTurnsLeft() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "L"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("2 2 W", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testTurnsRight() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "R"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("2 2 E", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testMovesForwardNorth() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "F"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("2 3 N", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testMovesForwardEast() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "RF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("3 2 E", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testMovesForwardWest() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "LF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("1 2 W", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testMovesForwardSouth() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "LLF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("2 1 S", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testFallsToTheWest() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "LFF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("0 2 W LOST", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testFallsToTheNorth() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "FFFF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("2 5 N LOST", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testFallsToTheSouth() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "RRFFF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("2 0 S LOST", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testFallsToTheEast() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "RFFFF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("5 2 E LOST", outputStreamCaptor.toString().trim());          
    }
    
    @Test                                               
    public void testFirstRobotFallsToTheWestSecondOneDoesnt() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "LFFRF"));
       	roboList.add(new Robot(2, 2, "N", "LFFRF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("0 2 W LOST\n"
        		+ "1 3 N", outputStreamCaptor.toString().trim());            
    }
    
    @Test                                               
    public void testFirstRobotFallsToTheNorthSecondOneDoesnt() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "FFFFRF"));
       	roboList.add(new Robot(2, 2, "N", "FFFFRF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("2 5 N LOST\n"
        		+ "3 4 E", outputStreamCaptor.toString().trim());            
    }
    
    @Test                                               
    public void testFirstRobotFallsToTheSouthSecondOneDoesnt() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "RRFFFLF"));
       	roboList.add(new Robot(2, 2, "N", "RRFFFLF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("2 0 S LOST\n"
        		+ "3 1 E", outputStreamCaptor.toString().trim());            
    }
    
    @Test                                               
    public void testFirstRobotFallsToTheEastSecondOneDoesnt() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "RFFFFRF"));
       	roboList.add(new Robot(2, 2, "N", "RFFFFRF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("5 2 E LOST\n"
        		+ "4 1 S", outputStreamCaptor.toString().trim());            
    }
    
    @Test                                               
    public void testFirstRobotFallsToTheEastSecondOneFallsSomewhereElse() {
       	List<Robot> roboList = new ArrayList<Robot>();
       	roboList.add(new Robot(2, 2, "N", "RFFFFRF"));
       	roboList.add(new Robot(2, 2, "N", "RFFFFRFLF"));
		Input in = new Input(roboList , new Mars(5, 5));
		app.execute(in, new OutputImpl());
        assertEquals("5 2 E LOST\n"
        		+ "5 1 E LOST", outputStreamCaptor.toString().trim());            
    }
    
    @After
    public void tearDown() {
        System.setOut(standardOut);
    }
	
    
    
}
