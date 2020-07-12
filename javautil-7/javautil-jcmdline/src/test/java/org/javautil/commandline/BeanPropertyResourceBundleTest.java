package org.javautil.commandline;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.PropertyResourceBundle;

import org.javautil.poi.workbook.WorkbookWriterArguments;
import org.junit.Test;

public class BeanPropertyResourceBundleTest {

	@Test
	public void test()  {
		WorkbookWriterArguments bean = new WorkbookWriterArguments();
		PropertyResourceBundle brp = BeanPropertyResourceBundle.getPropertyResourceBundle(bean);
		assertNotNull(brp);
	}
}
