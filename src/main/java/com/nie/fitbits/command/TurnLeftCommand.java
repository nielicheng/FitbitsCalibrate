package com.nie.fitbits.command;

import com.nie.fitbits.Trainee;

public class TurnLeftCommand implements Command{

	private Trainee trainee;
	
	public TurnLeftCommand(Trainee trainee) {
		this.trainee = trainee;
	}
	
	@Override
	public void execute() {
		trainee.turnLeft();
	}

}
