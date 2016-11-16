package com.nie.fitbits;

import static org.junit.Assert.*;

import org.junit.Test;

public class PitchTest {

	@Test
	public void WhenGiveUpperRightThenPitchIsCreated() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(upper, right);
		
		int expectedLower = 0;
		int expectedLeft = 0;
		int expectedRight = 5;
		int expectedUpper = 5;
		
		assertEquals(expectedLower, pitch.getLower());
		assertEquals(expectedLeft, pitch.getLeft());
		assertEquals(expectedUpper, pitch.getUpper());
		assertEquals(expectedRight, pitch.getRight());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void WhenGiveZeroUpperValueThenIllegalArgumentExceptionIsThrown() {
		int right = 5;
		int upper = 0;
		Pitch pitch = new Pitch(upper, right);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void WhenGiveZeroRightValueThenIllegalArgumentExceptionIsThrown() {
		int right = 0;
		int upper = 5;
		Pitch pitch = new Pitch(upper, right);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void WhenGiveMinusUpperValueThenIllegalArgumentExceptionIsThrown() {
		int right = 5;
		int upper = -1;
		Pitch pitch = new Pitch(upper, right);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void WhenGiveMinusRightValueThenIllegalArgumentExceptionIsThrown() {
		int right = -5;
		int upper = 1;
		Pitch pitch = new Pitch(upper, right);
	}
	
	@Test
	public void WhenXIsGreaterThanRightThenItIsOutside() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(upper, right);
		
		int x = 6;
		int y = 2;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}
	
	@Test
	public void WhenXIsLessThanLeftThenItIsOutside() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(upper, right);
		
		int x = -1;
		int y = 2;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}
	
	@Test
	public void WhenYIsGreaterThanUpperThenItIsOutside() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(upper, right);
		
		int x = 1;
		int y = 6;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}
	
	@Test
	public void WhenYIsLessThanLowerThenItIsOutside() {
		int right = 5;
		int upper = 5;
		Pitch pitch = new Pitch(upper, right);
		
		int x = 1;
		int y = -1;
		
		boolean expectedIsOutside = true;
		
		assertEquals(expectedIsOutside, pitch.isOutside(x, y));
	}

}
