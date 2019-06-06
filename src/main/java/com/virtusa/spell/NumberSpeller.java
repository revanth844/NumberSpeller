package com.virtusa.spell;

import com.virtusa.spell.exceptions.LimitException;
import com.virtusa.spell.exceptions.NonIntegerException;
import com.virtusa.spell.exceptions.NonNumericException;
import com.virtusa.spell.exceptions.ParseException;

public interface NumberSpeller {

	String spellNumber(String number) throws LimitException, ParseException, NonNumericException, NonIntegerException;

}
