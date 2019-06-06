package com.virtusa.spell.exceptions;

public class LimitException extends Exception {

	private static final long serialVersionUID = 8262633253725278725L;

	public LimitException(String errorMessage) {
        super(errorMessage);
    }
}