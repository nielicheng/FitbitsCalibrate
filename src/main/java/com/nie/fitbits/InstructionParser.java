package com.nie.fitbits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InstructionParser {
	
	private static final String PATTERN_UPPER_RIGHT_INSTRUCTION = "(\\d)\\s(\\d)";
	
	private static final String PATTERN_POSITION_INSTRUCTION = "(\\d)\\s(\\d)\\s([NWSE])";
	
	private static final String PATTERN_MOVE_INSTRUCTION = "[LRM]+";

	public PitchSize parsePitchSize(String upperRightInstruction){
		PitchSize pitchSize = new PitchSize();
		Pattern pattern = Pattern.compile(PATTERN_UPPER_RIGHT_INSTRUCTION);
		Matcher matcher = pattern.matcher(upperRightInstruction);
		if (matcher.find()) {
			pitchSize.setGridNumX(Integer.valueOf(matcher.group(1)));
			pitchSize.setGridNumY(Integer.valueOf(matcher.group(2)));
			return pitchSize;
		}
		else {
			throw new InstructionFormatException("Upper right instruction format error: " + upperRightInstruction);
		}
	}

	public Position parsePosition(String instruction) {
		Position position = new Position();
		
		Pattern pattern = Pattern.compile(PATTERN_POSITION_INSTRUCTION);
		Matcher matcher = pattern.matcher(instruction);
		if (matcher.find()) {
			position.setX(Integer.valueOf(matcher.group(1)));
			position.setY(Integer.valueOf(matcher.group(2)));
			position.setDirection(matcher.group(3));
			return position;
		}
		else {
			throw new InstructionFormatException("Position instruction format error: " + instruction);
		}
	}

	public List<String> parseMoveInstruction(String instruction) {
		
		Pattern pattern = Pattern.compile(PATTERN_MOVE_INSTRUCTION);
		Matcher matcher = pattern.matcher(instruction);
		if (matcher.matches()) {
			List<String> moves = Arrays.asList(instruction.toCharArray()).stream().map(c -> String.valueOf(c)).collect(Collectors.toList());
			return moves;
		}
		else {
			throw new InstructionFormatException("Move instruction format error: " + instruction);
		}
	}

}
