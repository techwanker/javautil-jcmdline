package org.javautil.commandline;

import org.junit.Test;

import jcmdline.CmdLineException;

public class ArgumentBeanTest {
	@Test(expected = java.lang.IllegalArgumentException.class)
	// No such directory
	public void testArguments()  {
		final ArgumentBean argumentBean = new ArgumentBean();
		final CommandLineHandler clh = new CommandLineHandler(argumentBean);
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString("-required twit");
	}
}
