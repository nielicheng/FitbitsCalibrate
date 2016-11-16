package com.nie.fitbits;

import java.util.List;

public class Invoker {
	

	public String execute(List<String> instructionList) {
		String upperRightInstruction = instructionList.get(0);
		String positionInstruction = instructionList.get(1);
		String moveInstruction = instructionList.get(2);
		
		InstructionParser parser = new InstructionParser();
		PitchSize size = parser.parsePitchSize(upperRightInstruction);
		Position position = parser.parsePosition(positionInstruction);
		List<String> moves = parser.parseMoveInstruction(moveInstruction);
		
		Pitch pitch = new Pitch(size.getGridNumX(), size.getGridNumY());
		Trainee trainee = new Trainee(position.getX(), position.getY(), position.getDirection(), pitch);
		
		moves.stream().forEach(move -> {
			trainee.execute(move);
		});
		
		return trainee.reportPosition();
		
	}

}
