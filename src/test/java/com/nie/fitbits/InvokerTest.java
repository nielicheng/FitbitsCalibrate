package com.nie.fitbits;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class InvokerTest {

	@Test
	public void test() {
		String[] instructions = {"5 5", "1 2 N", "LMLMLMLMM"};
		Invoker invoker = new Invoker();
		String result = invoker.execute(Arrays.asList(instructions));
		
		String expectedResult = "1 3 N";
		
		assertEquals(expectedResult, result);
	}

}
