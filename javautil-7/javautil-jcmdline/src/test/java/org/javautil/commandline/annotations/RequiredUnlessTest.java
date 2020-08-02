package org.javautil.commandline.annotations;

import org.javautil.commandline.BaseTest;
import org.javautil.commandline.CommandLineHandler;
import org.javautil.commandline.NoExitException;
import org.junit.Test;

import jcmdline.CmdLineException;

public class RequiredUnlessTest extends BaseTest {

	private final RequiredUnlessArguments argumentBean = new RequiredUnlessArguments();
	private final CommandLineHandler clh = new CommandLineHandler(argumentBean);

	public void test1() {
		final String argString = "-frog 1 -toad 2 ";
		clh.evaluateArgumentsString(argString);
	}

	@Test
	public void testUnlessField() {
		final String argString = "-toad 2";
		clh.evaluateArgumentsString(argString);
	}

	@Test
	public void testRequiredUnlessOnly() {
		final String argString = "-frog 2";
		clh.evaluateArgumentsString(argString);
	}

	/**
	 * As not frog or toad is provided.
	 *
     */
	@Test(expected = NoExitException.class)
	public void testMissingRequiredUnless() {
		final String argString = "-snake Hognose";
		clh.evaluateArgumentsString(argString);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testMissingRequiredValue() {
		final String argString = "";
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString(argString);
	}
}
