package com.nie.fitbits.command.exception;

public class CommandFormatException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CommandFormatException() {
		super();
	}

	public CommandFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandFormatException(String message) {
		super(message);
	}

	public CommandFormatException(Throwable cause) {
		super(cause);
	}
}
