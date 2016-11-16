package com.nie.fitbits;

import java.util.List;

public class CalibrateInstruction {
	
	private Position initialPosition;
	private List<String> moves;
	
	public Position getInitialPosition() {
		return initialPosition;
	}
	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}
	public List<String> getMoves() {
		return moves;
	}
	public void setMoves(List<String> moves) {
		this.moves = moves;
	}
	
}
