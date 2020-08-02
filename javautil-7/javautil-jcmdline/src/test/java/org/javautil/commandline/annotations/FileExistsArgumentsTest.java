package org.javautil.commandline.annotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.javautil.commandline.BaseTest;
import org.javautil.commandline.CommandLineHandler;
import org.junit.Test;

import jcmdline.CmdLineException;
import jcmdline.Parameter;

public class FileExistsArgumentsTest extends BaseTest {

	private final FileExistsArguments argumentBean = new FileExistsArguments();

	private final CommandLineHandler clh = new CommandLineHandler(argumentBean);

	@Test
	public void testExistingFile() {
		final String argString = "-outputFile pom.xml ";
		clh.evaluateArgumentsString(argString);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testNonExistingFile() {
		final String argString = "-outputFile noSuchFile.xml ";
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString(argString);
		final Parameter p = clh.getParameter("outputFile");
		assertNotNull(p);
		assertTrue(p.isSet());
		assertEquals(p.getValue(), "noSuchFile.xml");
	}
}
