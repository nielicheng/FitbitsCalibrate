package com.nie.fitbits.instruction;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.nie.fitbits.instruction.exception.InstructionFormatException;

/**
 * Validate and parse instructions.
 * 
 * @author lnie
 *
 */
public class InstructionParser {
	
	private static final String PATTERN_UPPER_RIGHT_INSTRUCTION = "^(\\d)\\s(\\d)$";
	private static final int GROUP_INDEX_UPPER = 1;
	private static final int GROUP_INDEX_RIGHT = 2;
	
	private static final String PATTERN_POSITION_INSTRUCTION = "(\\d)\\s(\\d)\\s([NWSE])";
	private static final int GROUP_INDEX_X = 1;
	private static final int GROUP_INDEX_Y = 2;
	private static final int GROUP_INDEX_FACING = 3;
	
	private static final String PATTERN_MOVE_INSTRUCTION = "[LRM]+";
	
	private static final int MIN_NUM_INSTRUCTIONS = 3;
	
	private static final int INSTRUCTION_INDEX_UPPERRIGHT =0;

	/**
	 * Parse upper right instruction.
	 * 
	 * @param upperRightInstruction The upper right instruction line
	 * @return {@link PitchUpperRight} instance that represents parsed upper right instruction.
	 * 
	 * @throws InstructionFormatException if wrong formatted instruction is passed in
	 */
	private PitchUpperRight parsePitchUpperRight(String upperRightInstruction){
		PitchUpperRight pitchUpperRight = new PitchUpperRight();
		Pattern pattern = Pattern.compile(PATTERN_UPPER_RIGHT_INSTRUCTION);
		Matcher matcher = pattern.matcher(upperRightInstruction);
		if (matcher.find()) {
			pitchUpperRight.setRight(Integer.valueOf(matcher.group(GROUP_INDEX_UPPER)));
			pitchUpperRight.setUpper(Integer.valueOf(matcher.group(GROUP_INDEX_RIGHT)));
			return pitchUpperRight;
		}
		else {
			throw new InstructionFormatException("Upper right instruction format error: " + upperRightInstruction);
		}
	}

	/**
	 * Parse position instruction.
	 * 
	 * @param instruction The position instruction line
	 * @return {@link Position} instance that represents parsed position instruction.
	 * 
	 * @throws InstructionFormatException if wrong formatted instruction is passed in
	 */
	private Position parsePosition(String instruction) {
		Position position = new Position();
		
		Pattern pattern = Pattern.compile(PATTERN_POSITION_INSTRUCTION);
		Matcher matcher = pattern.matcher(instruction);
		if (matcher.find()) {
			position.setX(Integer.valueOf(matcher.group(GROUP_INDEX_X)));
			position.setY(Integer.valueOf(matcher.group(GROUP_INDEX_Y)));
			position.setFacing(matcher.group(GROUP_INDEX_FACING));
			return position;
		}
		else {
			throw new InstructionFormatException("Position instruction format error: " + instruction);
		}
	}

	/**
	 * Parse move instruction.
	 * 
	 * @param instruction The move instruction line.
	 * @return {@link List} of move instructions.
	 * 
	 * @throws InstructionFormatException if wrong formatted instruction is passed in
	 */
	private List<String> parseMoveInstruction(String instruction) {
		
		Pattern pattern = Pattern.compile(PATTERN_MOVE_INSTRUCTION);
		Matcher matcher = pattern.matcher(instruction);
		if (matcher.matches()) {
			List<String> moves = Arrays.asList(instruction.split(""));
			return moves;
		}
		else {
			throw new InstructionFormatException("Move instruction format error: " + instruction);
		}
	}

	/**
	 * Parse a series of instructions.
	 * 
	 * @param instructions Series of instructions which compose the whole calibrate process.
	 * @return {@link CalibrateSession} instance that represents the whole calibrate process.
	 * 
	 * @throws InstructionFormatException if wrong formatted instruction is passed in
	 */
	public CalibrateSession parseInstructionSeries(List<String> instructions) {
		
		if(instructions == null || instructions.size() < MIN_NUM_INSTRUCTIONS) {
			throw new InstructionFormatException("Not enough instructions in the series.");
		}
		
		PitchUpperRight pitchUpperRight = parsePitchUpperRight(instructions.get(INSTRUCTION_INDEX_UPPERRIGHT));
		List<CalibrateInstruction> calibrateInstructions = IntStream.range(INSTRUCTION_INDEX_UPPERRIGHT + 1, instructions.size() - 1)
				.filter(i -> i % 2 == 1)
                .mapToObj(i -> {
                	CalibrateInstruction calibrateInstruction = new CalibrateInstruction();
                	String positionInstruction = instructions.get(i);
                	String moveInstruction = instructions.get(i+1);
                	calibrateInstruction.setInitialPosition(parsePosition(positionInstruction));
                	calibrateInstruction.setMoves(parseMoveInstruction(moveInstruction));
                	return calibrateInstruction;
                })
                .collect(Collectors.toList());
		
		CalibrateSession calibrateSession = new CalibrateSession();
		calibrateSession.setPitchUpperRight(pitchUpperRight);
		calibrateSession.setCalibrateInstruction(calibrateInstructions);
		
		return calibrateSession;
	}

}
