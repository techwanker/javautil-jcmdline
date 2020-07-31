package org.javautil.commandline.examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.javautil.commandline.CommandLineHandler;
import org.junit.Test;

public class TrueCrimesTest {
 
	@Test(expected=java.lang.IllegalArgumentException.class) 
	public void test1() {
		
		String [] yourbullshit = { "--help" };
		TrueCrimesArguments tca = TrueCrimesArguments.evaluateArguments(yourbullshit);
		String youbelieve = tca.newsNoise();
		assertNotNull(youbelieve);
	}
	@Test(expected=java.lang.IllegalArgumentException.class) 
	public void testInt() {
		String[] args = {"3"};
		Integer count = Integer.parseInt(args[0]);
		TrueCrimesArguments  arguments = new TrueCrimesArguments();
		new CommandLineHandler(TrueCrimesArguments.evaluateArguments(args));
		new TrueCrimes(arguments);
		assertEquals(count,arguments.getCriminalCounts());
	}

	
	@Test
	public void testIntProper() {
		String[] args = {"--criminalCounts","8"};
	   Integer count = Integer.parseInt(args[1]);
		TrueCrimesArguments  arguments = TrueCrimesArguments.evaluateArguments(args);
		assertEquals(count,arguments.getCriminalCounts());
		new TrueCrimes(arguments);
	}
}
