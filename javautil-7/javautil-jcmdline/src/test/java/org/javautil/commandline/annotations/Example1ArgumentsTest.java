package org.javautil.commandline.annotations;

import static org.junit.Assert.assertEquals;

import org.javautil.commandline.BaseTest;
import org.javautil.commandline.CommandLineHandler;
import org.junit.Test;

import jcmdline.CmdLineException;

public class Example1ArgumentsTest extends BaseTest {
	private final Example1Arguments argumentBean = new Example1Arguments();
	private final CommandLineHandler clh = new CommandLineHandler(argumentBean);

	// @Test (expected=org.javautil.security.NoExitException.class)
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void test1() {
		final String argString = "-source AA";
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString(argString);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void test2() {
		final String argString = "-outputFile AA";
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString(argString);
		assertEquals("AA", argumentBean.getoutputFile().getName());
	}
}
