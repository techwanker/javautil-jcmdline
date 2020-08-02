package org.javautil.lang;

public interface ExceptionHandler {
	void handleException(Exception exception);

	/**
	 * Release any resources held.
	 */
	void dispose();

	void handleException(Exception exception, boolean printStackTrace);
}
