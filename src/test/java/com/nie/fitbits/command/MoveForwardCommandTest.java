package com.nie.fitbits.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import com.nie.fitbits.Trainee;

@RunWith(MockitoJUnitRunner.class)
public class MoveForwardCommandTest {

	@Mock
	private Trainee trainee;
	
	@InjectMocks
	private MoveForwardCommand moveForwardCommand;
	
	@Test
	public void whenMoveForwardCommandExecuteThenMoveForwardOfTraineeIsCalled() {
		moveForwardCommand.execute();
		verify(trainee, times(1)).moveForward();
	}

}
