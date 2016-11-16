package com.nie.fitbits.command;

import com.nie.fitbits.Trainee;

public class TurnRightCommand implements Command{

	private Trainee trainee;
	
	public TurnRightCommand(Trainee trainee) {
		this.trainee = trainee;
	}
	
	@Override
	public void execute() {
		trainee.turnRight();
	}

}
