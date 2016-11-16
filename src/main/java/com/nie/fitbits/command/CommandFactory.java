package com.nie.fitbits.command;

import com.nie.fitbits.Trainee;
import com.nie.fitbits.command.exception.CommandFormatException;

public class CommandFactory {
	
	public Command buildCommand(String commandName, Trainee trainee) {
		
		if(commandName == null) {
			throw new CommandFormatException();
		}
		if(trainee == null) {
			throw new IllegalArgumentException("trainee is null.");
		}
		
		switch(commandName) {
			case "L":
				return new TurnLeftCommand(trainee);
			case "R":
				return new TurnRightCommand(trainee);
			case "M":
				return new MoveForwardCommand(trainee);
			default:
				throw new CommandFormatException();
		}
	}
}
