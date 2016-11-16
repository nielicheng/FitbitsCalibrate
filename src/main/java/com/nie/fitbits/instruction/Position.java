package com.nie.fitbits.instruction;

/**
 * Holding the parsed location and facing instruction
 * @author lnie
 *
 */
public class Position {
	private int x;
	private int y;
	private String facing;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getFacing() {
		return facing;
	}
	public void setFacing(String facing) {
		this.facing = facing;
	}
	
	
}
