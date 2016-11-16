package com.nie.fitbits;

public class Trainee {

	private int x;
	private int y;
	private DIRECTION facing;
	private Pitch pitch;

	public Trainee(int x, int y, String direction, Pitch pitch) {
		this.x = x;
		this.y = y;
		this.facing = DIRECTION.valueOf(direction);
		this.pitch = pitch;
	}

	public String getFacing() {
		return facing.toString();
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
				int tryX = x + 1;
				if (!pitch.isOutside(tryX, y)) {
					x = x + 1;
				}
				break;
			case N:
				int tryY = y + 1;
				if (!pitch.isOutside(x, tryY)) {
					y = y + 1;
				}
				break;
			case W:
				int tryX2 = x - 1;
				if (!pitch.isOutside(tryX2, y)) {
					x = x - 1;
				}
				break;
			case S:
				int tryY2 = y - 1;
				if (!pitch.isOutside(x, tryY2)) {
					y = y - 1;
				}
				break;
		}
	}

	public String reportPosition() {
		return x + " " + y + " " + facing;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public enum DIRECTION {
		
		E, N, W, S;
		
		static {
			E.setLeftRight(N, S);
			N.setLeftRight(W, E);
			W.setLeftRight(S, N);
			S.setLeftRight(E, W);
		}

		private DIRECTION left;
		private DIRECTION right;

		private void setLeftRight(DIRECTION left, DIRECTION right) {
			this.left = left;
			this.right = right;
		}

		public DIRECTION getLeft() {
			return left;
		}

		public DIRECTION getRight() {
			return right;
		}
	}
}


