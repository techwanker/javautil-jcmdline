package org.javautil.commandline.annotations;

import org.javautil.commandline.CommandLineHandler;

import org.javautil.commandline.NoExitSecurityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import jcmdline.CmdLineException;

public class AcceptableValuesTest {

	@Before
	public void setUp() {
		System.setSecurityManager(new NoExitSecurityManager());
	}

	@After
	public void tearDown() {
		System.setSecurityManager(null);
	}

	private final CommandLineHandler clh = new CommandLineHandler(this);

	@Required
	@AcceptableValues(values = { "a", "b" })
	private String text;

	@Test
	public void test() {
		final String argString = "-text b ";
		clh.evaluateArgumentsString(argString);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testFail() {
		final String argString = "-text c ";
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString(argString);
	}

	public String getText() {
		return text;
	}

	public void setText(final String text) {
		this.text = text;
	}

}
