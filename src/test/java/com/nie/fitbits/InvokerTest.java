package com.nie.fitbits;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InvokerTest {

	@Test
	public void whenGiveSeriesOfInstructionsToOneTraineeThenCalibrateProcessIsExecutedAndReturnPositionReport() {
		String[] instructions = {"5 5", "1 2 N", "LMLMLMLMM"};
		Invoker invoker = new Invoker();
		List<String> results = invoker.execute(Arrays.asList(instructions));
		
		String expectedResult = "1 3 N";
		
		String actualResultStr = String.join("", results);
		
		assertEquals(expectedResult, actualResultStr);
	}
	
	@Test
	public void whenGiveSeriesOfInstructionsToOneTraineeThenCalibrateProcessIsExecutedAndReturnPositionReport2() {
		String[] instructions = {"5 5", "3 3 E", "MMRMMRMRRM"};
		Invoker invoker = new Invoker();
		List<String> results = invoker.execute(Arrays.asList(instructions));
		
		String expectedResult = "5 1 E";
		
		String actualResultStr = String.join("", results);
		
		assertEquals(expectedResult, actualResultStr);
	}
	
	@Test
	public void whenGiveSeriesOfInstructionsToTwoTraineesThenCalibrateProcessIsExecutedAndReturnPositionReports() {
		String[] instructions = {"5 5", "1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM"};
		Invoker invoker = new Invoker();
		List<String> results = invoker.execute(Arrays.asList(instructions));
		
		String expectedResult = "1 3 N5 1 E";
		
		String actualResultStr = String.join("", results);
		
		assertEquals(expectedResult, actualResultStr);
	}

}
