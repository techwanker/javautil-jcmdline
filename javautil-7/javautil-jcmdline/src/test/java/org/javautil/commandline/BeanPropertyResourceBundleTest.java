package org.javautil.commandline;

import static org.junit.Assert.assertNotNull;

import java.util.PropertyResourceBundle;

import org.javautil.poi.workbook.WorkbookWriterArgumentsForTest;
import org.junit.Test;

public class BeanPropertyResourceBundleTest {

	@Test
	public void test()  {
		WorkbookWriterArgumentsForTest bean = new WorkbookWriterArgumentsForTest();
		PropertyResourceBundle brp = BeanPropertyResourceBundle.getPropertyResourceBundle(bean);
		assertNotNull(brp);
	}
}
