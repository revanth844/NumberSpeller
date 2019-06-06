package com.virtusa.spell.util;

public class ValidationUtil {

	public static boolean isNumber(String string) {
		return string.matches("^\\d+$");
	}

	public static boolean isNumeric(String string) {
		return string.matches("^[-+]?\\d+(\\.\\d+)?$");
	}

	public static boolean isAlphabetsOnly(String string) {
		return string.matches("^[a-zA-Z]*$");
	}
	
}
