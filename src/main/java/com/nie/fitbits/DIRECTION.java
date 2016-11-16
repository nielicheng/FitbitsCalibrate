package com.nie.fitbits;

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