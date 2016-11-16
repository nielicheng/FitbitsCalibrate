package com.nie.fitbits.instruction;

import java.util.ArrayList;
import java.util.List;

/**
 * Holding all parsed instructions of a calibrate session.
 * 
 * @author lnie
 *
 */
public class CalibrateSession {
	private PitchUpperRight pitchUpperRight;
	private List<CalibrateInstruction> calibrateInstruction = new ArrayList<>();

	public PitchUpperRight getPitchUpperRight() {
		return pitchUpperRight;
	}

	public void setPitchUpperRight(PitchUpperRight pitchUpperRight) {
		this.pitchUpperRight = pitchUpperRight;
	}

	public List<CalibrateInstruction> getCalibrateInstruction() {
		return calibrateInstruction;
	}

	public void setCalibrateInstruction(List<CalibrateInstruction> calibrateInstruction) {
		this.calibrateInstruction = calibrateInstruction;
	}

}
