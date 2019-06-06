package com.virtusa.spell.util;

public class SpellUtil {

	public static String spellHundreds(int num) {
		String hundreds = "";
		if (num / 100 > 0) {
			hundreds = spellOnes(num / 100) + " hundred";
		}
		String tens = spellToHundred(num % 100);

		return (hundreds.equals("")) ? tens : ((tens.equals("")) ? hundreds : (hundreds + " and " + tens));
	}

	public static String spellToHundred(int num) {
		String spelling = "";
		if (num % 10 == 0) {
			spelling = spellTens(num);
		} else {
			if (num / 10 == 1) {
				spelling = spellTeens(num);
			} else {
				String tens = spellTens(num / 10);
				spelling = (tens.equals("")) ? spellOnes(num % 10) : (tens + " " + spellOnes(num % 10));
			}
		}
		return spelling;
	}

	public static String spellTeens(int num) {
		switch (num) {
		case 19:
			return "nineteen";
		case 18:
			return "eighteen";
		case 17:
			return "seventeen";
		case 16:
			return "sixteen";
		case 15:
			return "fifteen";
		case 14:
			return "fourteen";
		case 13:
			return "thirteen";
		case 12:
			return "twelve";
		case 11:
			return "eleven";
		default:
			return "";
		}
	}

	public static String spellTens(int num) {
		switch (num) {
		case 9:
			return "ninety";
		case 8:
			return "eighty";
		case 7:
			return "seventy";
		case 6:
			return "sixty";
		case 5:
			return "fifty";
		case 4:
			return "forty";
		case 3:
			return "thirty";
		case 2:
			return "twenty";
		case 1:
			return "ten";
		default:
			return "";
		}
	}

	public static String spellOnes(int num) {
		switch (num) {
		case 9:
			return "nine";
		case 8:
			return "eight";
		case 7:
			return "seven";
		case 6:
			return "six";
		case 5:
			return "five";
		case 4:
			return "four";
		case 3:
			return "three";
		case 2:
			return "two";
		case 1:
			return "one";
		case 0:
			return "zero";
		default:
			return "";
		}
	}

}
