package com.nie.fitbits.instruction;

import java.util.List;

/**
 * Holding all parsed instructions of one trainee.
 * 
 * @author lnie
 *
 */
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
