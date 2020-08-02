package org.javautil.properties;

public interface PropertyManagement {

	boolean getBooleanProperty(String key, boolean dflt);

	boolean getBooleanPropertyNoWarn(String key, boolean dflt);

	String getMandatoryProperty(String key) throws java.lang.IllegalStateException;

	String getProperty(String key);

	/*
	 *
	 * @param key property name
	 * 
	 * @return Associated property.
	 * 
	 * @deprecated should not use netProperties, usage is not discouraged, this is a
	 * developement note
	 */
	@Deprecated
    String getProperty(String key, boolean warn);

	String getProperty(String key, String dflt);

	/*
	 * Get the property names sorted by key.
	 * 
	 * @return The property names
	 */

	String[] getPropertyNames();

	String getPropertyNoWarn(String key);

	/*
	 * Returns true if the key exists and the value is true.
	 *
	 * @param key
	 * 
	 * @return is the value of the specified key true?
	 */

	boolean isTrue(String key);

}