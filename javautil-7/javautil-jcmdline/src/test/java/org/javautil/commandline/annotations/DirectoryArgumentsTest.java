package org.javautil.commandline.annotations;

import org.javautil.commandline.BaseTest;
import org.javautil.commandline.CommandLineHandler;
import org.junit.Test;

import jcmdline.CmdLineException;

public class DirectoryArgumentsTest extends BaseTest {

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void optionalDirectory() {
		final DirectoryArguments da = new DirectoryArguments();
		final CommandLineHandler clh = new CommandLineHandler(da);
		final String argString = "-optionalDirectory ";
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString(argString);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void test2() {
		final DirectoryArguments da = new DirectoryArguments();
		final CommandLineHandler clh = new CommandLineHandler(da);
		final String argString = "-yo ";
		clh.setDieOnParseError(false);
		clh.evaluateArgumentsString(argString);
	}

	// TODO this should have failed as there is no such directory
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void optionalNonExistentDirectory() {
		// todo ensure that this directory doesn't exist
		final DirectoryArguments da = new DirectoryArguments();
		final CommandLineHandler clh = new CommandLineHandler(da);
		clh.setDieOnParseError(false);
		final String argString = "-optionalReadableDirectory swizzle ";
		clh.evaluateArgumentsString(argString);
	}

	@Test
	public void test6() {
		// todo ensure that this directory doesn't exist
		final DirectoryArguments da = new DirectoryArguments();
		final CommandLineHandler clh = new CommandLineHandler(da);
		final String argString = "-requiredDirectory src ";
		clh.evaluateArgumentsString(argString);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void optionalExistingReadableDirectoryTest() {
		// todo ensure that this directory doesn't exist
		final DirectoryArguments da = new DirectoryArguments();
		final CommandLineHandler clh = new CommandLineHandler(da);
		clh.setDieOnParseError(false);
		final String argString = "-requiredDirectory src -optionalExistingReadableDirectory swizzle";
		clh.evaluateArgumentsString(argString);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void optionalReadableDirectoryTest() {
		// todo ensure that this directory doesn't exist
		final DirectoryArguments da = new DirectoryArguments();
		final CommandLineHandler clh = new CommandLineHandler(da);
		clh.setDieOnParseError(false);
		final String argString = "-requiredDirectory src -optionalReadableDirectory swizzle";
		clh.evaluateArgumentsString(argString);
	}

	// todo this should have failed as there is no such directory
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void test5() {
		// todo ensure that this directory doesn't exist
		final DirectoryArguments da = new DirectoryArguments();
		final CommandLineHandler clh = new CommandLineHandler(da);
		clh.setDieOnParseError(false);
		final String argString = "-requiredDirectory swizzle ";
		clh.evaluateArgumentsString(argString);
	}
}
