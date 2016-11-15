package com.nie.fitbits;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class InstructionParserTest {

	@Test
	public void testParseUpperRightInstructionLine(){
		String instruction = "5 4";
		InstructionParser parser = new InstructionParser();
		PitchSize pitchSize = parser.parsePitchSize(instruction);
		int expectedGridNumX = 5;
		int expectedGridNumY = 4;
		assertEquals(expectedGridNumX, pitchSize.getGridNumX());
		assertEquals(expectedGridNumY, pitchSize.getGridNumY());
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenOnlyOneNumberInUpperRightInstructionLineThenExceptionIsThrown(){
		String instruction = "5";
		InstructionParser parser = new InstructionParser();
		PitchSize pitchSize = parser.parsePitchSize(instruction);
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenALetterInUpperRightInstructionLineThenExceptionIsThrown(){
		String instruction = "5 N";
		InstructionParser parser = new InstructionParser();
		PitchSize pitchSize = parser.parsePitchSize(instruction);
	}
	
	@Test
	public void testParsePositionInstructionLine(){
		String instruction = "3 4 N";
		InstructionParser parser = new InstructionParser();
		Position position = parser.parsePosition(instruction);
		int expectedX = 3;
		int expectedY = 4;
		String expectedDirection = "N";
		assertEquals(expectedX, position.getX());
		assertEquals(expectedY, position.getY());
		assertEquals(expectedDirection, position.getDirection());
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenWrongLetterInPositionInstructionLineThenExceptionIsThrown(){
		String instruction = "4 3 A";
		InstructionParser parser = new InstructionParser();
		Position position = parser.parsePosition(instruction);
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenOnlyOneNumberInPositionInstructionLineThenExceptionIsThrown(){
		String instruction = "4 A";
		InstructionParser parser = new InstructionParser();
		Position position = parser.parsePosition(instruction);
	}
	
	@Test
	public void testParseMoveInstructionLine(){
		String instruction = "LMLM";
		InstructionParser parser = new InstructionParser();
		List<String> moveInstructions = parser.parseMoveInstruction(instruction);
		String joinedMoveInstructions = String.join("", moveInstructions);
		assertEquals(instruction, joinedMoveInstructions);
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenWrongLetterInMoveInstructionLineThenExceptionIsThrown(){
		String instruction = "LMA";
		InstructionParser parser = new InstructionParser();
		List<String> moveInstructions = parser.parseMoveInstruction(instruction);
	}
}
