package org.javautil.commandline;

import jcmdline.CmdLineException;

import org.junit.Test;

public class ArgumentBeanTest {
	@Test(expected = java.lang.IllegalArgumentException.class)
	// No such directory
	public void testArguments() throws CmdLineException {
		final ArgumentBean argumentBean = new ArgumentBean();
		final CommandLineHandlerDelete clh = new CommandLineHandlerDelete(argumentBean);
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString("-required twit");
	}
}
