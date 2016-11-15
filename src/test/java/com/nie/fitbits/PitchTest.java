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

}
