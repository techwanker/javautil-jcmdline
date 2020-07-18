package org.javautil.commandline.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.javautil.commandline.CommandLineHandler;
import org.junit.Test;

public class TrumpCrimesTest {
 
	@Test(expected=java.lang.IllegalStateException.class) 
	public void test1() {
		
		String [] yourbullshit = { "--help" };
		TrumpCrimesArguments tca = TrumpCrimesArguments.evaluateArguments(yourbullshit);
		TrumpCrimes crimes = new TrumpCrimes(tca);
		String youbelieve = crimes.newsNoise();
		assertNotNull(youbelieve);
	}
	@Test(expected=java.lang.IllegalArgumentException.class) 
	public void testInt() {
		String args [] = {"3"};
		Integer count = Integer.parseInt(args[0]);
		TrumpCrimesArguments  arguments = new TrumpCrimesArguments();
		new CommandLineHandler(TrumpCrimesArguments.evaluateArguments(args));
		new TrumpCrimes(arguments);
		assertEquals(count,arguments.getCriminalCounts());
	}

	
	@Test
	public void testIntProper() {
		String args [] = {"--criminalCounts","8"};
	   Integer count = Integer.parseInt(args[1]);
		TrumpCrimesArguments  arguments = TrumpCrimesArguments.evaluateArguments(args);
		assertEquals(count,arguments.getCriminalCounts());
		new TrumpCrimes(arguments);
	}
}
