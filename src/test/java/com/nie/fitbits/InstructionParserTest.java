package com.nie.fitbits;

import static org.junit.Assert.*;

import org.junit.Test;

public class InstructionParserTest {

	@Test
	public void whenAStringIsTwoPositiveNumbersSeparatedBySpaceThenAPitchInstanceIsReturned() throws InstructionFormatException {
		String firstLine = "5 4";
		InstructionParser parser = new InstructionParser();
		PitchSize pitchSize = parser.parsePitchSize(firstLine);
		int expectedGridNumX = 5;
		int expectedGridNumY = 4;
		assertEquals(expectedGridNumX, pitchSize.getGridNumX());
		assertEquals(expectedGridNumY, pitchSize.getGridNumY());
	}

}
