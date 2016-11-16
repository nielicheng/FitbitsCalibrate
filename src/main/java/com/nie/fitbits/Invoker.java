package com.nie.fitbits;

import java.util.List;
import java.util.stream.Collectors;

public class Invoker {
	

	public List<String> execute(List<String> instructionList) {
		
		InstructionParser parser = new InstructionParser();
		CalibrateSession calibrateSession = parser.parseInstructionSeries(instructionList);
		
		Pitch pitch = new Pitch(calibrateSession.getPitchSize().getGridNumX(), calibrateSession.getPitchSize().getGridNumY());
		
		List<String> results =
		calibrateSession.getCalibrateInstruction().stream().map(calibrateInstruction -> {
			Position initPosition = calibrateInstruction.getInitialPosition();
			List<String> moves =  calibrateInstruction.getMoves();
			Trainee trainee = new Trainee(initPosition.getX(), initPosition.getY(), initPosition.getDirection(), pitch);
			moves.stream().forEach(move -> {
				trainee.execute(move);
				System.out.println(trainee.reportPosition());
			});
			return trainee.reportPosition();
		}).collect(Collectors.toList());
		
		return results;
		
	}

}
