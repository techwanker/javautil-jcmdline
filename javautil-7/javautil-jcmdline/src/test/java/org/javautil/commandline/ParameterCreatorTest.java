package org.javautil.commandline;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.javautil.commandline.annotations.IntegerArguments;
import org.junit.Test;


import jcmdline.IntParam;
import jcmdline.Parameter;

public class ParameterCreatorTest extends BaseTest {

	@Test
	public void test() {
		Map<String, Parameter> parmsByTag = null;
		final IntegerArguments args = new IntegerArguments();
		final ParameterCreator creator = new ParameterCreator(args);
		parmsByTag = creator.generateParametersForArgumentBean();
		final Parameter p = parmsByTag.get("intValue");
		assertNotNull(p);
		assertTrue(p instanceof IntParam);
	}

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testTwo() {
		final IntegerArguments args = new IntegerArguments();
		final ParameterCreator creator = new ParameterCreator(args, null, "");
		Map<String, Parameter> parmsByTag = creator.generateParametersForArgumentBean();
		final Parameter p = parmsByTag.get("intValue");
		assertNotNull(p);
	}
}
