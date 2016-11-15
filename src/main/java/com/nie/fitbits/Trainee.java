package com.nie.fitbits;

public class Trainee {

	private int x;
	private int y;
	private DIRECTION direction;
	
	public Trainee(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = DIRECTION.valueOf(direction);
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
		
	}

}
