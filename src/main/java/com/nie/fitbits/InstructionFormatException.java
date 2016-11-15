package com.nie.fitbits;

public class InstructionFormatException extends Exception{

	private static final long serialVersionUID = 1L;

	public InstructionFormatException() {
		super();
	}

	public InstructionFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InstructionFormatException(String message) {
		super(message);
	}

	public InstructionFormatException(Throwable cause) {
		super(cause);
	}
}
