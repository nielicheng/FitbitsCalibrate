package com.nie.fitbits.command;

import com.nie.fitbits.Trainee;

public class MoveForwardCommand implements Command{

	private Trainee trainee;
	
	public MoveForwardCommand(Trainee trainee) {
		this.trainee = trainee;
	}
	
	@Override
	public void execute() {
		trainee.moveForward();
	}

}
