package org.javautil.commandline.annotations;

import org.javautil.commandline.BaseTest;
import org.javautil.commandline.CommandLineHandler;
import org.junit.Test;

import jcmdline.CmdLineException;

public class OptionalRequiredArgumentsTest extends BaseTest {
	private final OptionalRequiredArguments argumentBean = new OptionalRequiredArguments();

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testEtc() {
		final CommandLineHandler clh = new CommandLineHandler(argumentBean);
		final String argString = "-requiredDirectory /etc";
		clh.evaluateArgumentsString(argString);
	}
}
