package com.nie.fitbits;

/**
 * Define a trainee.
 * @author lnie
 *
 */
public class Trainee {

	private static final int ONE_STEP  = 1;
	
	private int x;
	private int y;
	private DIRECTION facing;
	private Pitch pitch;

	public Trainee(int x, int y, DIRECTION facing, Pitch pitch) {
		if(facing == null || pitch == null || pitch.isOutside(x, y)) {
			throw new IllegalArgumentException("facing or pitch is null or (x,y) is outside of the pitch.");
		}
		
		this.x = x;
		this.y = y;
		this.facing = facing;
		this.pitch = pitch;
	}

	public DIRECTION getFacing() {
		return facing;
	}

	public void turnLeft() {
		facing = facing.getLeft();
	}

	public void turnRight() {
		facing = facing.getRight();
	}

	public void moveForward() {
		switch (facing) {
			case E:
				int tryX = x + ONE_STEP;
				if (!pitch.isOutside(tryX, y)) {
					x = x + ONE_STEP;
				}
				break;
			case N:
				int tryY = y + ONE_STEP;
				if (!pitch.isOutside(x, tryY)) {
					y = y + ONE_STEP;
				}
				break;
			case W:
				int tryX2 = x - ONE_STEP;
				if (!pitch.isOutside(tryX2, y)) {
					x = x - ONE_STEP;
				}
				break;
			case S:
				int tryY2 = y - ONE_STEP;
				if (!pitch.isOutside(x, tryY2)) {
					y = y - ONE_STEP;
				}
				break;
		}
	}

	public String reportPosition() {
		return x + " " + y + " " + facing.toString();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}


