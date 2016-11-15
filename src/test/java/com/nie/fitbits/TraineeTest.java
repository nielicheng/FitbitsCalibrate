package com.nie.fitbits;


import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author lnie
 *
 */
public class TraineeTest {

	
	@Test
	public void whenGiveTraineeLocationAndDirectionThenTheTraineeIsThere() {
		
		int x = 2;
		int y = 5;
		String direction = "N";
		Trainee trainee = new Trainee(x, y, direction);
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(direction, trainee.getDirection());
	}
	
	@Test
	public void whenGiveTraineeLCommandThenJustTurnLeft() {
		int x = 2;
		int y = 5;
		String direction = "N";
		Trainee trainee = new Trainee(x, y, direction);
		
		String command = "L";
		trainee.execute(command);
		
		String expectedDirection = "W";
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedDirection, trainee.getDirection());
		
	}
	
	@Test
	public void whenGiveTraineeRCommandThenJustTurnRight() {
		int x = 2;
		int y = 5;
		String direction = "N";
		Trainee trainee = new Trainee(x, y, direction);
		
		String command = "R";
		trainee.execute(command);
		
		String expectedDirection = "E";
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedDirection, trainee.getDirection());
		
	}

}
