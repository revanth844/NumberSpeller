package com.virtusa.spell.exceptions;

public class NonNumericException extends Exception {

	private static final long serialVersionUID = 5563705133545663697L;

	public NonNumericException(String errorMessage) {
        super(errorMessage);
    }
}