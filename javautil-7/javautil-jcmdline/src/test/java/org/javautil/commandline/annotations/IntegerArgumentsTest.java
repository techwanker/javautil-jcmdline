package org.javautil.commandline.annotations;

import static org.junit.Assert.assertEquals;

import org.javautil.commandline.BaseTest;
import org.javautil.commandline.CommandLineHandler;
import org.junit.Test;

import jcmdline.CmdLineException;

public class IntegerArgumentsTest extends BaseTest {

	private final IntegerArguments argumentBean = new IntegerArguments();
	private final CommandLineHandler clh = new CommandLineHandler(argumentBean);

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNoArg() {
		final String argString = "-intValue ";
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString(argString);
	}

	@Test
	public void test3() {
		final String argString = "-intValue 1";
		clh.evaluateArgumentsString(argString);
		assertEquals(Integer.valueOf(1), argumentBean.getIntValue());
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testIllegalIntegerArgumentValue() {
		final String argString = "-intValue one";
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString(argString);
	}
}
