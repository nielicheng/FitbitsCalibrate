package com.nie.fitbits.command;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.nie.fitbits.Trainee;
import com.nie.fitbits.command.exception.CommandFormatException;

@RunWith(MockitoJUnitRunner.class)
public class CommandFactoryTest {

	@Mock
	private Trainee trainee;
	
	@InjectMocks
	private CommandFactory commandFactory;
	
	public void init() {
		commandFactory = new CommandFactory();
	}
	
	@Test
	public void whenPassLThenReturnTurnLeftCommand() {
		String commandName = "L";
		Command command = commandFactory.buildCommand(commandName, trainee);
		assertNotNull(command);
		assertTrue(command instanceof TurnLeftCommand);
	}
	
	@Test
	public void whenPassRThenReturnTurnRightCommand() {
		String commandName = "R";
		Command command = commandFactory.buildCommand(commandName, trainee);
		assertNotNull(command);
		assertTrue(command instanceof TurnRightCommand);
	}
	
	@Test
	public void whenPassMThenReturnMoveForwardCommand() {
		String commandName = "M";
		Command command = commandFactory.buildCommand(commandName, trainee);
		assertNotNull(command);
		assertTrue(command instanceof MoveForwardCommand);
	}
	
	@Test(expected=CommandFormatException.class)
	public void whenPassWrongLetterThenThrowCommandFormatException() {
		String commandName = "A";
		Command command = commandFactory.buildCommand(commandName, trainee);
	}
	
	@Test(expected=CommandFormatException.class)
	public void whenPassNullLetterThenThrowCommandFormatException() {
		String commandName = null;
		Command command = commandFactory.buildCommand(commandName, trainee);
	}

}
