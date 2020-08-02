package org.javautil.commandline.annotations;

import org.javautil.commandline.BaseTest;
import org.javautil.commandline.CommandLineHandler;
import org.javautil.commandline.NoExitException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jcmdline.CmdLineException;

public class ExclusiveArgumentsTest extends BaseTest {

	private final ExclusiveArguments argumentBean = new ExclusiveArguments();
	private final CommandLineHandler clh = new CommandLineHandler(argumentBean);
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void testToad() {
		final String argString = "-toad bufo ";
		clh.evaluateArgumentsString(argString);
	}

	@Test
	public void testFrog() {
		final String argString = "-frog rana";
		clh.evaluateArgumentsString(argString);
	}

	// TODO should have a way to run and throw a InvalidRuntimeArgumentException
	@Test(expected = NoExitException.class)
	public void testExclusive() {
		final String argString = "-frog rana -toad bufo";
		final boolean result = clh.evaluateArgumentsString(argString);
		logger.debug("result " + result);
	}
}
