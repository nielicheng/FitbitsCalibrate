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

}
