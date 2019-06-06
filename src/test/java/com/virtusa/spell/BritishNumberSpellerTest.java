package com.virtusa.spell;

import static com.virtusa.spell.BaseNumberSpeller.LIMIT_EXCEPTION_TEXT;
import static com.virtusa.spell.BaseNumberSpeller.NON_INTEGER_EXCEPTION_TEXT;
import static com.virtusa.spell.BaseNumberSpeller.NON_NUMERIC_EXCEPTION_TEXT;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.virtusa.spell.exceptions.LimitException;
import com.virtusa.spell.exceptions.NonIntegerException;
import com.virtusa.spell.exceptions.NonNumericException;
import com.virtusa.spell.exceptions.ParseException;

public class BritishNumberSpellerTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void testZero() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		String actualResult = new BritishNumberSpeller().spellNumber("0");
		assertEquals("zero", actualResult);
	}

	@Test
	public void testOnesPlace() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		String actualResult = new BritishNumberSpeller().spellNumber("1");
		assertEquals("one", actualResult);
	}

	@Test
	public void testTensPlace() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		String actualResult = new BritishNumberSpeller().spellNumber("21");
		assertEquals("twenty one", actualResult);
	}

	@Test
	public void testTeenNumbers() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		String actualResult = new BritishNumberSpeller().spellNumber("18");
		assertEquals("eighteen", actualResult);
	}

	@Test
	public void testHundreds() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		String actualResult = new BritishNumberSpeller().spellNumber("105");
		assertEquals("one hundred and five", actualResult);
	}

	@Test
	public void testThousands() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		String actualResult = new BritishNumberSpeller().spellNumber("2000");
		assertEquals("two thousand", actualResult);
	}

	@Test
	public void testMillions() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		String actualResult = new BritishNumberSpeller().spellNumber("56945781");
		assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one",
				actualResult);
	}

	@Test(expected = LimitException.class)
	public void testOutOfRange() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		new BritishNumberSpeller().spellNumber("1000000000");
		// exceptionRule.expect(LimitException.class);
		exceptionRule.expectMessage(LIMIT_EXCEPTION_TEXT);
	}

	@Test(expected = NonNumericException.class)
	public void testNonNumericCharacters()
			throws LimitException, ParseException, NonNumericException, NonIntegerException {
		new BritishNumberSpeller().spellNumber("3agf5");
		exceptionRule.expectMessage(NON_NUMERIC_EXCEPTION_TEXT);
	}

	@Test(expected = NonNumericException.class)
	public void testNumberWithCommas() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		new BritishNumberSpeller().spellNumber("999,999");
		exceptionRule.expectMessage(NON_NUMERIC_EXCEPTION_TEXT);
	}

	@Test(expected = NonIntegerException.class)
	public void testNonIntegerInput() throws LimitException, ParseException, NonNumericException, NonIntegerException {
		new BritishNumberSpeller().spellNumber("-302");
		exceptionRule.expectMessage(NON_INTEGER_EXCEPTION_TEXT);
	}
	
}
