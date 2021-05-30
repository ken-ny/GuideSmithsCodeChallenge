package com.jaime.marsrobots.controller;

import com.jaime.marsrobots.POJO.Input;

public interface Output {

	void print(String message);
	
	void save(Input in);

	
}
