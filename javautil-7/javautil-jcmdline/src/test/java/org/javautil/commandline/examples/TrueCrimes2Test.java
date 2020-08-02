package org.javautil.commandline.examples;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrueCrimes2Test {
 

	@Test
	public void testIntProper() {
		String[] args = {"--criminalCounts","8"};
	   Integer count = Integer.parseInt(args[1]);
		TrueCrimesArguments  arguments = TrueCrimesArguments.evaluateArguments(args);
		assertEquals(count,arguments.getCriminalCounts());
		new TrueCrimes(arguments);
	}
}
