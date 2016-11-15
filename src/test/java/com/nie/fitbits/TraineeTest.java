package com.nie.fitbits;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
/**
 * 
 * @author lnie
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TraineeTest {

	@Mock
	private Pitch pitch;
	
	@Test
	public void whenGiveTraineeLocationAndDirectionThenTheTraineeIsThere() {
		
		int x = 2;
		int y = 5;
		String direction = "N";
		Trainee trainee = new Trainee(x, y, direction, pitch);
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(direction, trainee.getDirection());
	}
	
	@Test
	public void whenGiveTraineeLCommandThenJustTurnLeft() {
		int x = 2;
		int y = 5;
		String direction = "N";
		Trainee trainee = new Trainee(x, y, direction, pitch);
		
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
		Trainee trainee = new Trainee(x, y, direction, pitch);
		
		String command = "R";
		trainee.execute(command);
		
		String expectedDirection = "E";
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedDirection, trainee.getDirection());
		
	}
	
	@Test
	public void whenTraineeFaceNorthAndGiveMCommandThenJustMoveNorthOneStep() {
		int x = 2;
		int y = 3;
		String direction = "N";
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		
		Trainee trainee = new Trainee(x, y, direction, pitch);
		
		String command = "M";
		trainee.execute(command);
		
		String expectedDirection = "N";
		int expectedX = 2;
		int expectedY = 4;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedDirection, trainee.getDirection());
		
	}
	
	@Test
	public void whenTraineeFaceSouthAndGiveMCommandThenJustMoveSouthOneStep() {
		int x = 2;
		int y = 3;
		String direction = "S";
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		
		Trainee trainee = new Trainee(x, y, direction, pitch);
		
		String command = "M";
		trainee.execute(command);
		
		String expectedDirection = "S";
		int expectedX = 2;
		int expectedY = 2;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedDirection, trainee.getDirection());
		
	}
	
	@Test
	public void whenTraineeFaceEastAndGiveMCommandThenJustMoveEastOneStep() {
		int x = 2;
		int y = 3;
		String direction = "E";
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		
		Trainee trainee = new Trainee(x, y, direction, pitch);
		
		String command = "M";
		trainee.execute(command);
		
		String expectedDirection = "E";
		int expectedX = 3;
		int expectedY = 3;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedDirection, trainee.getDirection());
		
	}
	
	@Test
	public void whenTraineeFaceWestAndGiveMCommandThenJustMoveWestOneStep() {
		int x = 2;
		int y = 3;
		String direction = "W";
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		Trainee trainee = new Trainee(x, y, direction, pitch);
		
		String command = "M";
		trainee.execute(command);
		
		String expectedDirection = "W";
		int expectedX = 1;
		int expectedY = 3;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedDirection, trainee.getDirection());
		
	}
	
	@Test
	public void whenTraineeFaceNorthAndAtUpperBorderAndGiveMCommandThenShouldNotMove() {
		int x = 3;
		int y = 4;
		String direction = "N";
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(true);
		
		Trainee trainee = new Trainee(x, y, direction, pitch);
		
		String command = "M";
		trainee.execute(command);
		
		String expectedDirection = "N";
		int expectedX = 3;
		int expectedY = 4;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedDirection, trainee.getDirection());
		
	}

}
