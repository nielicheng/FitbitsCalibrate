package com.nie.fitbits;

import static org.junit.Assert.*;

import org.junit.Test;

public class PitchTest {

	@Test
	public void WhenDividePitchWithGridNumberThenItHasCertainBorderValue() {
		int gridNumX = 5;
		int gridNumY = 5;
		Pitch pitch = new Pitch(gridNumX, gridNumY);
		
		int expectedLower = 0;
		int expectedLeft = 0;
		int expectedRight = 4;
		int expectedUpper = 4;
		
		assertEquals(expectedLower, pitch.getLower());
		assertEquals(expectedLeft, pitch.getLeft());
		assertEquals(expectedUpper, pitch.getUpper());
		assertEquals(expectedRight, pitch.getRight());
	}
	
	@Test
	public void WhenXIsGreaterThanRightThenItIsOutside() {
		int gridNumX = 5;
		int gridNumY = 5;
		Pitch pitch = new Pitch(gridNumX, gridNumY);
		
		int x = 5;
		int y = 2;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}
	
	@Test
	public void WhenXIsLessThanLeftThenItIsOutside() {
		int gridNumX = 5;
		int gridNumY = 5;
		Pitch pitch = new Pitch(gridNumX, gridNumY);
		
		int x = -1;
		int y = 2;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}
	
	@Test
	public void WhenYIsGreaterThanUpperThenItIsOutside() {
		int gridNumX = 5;
		int gridNumY = 5;
		Pitch pitch = new Pitch(gridNumX, gridNumY);
		
		int x = 1;
		int y = 5;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}
	
	@Test
	public void WhenYIsLessThanLowerThenItIsOutside() {
		int gridNumX = 5;
		int gridNumY = 5;
		Pitch pitch = new Pitch(gridNumX, gridNumY);
		
		int x = 1;
		int y = -1;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}

}
