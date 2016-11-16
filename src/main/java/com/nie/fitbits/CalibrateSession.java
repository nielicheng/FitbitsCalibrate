package com.nie.fitbits;

import java.util.ArrayList;
import java.util.List;

public class CalibrateSession {
	private PitchSize pitchSize;
	private List<CalibrateInstruction> calibrateInstruction = new ArrayList<>();

	public PitchSize getPitchSize() {
		return pitchSize;
	}

	public void setPitchSize(PitchSize pitchSize) {
		this.pitchSize = pitchSize;
	}

	public List<CalibrateInstruction> getCalibrateInstruction() {
		return calibrateInstruction;
	}

	public void setCalibrateInstruction(List<CalibrateInstruction> calibrateInstruction) {
		this.calibrateInstruction = calibrateInstruction;
	}

}
