package com.test.calc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author lokesh.singh
 *
 */
public class CalculatorAppTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorAppTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, CalculatorApp.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, CalculatorApp.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, CalculatorApp.add("1,2"));
	}

	@Test
	public void testThreeNumbers() {
		assertEquals(6, CalculatorApp.add("1,2,3"));
	}

	@Test
	public void testNewLine() {
		assertEquals(6, CalculatorApp.add("1\n2,3"));
	}

	@Test
	public void testNegativeNumver() {
		try {
			CalculatorApp.add("-1,2");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Negatives not allowed: -1");
		}

		try {
			CalculatorApp.add("2,-4,3,-5");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
		}
	}

	@Test
	public void testOverThousand() {
		assertEquals(2, CalculatorApp.add("1000,2"));
	}

	@Test
	public void testOtherDelimiter() {
		assertEquals(3, CalculatorApp.add("//;\n1;2"));
	}
}