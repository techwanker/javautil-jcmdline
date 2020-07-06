package org.javautil.core.sql;

public class BindPair {
	
	private String name;
	
	private String stringValue;
	
	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public BindPair(String param) {
		int equalIndex = param.indexOf('=');
		String prefix = param.substring(0,equalIndex);
		String equals = param.substring(equalIndex,equalIndex-1);
		String suffix = param.substring(equalIndex+1);
		int len = prefix.length() + equals.length() + suffix.length();
		assert(len == param.length());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
