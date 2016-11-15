package com.nie.fitbits;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InstructionParser {
	
	private static final String PATTERN_UPPER_RIGHT_INSTRUCTION = "(\\d)\\s(\\d)";

	public PitchSize parsePitchSize(String upperRightInstruction) throws InstructionFormatException {
		PitchSize pitchSize = new PitchSize();
		Pattern pattern = Pattern.compile(PATTERN_UPPER_RIGHT_INSTRUCTION);
		Matcher matcher = pattern.matcher(upperRightInstruction);
		if (matcher.find()) {
			pitchSize.setGridNumX(Integer.valueOf(matcher.group(1)));
			pitchSize.setGridNumY(Integer.valueOf(matcher.group(2)));
			return pitchSize;
		}
		else {
			throw new InstructionFormatException();
		}
	}

}
