package com.nie.fitbits.instruction;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.nie.fitbits.instruction.CalibrateSession;
import com.nie.fitbits.instruction.InstructionParser;
import com.nie.fitbits.instruction.exception.InstructionFormatException;

public class InstructionParserTest {

	private InstructionParser parser;
	
	@Before
	public void init() {
		parser = new InstructionParser();
	}
	
	@Test
	public void testParseUpperRightInstructionLine(){
		
		String[] instructions = {"5 4", "1 2 N", "LMLMLMLMM"};
		CalibrateSession session = parser.parseInstructionSeries(Arrays.asList(instructions));
		
		int expectedRight = 5;
		int expectedUpper = 4;
		assertEquals(expectedRight, session.getPitchUpperRight().getRight());
		assertEquals(expectedUpper, session.getPitchUpperRight().getUpper());
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenOnlyOneNumberInUpperRightInstructionLineThenExceptionIsThrown(){
		
		String[] instructions = {"5 ", "1 2 N", "LMLMLMLMM"};
		CalibrateSession session = parser.parseInstructionSeries(Arrays.asList(instructions));
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenALetterInUpperRightInstructionLineThenExceptionIsThrown(){
		
		String[] instructions = {"5 N", "1 2 N", "LMLMLMLMM"};
		CalibrateSession session = parser.parseInstructionSeries(Arrays.asList(instructions));
	}
	
	@Test
	public void testParsePositionInstructionLine(){
		
		String[] instructions = {"5 5", "3 4 N", "LMLMLMLMM"};
		CalibrateSession session = parser.parseInstructionSeries(Arrays.asList(instructions));
		int expectedX = 3;
		int expectedY = 4;
		String expectedDirection = "N";
		assertEquals(1, session.getCalibrateInstruction().size());
		assertEquals(expectedX, session.getCalibrateInstruction().get(0).getInitialPosition().getX());
		assertEquals(expectedY, session.getCalibrateInstruction().get(0).getInitialPosition().getY());
		assertEquals(expectedDirection, session.getCalibrateInstruction().get(0).getInitialPosition().getFacing());
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenWrongLetterInPositionInstructionLineThenExceptionIsThrown(){

		String[] instructions = {"5 5", "4 3 A", "LMLMLMLMM"};
		CalibrateSession session = parser.parseInstructionSeries(Arrays.asList(instructions));
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenOnlyOneNumberInPositionInstructionLineThenExceptionIsThrown(){

		String[] instructions = {"5 5", "4 3", "LMLMLMLMM"};
		CalibrateSession session = parser.parseInstructionSeries(Arrays.asList(instructions));
	}
	
	@Test
	public void testParseMoveInstructionLine(){
		String moveInstruction = "LMLM";
		String[] instructions = {"5 5", "4 3 N", moveInstruction};
		CalibrateSession session = parser.parseInstructionSeries(Arrays.asList(instructions));
		int expectedSize = 4;
		String joinedMoveInstructions = String.join("", session.getCalibrateInstruction().get(0).getMoves());
		assertEquals(expectedSize, session.getCalibrateInstruction().get(0).getMoves().size());
		assertEquals(moveInstruction, joinedMoveInstructions);
	}
	
	@Test(expected=InstructionFormatException.class)
	public void whenWrongLetterInMoveInstructionLineThenExceptionIsThrown(){
		String instruction = "LMA";
		String[] instructions = {"5 5", "4 3 N", instruction};
		CalibrateSession session = parser.parseInstructionSeries(Arrays.asList(instructions));
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
		assertEquals(expectedDirection1, session.getCalibrateInstruction().get(0).getInitialPosition().getFacing());
		String joinedMoveInstructions1 = String.join("", session.getCalibrateInstruction().get(0).getMoves());
		assertEquals(expectedMoves1, joinedMoveInstructions1);
		
		int expectedX2 = 3;
		int expectedY2 = 3;
		String expectedDirection2 = "E";
		String expectedMoves2 = "MMRMMRMRRM";
		
		assertEquals(expectedX2, session.getCalibrateInstruction().get(1).getInitialPosition().getX());
		assertEquals(expectedY2, session.getCalibrateInstruction().get(1).getInitialPosition().getY());
		assertEquals(expectedDirection2, session.getCalibrateInstruction().get(1).getInitialPosition().getFacing());
		String joinedMoveInstructions2 = String.join("", session.getCalibrateInstruction().get(1).getMoves());
		assertEquals(expectedMoves2, joinedMoveInstructions2);
	}
}
