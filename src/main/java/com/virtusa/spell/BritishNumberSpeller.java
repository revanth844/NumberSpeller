package com.virtusa.spell;

import static com.virtusa.spell.util.SpellUtil.*;
import static com.virtusa.spell.util.ValidationUtil.*;

import com.virtusa.spell.exceptions.LimitException;
import com.virtusa.spell.exceptions.NonIntegerException;
import com.virtusa.spell.exceptions.NonNumericException;
import com.virtusa.spell.exceptions.ParseException;

public class BritishNumberSpeller extends BaseNumberSpeller implements NumberSpeller {

	public String spellNumber(String number)
			throws LimitException, ParseException, NonNumericException, NonIntegerException {
		System.out.println(number + " : ");
		
		if (!isNumeric(number)) {
			throw new NonNumericException(NON_NUMERIC_EXCEPTION_TEXT);
		}
		if (!isNumber(number)) {
			throw new NonIntegerException(NON_INTEGER_EXCEPTION_TEXT);
		}
		if (number.length() > 9) {
			throw new LimitException(LIMIT_EXCEPTION_TEXT);
		}

		String spelling = "";
		int numLength = number.length();
		try {
			if (number.length() > 6) {
				String millions = number.substring(0, numLength - 6);
				spelling = spellHundreds(Integer.parseInt(millions)) + " million";
				number = number.substring(number.length() - 6, number.length());
			}
			spelling = addSpaceIfNotNull(spelling, number);
			if (number.length() > 3) {
				String thousands = number.substring(0, number.length() - 3);
				spelling = spelling + spellHundreds(Integer.parseInt(thousands)) + " thousand";
				number = number.substring(number.length() - 3, number.length());
			}
			spelling = addSpaceIfNotNull(spelling, number);
			spelling = spelling + spellHundreds(Integer.parseInt(number));

			if (spelling.equals("")) {
				spelling = "zero";
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ParseException(e);
		}

		System.out.println(spelling);
		return spelling;
	}

	public static void main(String[] args) throws Exception {
		if (args.length == 1) {
			BritishNumberSpeller inst = new BritishNumberSpeller();
			inst.spellNumber(args[0]);
		} else {
			System.out.println("Input Error: Please input the number to spell");
		}
	}

}
