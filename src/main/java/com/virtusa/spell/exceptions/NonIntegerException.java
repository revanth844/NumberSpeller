package com.virtusa.spell.exceptions;

public class NonIntegerException extends Exception {

	private static final long serialVersionUID = 5563705133545663697L;

	public NonIntegerException(String errorMessage) {
        super(errorMessage);
    }
}