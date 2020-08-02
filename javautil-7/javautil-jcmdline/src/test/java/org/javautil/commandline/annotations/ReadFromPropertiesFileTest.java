package org.javautil.commandline.annotations;

import static org.junit.Assert.assertEquals;

import org.javautil.commandline.BaseTest;
import org.javautil.commandline.CommandLineHandler;
import org.junit.Test;

import jcmdline.CmdLineException;

public class ReadFromPropertiesFileTest extends BaseTest {

	private final IntegerArguments argumentBean = new IntegerArguments();
	private final CommandLineHandler clh = new CommandLineHandler(argumentBean);

	@Test
	public void testNoArg() {
		final String argString = "--from-properties target/test-classes/org/javautil/commandline/ReadFromPropertiesFile.properties";
		clh.evaluateArgumentsString(argString);
		assertEquals(Integer.valueOf(1), argumentBean.getIntValue());
	}

	@Test
	public void testWithEquals() {
		final String argString = "--from-properties=target/test-classes/org/javautil/commandline/ReadFromPropertiesFile.properties";
		clh.evaluateArgumentsString(argString);
		assertEquals(Integer.valueOf(1), argumentBean.getIntValue());
	}
}
