package com.jaime.marsrobots.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.jaime.marsrobots.POJO.Input;
import com.jaime.marsrobots.POJO.Mars;
import com.jaime.marsrobots.POJO.Robot;

public class OutputImpl implements Output{

	@Override
	public void print(String message) {
		System.out.println(message);
		
	}

	@Override
	public void save(Input in) {
		try {		  
		  Files.write(Paths.get("report"+getDate()+".txt"), 
			        writeReport(in.getRobotList(), in.getPlanet()), 
			        StandardCharsets.UTF_8,
	                StandardOpenOption.CREATE, 
	                StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private List<String> writeReport(List<Robot> list, Mars mars) {
		List<String>report = new ArrayList<String>();
		
		report.add("Date: "+getDate());
		report.add("Limits Discovered: ");
		mars.getDangerZone().forEach((d) -> report.add(d.toString()));
		report.add("Robots deployed: "+String.valueOf(list.size()));
		report.add("---------Robots Final Status----------");
		list.forEach((r)-> report.add(r.toString()));
		return report;
	}

	private String getDate() {
		
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"); 
		return LocalDateTime.now().format(pattern);
	}
	
}
