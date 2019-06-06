package com.virtusa.spell;

public abstract class BaseNumberSpeller implements NumberSpeller {

	public static String NON_NUMERIC_EXCEPTION_TEXT = "Input Error: can only spell numbers. Please remove any other alphanumeric characters";
	public static String NON_INTEGER_EXCEPTION_TEXT = "Input Error: can only spell positive integers (0 to 999,999,999)";
	public static String LIMIT_EXCEPTION_TEXT = "Input Error: can only spell upto 999,999,999";
	
	public static String addSpaceIfNotNull(String input, String number) {
		if (!input.equals("") && Long.parseLong(number) != 0) {
			return input + " ";
		}
		return input;
	}
	
}
