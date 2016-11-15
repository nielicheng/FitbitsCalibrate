package com.nie.fitbits;

public class Trainee {

	private int x;
	private int y;
	private DIRECTION direction;
	private Pitch pitch;
	
	public Trainee(int x, int y, String direction, Pitch pitch) {
		this.x = x;
		this.y = y;
		this.direction = DIRECTION.valueOf(direction);
		this.pitch = pitch;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getDirection() {
		return direction.toString();
	}
	
	public void execute(String command) {
		if(command.equals("L")) {
			direction = direction.getLeft();
		}
		else if(command.equals("R")) {
			direction = direction.getRight();
		}
		if(command.equals("M")) {
			switch (direction) {
				case E: 
					int tryX = x + 1;
					if(!pitch.isOutside(tryX, y)) {
						x = x + 1;
					}
					break;
				case N:
					int tryY = y + 1;
					if(!pitch.isOutside(x, tryY)) {
						y = y + 1;
					}
					break;
				case W:
					int tryX2 = x - 1;
					if(!pitch.isOutside(tryX2, y)) {
						x = x - 1;
					}
					break;
				case S:
					int tryY2 = y - 1;
					if(!pitch.isOutside(x, tryY2)) {
						y = y-1;
					}
					break;
			}
		}
	}

}
