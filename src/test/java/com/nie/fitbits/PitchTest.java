package com.nie.fitbits;

import static org.junit.Assert.*;

import org.junit.Test;

public class PitchTest {

	@Test
	public void WhenGiveUpperRightThenPitchHasCertainBorderValue() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(right, upper);
		
		int expectedLower = 0;
		int expectedLeft = 0;
		int expectedRight = 5;
		int expectedUpper = 5;
		
		assertEquals(expectedLower, pitch.getLower());
		assertEquals(expectedLeft, pitch.getLeft());
		assertEquals(expectedUpper, pitch.getUpper());
		assertEquals(expectedRight, pitch.getRight());
	}
	
	@Test
	public void WhenXIsGreaterThanRightThenItIsOutside() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(right, upper);
		
		int x = 6;
		int y = 2;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}
	
	@Test
	public void WhenXIsLessThanLeftThenItIsOutside() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(right, upper);
		
		int x = -1;
		int y = 2;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}
	
	@Test
	public void WhenYIsGreaterThanUpperThenItIsOutside() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(right, upper);
		
		int x = 1;
		int y = 6;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}
	
	@Test
	public void WhenYIsLessThanLowerThenItIsOutside() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(right, upper);
		
		int x = 1;
		int y = -1;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}

}
