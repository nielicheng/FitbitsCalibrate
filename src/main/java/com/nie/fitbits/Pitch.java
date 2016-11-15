package com.nie.fitbits;

public class Pitch {

	private int lower = 0;
	private int left = 0;
	private int upper;
	private int right;
	
	public Pitch(int gridNumX, int gridNumY) {
		this.upper = gridNumY - 1;
		this.right = gridNumX - 1;
	}

	public int getLower() {
		return lower;
	}

	public int getLeft() {
		return left;
	}

	public int getUpper() {
		return upper;
	}

	public int getRight() {
		return right;
	}

	public boolean isOutside(int x, int y) {
		if(x > right || x < left || y > upper || y < lower) {
			return true;
		}
		else {
			return false;
		}
	}

}
