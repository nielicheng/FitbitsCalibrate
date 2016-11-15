package com.nie.fitbits;

public class Trainee {

	private int x;
	private int y;
	private String direction;
	
	public Trainee(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getDirection() {
		return direction;
	}

	public void execute(String command) {
		if(command.equals("L")) {
			if(direction.equals("N")) {
				direction = "W";
			}
		}
		else if(command.equals("R")) {
			if(direction.equals("N")) {
				direction = "E";
			}
		}
		
	}

}
