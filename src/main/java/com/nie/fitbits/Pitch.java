package com.nie.fitbits;

/**
 * Define a pitch
 * 
 * @author lnie
 *
 */
public class Pitch {

	private int lower = 0;
	private int left = 0;
	private int upper;
	private int right;
	
	public Pitch(int upper, int right) {
		if(upper <= 0 || right <= 0) {
			throw new IllegalArgumentException("The value of upper or right is not allowed.");
		}
		
		this.upper = upper;
		this.right = right;
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
