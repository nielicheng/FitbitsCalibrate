package com.nie.fitbits;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TraineeTest {

	@Mock
	private Pitch pitch;
	
	@Test
	public void whenGiveTraineeLocationAndDirectionAndPitchThenTheTraineeIsCreated() {
		
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.N;
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(facing, trainee.getFacing());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void whenGiveTraineeLocationOutsideOfPitchThenIllegalArgumentExceptionIsThrown() {
		
		int x = 2;
		int y = 6;
		DIRECTION facing = DIRECTION.N;
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(true);
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void whenGiveTraineeNullFacingThenIllegalArgumentExceptionIsThrown2() {
		
		int x = 2;
		int y = 5;
		DIRECTION facing = null;
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void whenGiveTraineeNullPitchThenIllegalArgumentExceptionIsThrown2() {
		
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.N;
		
		Trainee trainee = new Trainee(x, y, facing, null);
	}
	
	@Test
	public void whenFacingNorthAndGiveTraineeLCommandThenJustTurnLeft() {
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.N;
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.turnLeft();
		
		DIRECTION expectedFacing = DIRECTION.W;
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenFacingWestAndGiveTraineeLCommandThenJustTurnLeft() {
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.W;
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.turnLeft();
		
		DIRECTION expectedFacing = DIRECTION.S;
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenFacingSouthAndGiveTraineeLCommandThenJustTurnLeft() {
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.S;
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.turnLeft();
		
		DIRECTION expectedFacing = DIRECTION.E;
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenFacingEastAndGiveTraineeLCommandThenJustTurnLeft() {
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.E;
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.turnLeft();
		
		DIRECTION expectedFacing = DIRECTION.N;
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenFacingNorthAndGiveTraineeRCommandThenJustTurnRight() {
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.N;
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.turnRight();
		
		DIRECTION expectedFacing = DIRECTION.E;
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenFacingWestAndGiveTraineeRCommandThenJustTurnRight() {
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.W;
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.turnRight();
		
		DIRECTION expectedFacing = DIRECTION.N;
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenFacingSouthAndGiveTraineeRCommandThenJustTurnRight() {
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.S;
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.turnRight();
		
		DIRECTION expectedFacing = DIRECTION.W;
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenFacingEastAndGiveTraineeRCommandThenJustTurnRight() {
		int x = 2;
		int y = 5;
		DIRECTION facing = DIRECTION.E;
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.turnRight();
		
		DIRECTION expectedFacing = DIRECTION.S;
		
		assertEquals(x, trainee.getX());
		assertEquals(y, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenTraineeFaceNorthAndGiveMCommandThenJustMoveNorthOneStep() {
		int x = 2;
		int y = 3;
		DIRECTION facing = DIRECTION.N;
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.moveForward();
		
		DIRECTION expectedFacing = DIRECTION.N;
		int expectedX = 2;
		int expectedY = 4;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenTraineeFaceSouthAndGiveMCommandThenJustMoveSouthOneStep() {
		int x = 2;
		int y = 3;
		DIRECTION facing = DIRECTION.S;
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.moveForward();
		
		DIRECTION expectedFacing = DIRECTION.S;
		int expectedX = 2;
		int expectedY = 2;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenTraineeFaceEastAndGiveMCommandThenJustMoveEastOneStep() {
		int x = 2;
		int y = 3;
		DIRECTION facing = DIRECTION.E;
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.moveForward();
		
		DIRECTION expectedFacing = DIRECTION.E;
		int expectedX = 3;
		int expectedY = 3;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenTraineeFaceWestAndGiveMCommandThenJustMoveWestOneStep() {
		int x = 2;
		int y = 3;
		DIRECTION facing = DIRECTION.W;
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(false);
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		trainee.moveForward();
		
		DIRECTION expectedFacing = DIRECTION.W;
		int expectedX = 1;
		int expectedY = 3;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenTraineeFaceNorthAndAtUpperBorderAndGiveMCommandThenShouldNotMove() {
		int x = 3;
		int y = 4;
		DIRECTION facing = DIRECTION.N;
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(true);
		
		trainee.moveForward();
		
		DIRECTION expectedFacing = DIRECTION.N;
		int expectedX = 3;
		int expectedY = 4;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenTraineeFaceWestAndAtLeftBorderAndGiveMCommandThenShouldNotMove() {
		int x = 0;
		int y = 4;
		DIRECTION facing = DIRECTION.W;
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(true);
		
		trainee.moveForward();
		
		DIRECTION expectedFacing = DIRECTION.W;
		int expectedX = 0;
		int expectedY = 4;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenTraineeFaceSouthAndAtLowerBorderAndGiveMCommandThenShouldNotMove() {
		int x = 3;
		int y = 0;
		DIRECTION facing = DIRECTION.S;
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(true);
		
		trainee.moveForward();
		
		DIRECTION expectedFacing = DIRECTION.S;
		int expectedX = 3;
		int expectedY = 0;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void whenTraineeFaceEastAndAtRightBorderAndGiveMCommandThenShouldNotMove() {
		int x = 5;
		int y = 3;
		DIRECTION facing = DIRECTION.E;
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(true);
		
		trainee.moveForward();
		
		DIRECTION expectedFacing = DIRECTION.E;
		int expectedX = 5;
		int expectedY = 3;
		
		assertEquals(expectedX, trainee.getX());
		assertEquals(expectedY, trainee.getY());
		assertEquals(expectedFacing, trainee.getFacing());
		
	}
	
	@Test
	public void testTraineePositionReport() {
		int x = 3;
		int y = 4;
		DIRECTION facing = DIRECTION.N;
		
		Trainee trainee = new Trainee(x, y, facing, pitch);
		
		when(pitch.isOutside(anyInt(), anyInt())).thenReturn(true);
		
		String positionReport = trainee.reportPosition();
		String expectedPosition = "3 4 N";
		
		assertEquals(expectedPosition, positionReport);
	}

}
