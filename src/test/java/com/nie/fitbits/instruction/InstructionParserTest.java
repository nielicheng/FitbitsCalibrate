package com.nie.fitbits.instruction;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.nie.fitbits.exception.InstructionFormatException;
import com.nie.fitbits.instruction.CalibrateSession;
import com.nie.fitbits.instruction.InstructionParser;
import com.nie.fitbits.instruction.PitchUpperRight;
import com.nie.fitbits.instruction.Position;

public class InstructionParserTest {

	@Test
	public void testParseUpperRightInstructionLine(){
		String instruction = "5 4";
		InstructionParser parser = new InstructionParser();
		PitchUpperRight pitchUpperRight = parser.parsePitchUpperRight(instruction);
		int expectedRight = 5;
		int expectedUpper = 4;
		assertEquals(expectedRight, pitchUpperRight.getRight());
		assertEquals(expectedUpper, pitchUpperRight.getUpper());
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenOnlyOneNumberInUpperRightInstructionLineThenExceptionIsThrown(){
		String instruction = "5";
		InstructionParser parser = new InstructionParser();
		PitchUpperRight pitchUpperRight = parser.parsePitchUpperRight(instruction);
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenALetterInUpperRightInstructionLineThenExceptionIsThrown(){
		String instruction = "5 N";
		InstructionParser parser = new InstructionParser();
		PitchUpperRight pitchUpperRight = parser.parsePitchUpperRight(instruction);
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
		int expectedSize = 4;
		String joinedMoveInstructions = String.join("", moveInstructions);
		assertEquals(expectedSize, moveInstructions.size());
		assertEquals(instruction, joinedMoveInstructions);
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenWrongLetterInMoveInstructionLineThenExceptionIsThrown(){
		String instruction = "LMA";
		InstructionParser parser = new InstructionParser();
		List<String> moveInstructions = parser.parseMoveInstruction(instruction);
	}
	
	@Test
	public void testParseInstructionSeries() {
		String[] instructions = {"5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM"};
		InstructionParser parser = new InstructionParser();
		CalibrateSession session = parser.parseInstructionSeries(Arrays.asList(instructions));
		
		int expectedRight = 5;
		int expectedUpper = 5;
		
		assertNotNull(session);
		assertNotNull(session.getPitchUpperRight());
		assertNotNull(session.getCalibrateInstruction());

		assertEquals(expectedRight, session.getPitchUpperRight().getRight());
		assertEquals(expectedUpper, session.getPitchUpperRight().getUpper());
		
		int expectedNumCalibrateInstructions=2;
		assertEquals(expectedNumCalibrateInstructions, session.getCalibrateInstruction().size());
		
		int expectedX1 = 1;
		int expectedY1 = 2;
		String expectedDirection1 = "N";
		String expectedMoves1 = "LMLMLMLMM";
		
		assertEquals(expectedX1, session.getCalibrateInstruction().get(0).getInitialPosition().getX());
		assertEquals(expectedY1, session.getCalibrateInstruction().get(0).getInitialPosition().getY());
		assertEquals(expectedDirection1, session.getCalibrateInstruction().get(0).getInitialPosition().getDirection());
		String joinedMoveInstructions1 = String.join("", session.getCalibrateInstruction().get(0).getMoves());
		assertEquals(expectedMoves1, joinedMoveInstructions1);
		
		int expectedX2 = 3;
		int expectedY2 = 3;
		String expectedDirection2 = "E";
		String expectedMoves2 = "MMRMMRMRRM";
		
		assertEquals(expectedX2, session.getCalibrateInstruction().get(1).getInitialPosition().getX());
		assertEquals(expectedY2, session.getCalibrateInstruction().get(1).getInitialPosition().getY());
		assertEquals(expectedDirection2, session.getCalibrateInstruction().get(1).getInitialPosition().getDirection());
		String joinedMoveInstructions2 = String.join("", session.getCalibrateInstruction().get(1).getMoves());
		assertEquals(expectedMoves2, joinedMoveInstructions2);
	}
}
