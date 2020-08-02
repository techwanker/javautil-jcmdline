package org.javautil.commandline;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanPropertyResourceBundle {

	private transient static final Logger logger = LoggerFactory.getLogger(BeanPropertyResourceBundle.class);

	/**
	 * Gets a property resource bundle for a bean enforcing the file is 
	 * <ul>
	 * <li>a .properties</li?
	 * <li> in the same package as the bean
	 * </ul>
	 * 
	 * For example a class of org.javautil.poi.workbook.WorkbookArgs would have a 
	 * resource name of "org/javautil.poi.WorkbookArgs.properties
	 * 
	 * This is convention over configuration.
	 * 
	 * @param bean a bean for 
	 * @return the PropertyResourceBundle3
	 */
	public static PropertyResourceBundle getPropertyResourceBundle(Object bean)  {
		PropertyResourceBundle prop = null;
		String propertiesFilename = bean.getClass().getCanonicalName() + ".properties";
		logger.debug("bean {} propertiesFileName {}", bean.getClass(), propertiesFilename);
		InputStream is = getResource(bean);
		logger.debug("properties loaded " + propertiesFilename);
		
		try {
			prop = new PropertyResourceBundle(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return prop;
	}


	public static InputStream getResource(Object bean) { 
		if (bean == null) { 
			throw new IllegalArgumentException("bean is null");
		}
	
		//String propertiesFileName = getClass().getName() + ".properties";
		String propertiesFileName = bean.getClass().getName();
		propertiesFileName  = propertiesFileName.replace(".","/");
		propertiesFileName = propertiesFileName + ".properties";
		propertiesFileName = "/" + propertiesFileName;

		InputStream is = bean.getClass().getResourceAsStream(propertiesFileName);
		if (is == null) {
			throw new IllegalArgumentException("Unable to load resource " + propertiesFileName );
		}
		return is;
	}

}
