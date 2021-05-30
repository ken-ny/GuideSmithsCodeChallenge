package com.jaime.marsrobots.controller;

import com.jaime.marsrobots.POJO.Input;
public interface Commands {
	  void execute(Input in, OutputImpl out);
}
