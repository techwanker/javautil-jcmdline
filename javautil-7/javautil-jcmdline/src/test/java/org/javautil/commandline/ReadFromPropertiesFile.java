package org.javautil.commandline;

import static org.junit.Assert.assertEquals;

import org.javautil.commandline.annotations.IntegerArguments;
import org.junit.Test;

import jcmdline.CmdLineException;

public class ReadFromPropertiesFile extends BaseTest {
	// TODO make this work

	@Test
	public void testEquals() {
		final IntegerArguments argumentBean = new IntegerArguments();
		final CommandLineHandler clh = new CommandLineHandler(argumentBean);
		clh.evaluateArgumentsString("--from-properties=src/test/resources/org/javautil/commandline/ReadFromPropertiesFile.properties");
		assertEquals(Integer.valueOf(1), argumentBean.getIntValue());
	}

	@Test
	public void test2() {
		final IntegerArguments argumentBean = new IntegerArguments();
		final CommandLineHandler clh = new CommandLineHandler(argumentBean);
		clh.evaluateArgumentsString("--from-properties src/test/resources/org/javautil/commandline/ReadFromPropertiesFile.properties");
		assertEquals(Integer.valueOf(1), argumentBean.getIntValue());
	}
}
