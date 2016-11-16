package com.nie.fitbits;

import java.util.List;
import java.util.stream.Collectors;

import com.nie.fitbits.command.Command;
import com.nie.fitbits.command.CommandFactory;
import com.nie.fitbits.instruction.CalibrateSession;
import com.nie.fitbits.instruction.InstructionParser;
import com.nie.fitbits.instruction.Position;

public class CalibrateInvoker {
	
	private InstructionParser parser = new InstructionParser();
	private CommandFactory commandFactory = new CommandFactory();

	public List<String> doCalibrate(List<String> instructionList) {

		CalibrateSession calibrateSession = parser.parseInstructionSeries(instructionList);
		
		Pitch pitch = new Pitch(calibrateSession.getPitchUpperRight().getRight(), calibrateSession.getPitchUpperRight().getUpper());
		
		List<String> results =
			calibrateSession.getCalibrateInstruction().stream().map(calibrateInstruction -> {
				Position initPosition = calibrateInstruction.getInitialPosition();
				List<String> moves =  calibrateInstruction.getMoves();
				Trainee trainee = new Trainee(initPosition.getX(), initPosition.getY(), initPosition.getDirection(), pitch);
				moves.stream().forEach(move -> {
					Command command = commandFactory.buildCommand(move, trainee);
					command.execute();
				});
				return trainee.reportPosition();
			}).collect(Collectors.toList());
		
		return results;
		
	}

}
